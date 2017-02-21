package com.bohosi.yhf.weadmin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bohosi.yhf.dao.entity.order.OrderAdmin;
import com.bohosi.yhf.dao.entity.order.OrderCheckin;
import com.bohosi.yhf.dao.repositories.base.Criterion;
import com.bohosi.yhf.dao.repositories.base.SearchCriteria;
import com.bohosi.yhf.service.order.IOrdersService;

@Controller
@RequestMapping(value="order")
public class OrderController
{
	@Autowired
	IOrdersService ordersService;

	@RequestMapping(value = "orders", method = RequestMethod.GET)
	public String orders() {
		return "orders";
	}
	
	@RequestMapping(value = "queryOrder", method = RequestMethod.POST)
	public String queryOrder(HttpServletRequest req, Pageable pageable, Map<String, Object> model) {
		String bookerName = req.getParameter("bookerName");
		String bookerMobile = req.getParameter("bookerMobile");
		String orderNo = req.getParameter("orderNo");
		SearchCriteria criteria = SearchCriteria.Builder.create();
		
		if(bookerName != null && !bookerName.isEmpty()) {
			criteria.add(new Criterion("contactName", Criterion.Operator.EQ, bookerName));
		}
		if(bookerMobile != null && !bookerMobile.isEmpty()) {
			criteria.add(new Criterion("contactPhone", Criterion.Operator.LIKE, bookerMobile));
		}
		if(orderNo != null && !orderNo.isEmpty()) {
			criteria.add(new Criterion("orderNumber", Criterion.Operator.EQ, orderNo));
		}
		
		Page<OrderAdmin> orders = ordersService.searchOrders(criteria, pageable);
		model.put("list", orders.getContent());
		model.put("pages", orders.getTotalPages());
		model.put("curPage", orders.getNumber());
		model.put("total", orders.getTotalElements());
		return "orders";
	}
	
	
	@RequestMapping(value = "orderCheckIn", method = RequestMethod.POST)
	public String orderCheckIn(HttpServletRequest req) {
		String orderRoomId = req.getParameter("orderRoomId");
		String orderId = req.getParameter("orderId");
		int peopleNumber = Integer.valueOf(req.getParameter("number"));
		String peopleIds = req.getParameter("ids").replace("，", ",");
		int yajinNum = Integer.valueOf(req.getParameter("yajinNum"));
		int yajinWay = Integer.valueOf(req.getParameter("yajinWay"));
		String note = req.getParameter("note");
		
		OrderCheckin ocin = new OrderCheckin(orderRoomId, orderId, peopleNumber, peopleIds, yajinNum, yajinWay, note);
		try {
			ordersService.orderCheckIn(orderId, ocin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "orders";
	}
	
	@RequestMapping(value = "orderCheckout", method = RequestMethod.GET)
	public String orderCheckout(HttpServletRequest req, Map<String, Object> model) {
		String orderRoomId = req.getParameter("orderRoomId");
		String orderId = req.getParameter("orderId");
		//取到当初入住的信息
		try {
			OrderCheckin checkIn = ordersService.getOrderCheckIn(orderId);
			model.put("checkinInfo", checkIn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "orderCheckout";
	}
	
	@RequestMapping(value = "addOrder", method = RequestMethod.GET)
	public String addOrder() {
		return "addOrder";
	}
}
