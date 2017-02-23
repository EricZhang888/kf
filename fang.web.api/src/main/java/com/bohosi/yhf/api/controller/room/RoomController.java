package com.bohosi.yhf.api.controller.room;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bohosi.yhf.api.bean.DayPrice;
import com.bohosi.yhf.api.bean.TotalPrice;
import com.bohosi.yhf.constant.HttpStatusConstant;
import com.bohosi.yhf.dao.entity.rooms.PriceCalendar;
import com.bohosi.yhf.dao.entity.rooms.Room;
import com.bohosi.yhf.dao.entity.rooms.RoomPriceCalendar;
import com.bohosi.yhf.service.rooms.IRoomBasic;
import com.bohosi.yhf.util.priceCalendar.PriceCalendarUtil;

@RestController
@RequestMapping("/api/room")
public class RoomController
{

	@Autowired
	IRoomBasic roomBasic;

	@RequestMapping(value = "getRoomDetail", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getRoomDetail(@RequestParam(value = "id", required = true) String id,
			HttpServletRequest request)
	{

		Map<String, Object> responseMap = new HashMap<String, Object>();
		try
		{

			Room room = roomBasic.getRoomDetailById(id);
			if (room != null)
			{
				responseMap.put("data", room);
				responseMap.put("status", HttpStatusConstant.roomStatus.ok.getCode());
				responseMap.put("msg", HttpStatusConstant.roomStatus.ok.getMsg());

				return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
			} else
			{
				responseMap.put("data", null);
				responseMap.put("status", HttpStatusConstant.roomStatus.roomNotExist.getCode());
				responseMap.put("msg", HttpStatusConstant.roomStatus.roomNotExist.getMsg());
				return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			responseMap.put("data", null);
			responseMap.put("status", HttpStatusConstant.roomStatus.roomNotAvalibale.getCode());
			responseMap.put("msg", HttpStatusConstant.roomStatus.roomNotAvalibale.getMsg());
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "getPriceCalendar", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getPriceCalendar(@RequestParam(value = "id", required = true) String id,
			HttpServletRequest request)
	{
		Map<String, Object> responseMap = new HashMap<String, Object>();
		try
		{
			//获取房间信息
			Room room = roomBasic.getRoomDetailById(id);

			//获取3个月的日历天数
			Set<String> cal = PriceCalendarUtil.genCalendar();
			String[] dates = new String[]{};
			dates = cal.toArray(dates);
			List<PriceCalendar> calList = new ArrayList<PriceCalendar>();

			//获取系统已设置的价格日历
			Map<String, RoomPriceCalendar> map = roomBasic.getRoomPriceCalendar(id, dates[0], dates[dates.length - 1]);
			calList = roomBasic.fullfillRoomPriceCalendar(room, cal, map);
			responseMap.put("data", calList);
			responseMap.put("status", HttpStatusConstant.roomStatus.ok.getCode());
			responseMap.put("msg", HttpStatusConstant.roomStatus.ok.getMsg());
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "calculateTotalPrice")
	public ResponseEntity<Map<String, Object>> calculateTotalPrice(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "beginDate", required = true) String beginDate,
			@RequestParam(value = "endDate", required = true) String endDate, HttpServletRequest request)
			throws ParseException
	{

		Map<String, Object> responseMap = new HashMap<String, Object>();
		Room room = roomBasic.getRoomDetailById(id);
		//获取用户所选区间的已设置价格日历
		Map<String, RoomPriceCalendar> map = roomBasic.getRoomPriceCalendar(id, beginDate, endDate);
		int days = PriceCalendarUtil.dateDiff(endDate, beginDate);
		Set<String> cal = PriceCalendarUtil.genCalendarWithStr(beginDate, days);
		List<DayPrice> dayDetailList = new ArrayList<DayPrice>();

		int totalPrice = 0;
		int totalBasicPrice = days * room.getRoomBasicPrice();

		TotalPrice tp = new TotalPrice();

		tp.setTotal_basic_price(totalBasicPrice);
		tp.setTotal_standard_price(totalBasicPrice);

		for (String s : cal)
		{
			DayPrice dp = new DayPrice();

			//通过日期匹配价格日历，如果没有匹配到 则使用Room默认价格
			RoomPriceCalendar rpc = map.get(s);
			dp.setDate(s);
			dp.setBasic_price(room.getRoomBasicPrice());

			if (rpc != null)
			{
				totalPrice += rpc.getRoomDatePrice();
				dp.setPreferential_price(rpc.getRoomDatePrice());
				dp.setStandard_price(rpc.getRoomDatePrice());
			} else
			{
				totalPrice += room.getRoomPrice();
				dp.setStandard_price(room.getRoomPrice());
				dp.setPreferential_price(room.getRoomBasicPrice());
			}
			dayDetailList.add(dp);
		}
		tp.setTotal_price(totalPrice);
		tp.setDay_price_list(dayDetailList);

		responseMap.put("data", tp);
		responseMap.put("status", HttpStatusConstant.roomStatus.ok.getCode());
		responseMap.put("msg", HttpStatusConstant.roomStatus.ok.getMsg());
		return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
	}

	public static void main(String[] args)
	{
		Date d = new Date();
	}
}
