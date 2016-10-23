package com.ddkfang.api.controller.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ddkfang.api.bean.DayPrice;
import com.ddkfang.api.bean.TotalPrice;
import com.ddkfang.api.controller.user.UserController;
import com.ddkfang.constant.HttpStatusConstant;
import com.ddkfang.dao.entity.order.Order;
import com.ddkfang.dao.entity.rooms.Room;
import com.ddkfang.dao.entity.rooms.RoomPriceCalendar;
import com.ddkfang.dao.entity.user.Booker;
import com.ddkfang.exception.OrderDateConflictException;
import com.ddkfang.exception.OrderPriceException;
import com.ddkfang.service.order.IOrdersService;
import com.ddkfang.service.rooms.IRoomBasic;
import com.ddkfang.util.priceCalendar.PriceCalendarUtil;

@RestController
@RequestMapping("/api/order")
public class OrderController
{

	private final static Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	IOrdersService ordersService;

	@Autowired
	IRoomBasic roomBasic;

	@RequestMapping(value = "createOrder", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> createOrder(@RequestBody JSONObject json, HttpServletRequest request)
			throws Exception
	{

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String roomId = json.getString("roomId");
		String contactPhone = json.getString("contactPhone");
		String contactName = json.getString("contactName");
		String checkInDate = json.getString("checkInDate");
		String checkOutDate = json.getString("checkOutDate");
		int channel = json.getIntValue("channel");
		int price = json.getIntValue("price");
		try
		{
			Map<String, Object> infoMap = new HashMap<String, Object>();
			infoMap.put("roomId", roomId);
			infoMap.put("contactPhone", contactPhone);
			infoMap.put("contactName", contactName);
			infoMap.put("checkInDate", checkInDate);
			infoMap.put("checkOutDate", checkOutDate);
			infoMap.put("channel", channel);

			Booker bk = (Booker) request.getSession().getAttribute("user");
			if (bk == null)
			{
				throw new Exception();
			}
			infoMap.put("bookerId", bk.getId() == null ? "1" : bk.getId());
			//计算订单价格
			Room room = roomBasic.getRoomDetailById(roomId);
			//获取用户所选区间的已设置价格日历
			Map<String, RoomPriceCalendar> map = roomBasic.getRoomPriceCalendar(roomId, checkInDate, checkOutDate);
			int days = PriceCalendarUtil.dateDiff(checkOutDate, checkInDate);
			Set<String> cal = PriceCalendarUtil.genCalendarWithStr(checkInDate, days);
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

			if (price != totalPrice)
			{
				throw new OrderPriceException();
			}
			infoMap.put("price", totalPrice);
			infoMap.put("basicPrice", totalBasicPrice);
			Order order = ordersService.createOrder(infoMap, cal);
			responseMap.put("orderId", order.getId());
			responseMap.put("lastpay", order.getLastPayTime());
			responseMap.put("status", "A00000");
			responseMap.put("msg", "ok");
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (OrderPriceException e)
		{
			responseMap.put("status", "A00001");
			responseMap.put("msg", "价格计算出现问题，请刷新重试！");
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (OrderDateConflictException e)
		{
			responseMap.put("status", "A00002");
			responseMap.put("msg", "预定日期有冲突,手慢可能已被抢请刷新！");
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e)
		{
			e.printStackTrace();
			responseMap.put("status", "A00003");
			responseMap.put("msg", "系统错误");
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "getOrdersByBooker", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getOrdersByBooker(
			@RequestParam(value = "status", required = true) int status, HttpServletRequest request, Pageable pageable)
	{
		Booker user = (Booker) request.getSession().getAttribute("user");
		Map<String, Object> responseMap = new HashMap<String, Object>();
		Page<Order> po;
		try
		{
			if (status == 0)
			{
				//全部
				po = ordersService.getOrdersByBooker(user.getId(), pageable);
			} else
			{
				po = ordersService.getOrdersByBookerAndStatus(user.getId(), status, pageable);
			}
			responseMap.put("data", po);
			responseMap.put("status", HttpStatusConstant.orderStatus.ok.getCode());
			responseMap.put("msg", HttpStatusConstant.orderStatus.ok.getMsg());

			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e)
		{
			logger.error("error in getOrdersByBooker:{}", e);
		}

		return null;
	}

	@RequestMapping(value = "getOrdersById", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getOrdersById(@RequestParam(value = "id", required = true) String id,
			HttpServletRequest request)
	{
		Map<String, Object> responseMap = new HashMap<String, Object>();
		try
		{
			Order or = ordersService.getOrdersById(id);
			Room room = roomBasic.getRoomDetailById(or.getRoomId());
			responseMap.put("order", or);
			responseMap.put("room", room);
			responseMap.put("status", HttpStatusConstant.orderStatus.ok.getCode());
			responseMap.put("msg", HttpStatusConstant.orderStatus.ok.getMsg());
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Async
	@RequestMapping(value = "verifyOrderOvertime", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> verifyOrderOvertime(
			@RequestParam(value = "id", required = true) String id, HttpServletRequest request)
	{
		Map<String, Object> responseMap = new HashMap<String, Object>();
		try
		{
			Order or = ordersService.getOrdersById(id);

			if (or.getStatus() == 1  && or.getLastPayTime().before(new Date()))
			{
				//订单超时
				or.setStatus(3);
				or.setUserDisplayStatus(4);
				ordersService.saveOrder(or);
				ordersService.updatePriceCalendarForOvertimeOrder(or);
			}
			responseMap.put("status", HttpStatusConstant.orderStatus.ok.getCode());
			responseMap.put("msg", HttpStatusConstant.orderStatus.ok.getMsg());
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
