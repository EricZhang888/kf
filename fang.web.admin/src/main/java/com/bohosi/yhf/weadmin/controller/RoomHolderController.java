package com.bohosi.yhf.weadmin.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bohosi.yhf.dao.entity.rooms.RoomHolder;
import com.bohosi.yhf.dao.repositories.base.Criterion;
import com.bohosi.yhf.dao.repositories.base.SearchCriteria;
import com.bohosi.yhf.service.rooms.IRoomHolder;

@Controller
@RequestMapping(value="roomHolder")
public class RoomHolderController
{
	@Autowired
	IRoomHolder roomholderService;

	@RequestMapping(value = "roomHolders", method = RequestMethod.GET)
	public String roomHolders() {
		return "roomHolders";
	}
	
	@RequestMapping(value = "queryRoomHolder", method = RequestMethod.POST)
	public String queryRoomHolder(HttpServletRequest req, Pageable pageable, Map<String, Object> model) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String holderName = req.getParameter("holderName");
		String holderMobile = req.getParameter("holderMobile");
		
		SearchCriteria criteria = SearchCriteria.Builder.create();
		if(!StringUtils.isEmpty(holderName)) {
			criteria.add(new Criterion("name", Criterion.Operator.EQ, holderName));
		}
		if(!StringUtils.isEmpty(holderMobile)) {
			criteria.add(new Criterion("mobile", Criterion.Operator.EQ, holderMobile));
		}
		Page<RoomHolder> rooms = roomholderService.getRoomHoldersByCriteria(criteria, pageable);
		model.put("list", rooms.getContent());
		model.put("pages", rooms.getTotalPages());
		model.put("curPage", rooms.getNumber());
		model.put("total", rooms.getTotalElements());
		return "roomHolders";
	}
}
