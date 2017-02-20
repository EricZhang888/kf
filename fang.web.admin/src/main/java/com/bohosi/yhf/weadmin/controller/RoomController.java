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
}