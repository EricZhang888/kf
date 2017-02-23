package com.bohosi.yhf.weadmin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bohosi.yhf.dao.entity.rooms.Room;
import com.bohosi.yhf.dao.repositories.base.Criterion;
import com.bohosi.yhf.dao.repositories.base.SearchCriteria;
import com.bohosi.yhf.service.rooms.IRoomBasic;

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
	
	@RequestMapping(value = "addOrder", method = RequestMethod.GET)
	public String addOrder() {
		return "addOrder";
	}
	
	@RequestMapping(value = "editRoom", method = RequestMethod.GET)
	public String editRoom(HttpServletRequest req, Pageable pageable, Map<String, Object> model) {
		String roomId = req.getParameter("roomId");
		req.setAttribute("roomId", roomId);
		roomService.getAllAmenity();
		//获取到指定ID的房间信息
		model.put("room", roomService.getRoomDetailById(roomId));
		
		return "editRoom";
	}
	
	//设置价格页面跳转
	@RequestMapping(value = "roomEditPriceCalendar", method = RequestMethod.GET)
	public String roomEditPriceCalendar(HttpServletRequest req, Map<String, Object> model) {
		//获取房间信息
		String roomId = req.getParameter("roomId");
		model.put("room", roomService.getRoomDetailById(roomId));
		
		//获取现有价格日历
		
		
		return "roomEditPriceCalendar";
	}
	
	//现场开房查询可开房源
	@RequestMapping(value = "availableRoomOffline", method = RequestMethod.GET)
	public String availableRoomOffline(HttpServletRequest req, Pageable pageable, Map<String, Object> model) {
		SearchCriteria criteria = SearchCriteria.Builder.create();
		Page<Room> rooms = roomService.getAllAvaliableRooms(criteria, pageable);
		return "addOrder";
	}
}
