package com.bohosi.yhf.weadmin.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.bohosi.yhf.dao.entity.rooms.DayPrice;
import com.bohosi.yhf.dao.entity.rooms.PriceCalendar;
import com.bohosi.yhf.dao.entity.rooms.Room;
import com.bohosi.yhf.dao.entity.rooms.RoomPriceCalendar;
import com.bohosi.yhf.dao.entity.rooms.TotalPrice;
import com.bohosi.yhf.dao.repositories.base.SearchCriteria;
import com.bohosi.yhf.service.rooms.IRoomBasic;
import com.bohosi.yhf.util.priceCalendar.PriceCalendarUtil;

@Controller
@RequestMapping(value="room")
public class RoomController
{
	@Autowired
	IRoomBasic roomService;

	@RequestMapping(value = "rooms", method = RequestMethod.GET)
	public String rooms() {
		return "rooms";
	}
	
	@RequestMapping(value = "queryRoom", method = RequestMethod.POST)
	public String queryRoom(HttpServletRequest req, Pageable pageable, Map<String, Object> model) {

		SearchCriteria criteria = SearchCriteria.Builder.create();
		Page<Room> rooms = roomService.getAllAvaliableRooms(criteria, pageable);
		model.put("list", rooms.getContent());
		model.put("pages", rooms.getTotalPages());
		model.put("curPage", rooms.getNumber());
		model.put("total", rooms.getTotalElements());
		return "rooms";
	}
	
	@RequestMapping(value = "offlineCheckin", method = RequestMethod.GET)
	public String addOrder() {
		return "offlineCheckin";
	}
	
	@RequestMapping(value = "editRoom", method = RequestMethod.GET)
	public String editRoom(HttpServletRequest req, Pageable pageable, Map<String, Object> model) {
		String roomId = req.getParameter("roomId");
		req.setAttribute("roomId", roomId);
		
		SearchCriteria criteria = SearchCriteria.Builder.create();
		
		Page<Room> rooms = roomService.getAllAvaliableRooms(criteria, pageable);
		model.put("list", rooms.getContent());
		model.put("pages", rooms.getTotalPages());
		model.put("curPage", rooms.getNumber());
		model.put("total", rooms.getTotalElements());
		
		return "editRoom";
	}
	
	//设置价格页面跳转
	@RequestMapping(value = "roomEditPriceCalendar", method = RequestMethod.GET)
	public String roomEditPriceCalendar(HttpServletRequest req, Map<String, Object> model) {
		//获取房间信息
		String roomId = req.getParameter("roomId");
		Room room = roomService.getRoomDetailById(roomId);
		model.put("room", room);
		//获取现有价格日历
		try {
			Set<String> cal = PriceCalendarUtil.genCalendar();
			String[] dates = new String[]{};
			dates = cal.toArray(dates);
			List<PriceCalendar> calList = new ArrayList<PriceCalendar>();
			
			//获取系统已设置的价格日历
			Map<String, RoomPriceCalendar> map = roomService.getRoomPriceCalendar(roomId, dates[0], dates[dates.length - 1]);
			calList = roomService.fullfillRoomPriceCalendar(room, cal, map);
			model.put("priceCalendar", JSON.toJSON(calList));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "roomEditPriceCalendar";
	}
	
	//现场开房查询可开房源
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "availableRoomOffline", method = RequestMethod.POST)
	public String availableRoomOffline(HttpServletRequest req, Pageable pageable, Map<String, Object> model) {
		String checkinDate = req.getParameter("checkinDate");
		String checkoutDate = req.getParameter("checkoutDate");
		
		SearchCriteria criteria = SearchCriteria.Builder.create();
		Map<String, Object> roomsMap = roomService.getAllAvaliableRooms(criteria, pageable, null);
		
		try
		{
			List<RoomPriceCalendar> priceList = roomService.findUnavailableRoomIdByDate(PriceCalendarUtil.stringToSimpleDate(checkinDate), PriceCalendarUtil.stringToSimpleDate(checkoutDate), 0);
			ArrayList<Room> roomList= (ArrayList<Room>)roomsMap.get("resultList");
			ArrayList<Room> needToRemove = new ArrayList<Room>();
			//从所有房间中移除当前不可以入住的
			for(RoomPriceCalendar rpc : priceList) {
				String unavailable = rpc.getId().getRoomId();
				for(Room r : roomList) {
					if(r.getRoomId().equals(unavailable)) {
						needToRemove.add(r);
					}
				}
			}
			roomList.removeAll(needToRemove);
			Page<Room> roomsPage = new PageImpl<Room>(roomList, (Pageable)roomsMap.get("pageable"), (Long)roomsMap.get("total"));
			model.put("rooms", roomsPage.getContent());
			model.put("pages", roomsPage.getTotalPages());
			model.put("curPage", roomsPage.getNumber());
			model.put("total", roomsPage.getTotalElements());
			model.put("beginDate", checkinDate);
			model.put("endDate", checkoutDate);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "offlineCheckin";
	}
	
	@RequestMapping(value = "orderOffline", method = RequestMethod.GET)
	public String orderOffline(HttpServletRequest req, Map<String, Object> model) throws ParseException {
		//获取将入住的房屋信息
		String roomId = req.getParameter("roomId");
		String beginDate = req.getParameter("beginDate");
		String endDate = req.getParameter("endDate");
		Room room = roomService.getRoomDetailById(roomId);
		model.put("room", room);
		//获取实际入住的价格日历与清单
		Map<String, RoomPriceCalendar> map = roomService.getRoomPriceCalendar(roomId, beginDate, endDate);
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
		model.put("priceList", tp);
		model.put("beginDate", beginDate);
		model.put("endDate", endDate);
		model.put("roomId", roomId);
		return "orderOffline";
	}
}
