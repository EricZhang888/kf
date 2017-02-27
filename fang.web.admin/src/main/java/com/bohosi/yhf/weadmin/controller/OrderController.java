package com.bohosi.yhf.weadmin.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bohosi.yhf.constant.OrderStatus;
import com.bohosi.yhf.constant.OrderStatusUserDisney;
import com.bohosi.yhf.constant.PriceCalendarStatus;
import com.bohosi.yhf.dao.entity.order.Order;
import com.bohosi.yhf.dao.entity.order.OrderAdmin;
import com.bohosi.yhf.dao.entity.order.OrderCheckin;
import com.bohosi.yhf.dao.entity.order.OrderCheckout;
import com.bohosi.yhf.dao.repositories.base.Criterion;
import com.bohosi.yhf.dao.repositories.base.SearchCriteria;
import com.bohosi.yhf.service.order.IOrdersService;
import com.bohosi.yhf.service.rooms.IRoomPrice;
import com.bohosi.yhf.util.priceCalendar.PriceCalendarUtil;

@Controller
@RequestMapping(value="order")
public class OrderController
{
	@Autowired
	IOrdersService ordersService;
	
	@Autowired
	IRoomPrice roomPrice;

	@RequestMapping(value = "orders", method = RequestMethod.GET)
	public String orders() {
		return "orders";
	}
	
	@RequestMapping(value = "queryOrder", method = RequestMethod.POST)
	public String queryOrder(HttpServletRequest req, Pageable pageable, Map<String, Object> model) {
		try
		{
			System.out.println(req.getCharacterEncoding());
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String bookerMobile = req.getParameter("bookerMobile");
		String bookerName = req.getParameter("bookerName");
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
		try
		{
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	
	@RequestMapping(value = "doOrderCheckOut", method = RequestMethod.POST)
	public String doOrderCheckOut(HttpServletRequest req, Map<String, Object> model) {
		try
		{
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String orderRoomId = req.getParameter("orderRoomId");
		String orderId = req.getParameter("orderId");
		int yajinTuiNum = Integer.valueOf(req.getParameter("yajinTuiNum"));
		int yajinTuiWay = Integer.valueOf(req.getParameter("yajinTuiWay"));
		String note = req.getParameter("note");
		
		OrderCheckout ocOut = new OrderCheckout(orderRoomId, orderId, yajinTuiNum, yajinTuiWay, note);
		//取到当初入住的信息
		try {
			ordersService.orderCheckOut(orderId, ocOut);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "orders";
	}
	
	
	@RequestMapping(value = "submitOrderOffline", method = RequestMethod.POST)
	public String submitOrderOffline(HttpServletRequest req) {
		try
		{
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String roomId = req.getParameter("roomId");
		String beginDate = req.getParameter("beginDate");
		String endDate = req.getParameter("endDate");
		String contactName = req.getParameter("contact");
		String contactPhone = req.getParameter("contactPhone");
		int totalPrice = Integer.valueOf(req.getParameter("totalPrice"));
		int peopleNumber = Integer.valueOf(req.getParameter("number"));
		String peopleIds = req.getParameter("ids");
		int yajinNum = Integer.valueOf(req.getParameter("yajinNum"));
		int yajinWay = Integer.valueOf(req.getParameter("yajinWay"));
		String note = req.getParameter("note");
		int fangpayWay = Integer.valueOf(req.getParameter("fangpayWay"));
		int basicPrice = Integer.valueOf(req.getParameter("basicPrice"));
		int dayPrice = Integer.valueOf(req.getParameter("dayPrice"));
		int channel = 1; //表示现场订单
		
		//组织创建订单的Map
		int days;
		try
		{
			days = PriceCalendarUtil.dateDiff(endDate, beginDate);
			Set<String> cal = PriceCalendarUtil.genCalendarWithStr(beginDate, days);
			Map<String, Object> infoMap = new HashMap<String, Object>();
			
			infoMap.put("roomId", roomId);
			infoMap.put("contactPhone", contactPhone);
			infoMap.put("contactName", contactName);
			infoMap.put("checkInDate", beginDate);
			infoMap.put("checkOutDate", endDate);
			infoMap.put("channel", channel);
			infoMap.put("bookerId", 1);
			
			int totalBasicPrice = days * basicPrice;
			infoMap.put("price", totalPrice);
			infoMap.put("basicPrice", totalBasicPrice);
			Order order = ordersService.createOrder(infoMap, cal);
			//更新价格日历状态
			if (order.getId() != null)
			{
				for (String s : cal)
				{
					roomPrice.saveOrUpdatePriceCalendar(roomId, PriceCalendarUtil.stringToSimpleDate(s), 
															PriceCalendarStatus.needpaid.getValue(),
															dayPrice);
				}
			}
			//点单付款处理
			order.setStatus(OrderStatus.paid.getValue());
			order.setUserDisplayStatus(OrderStatusUserDisney.paid.getValue());
			order.setPayment(fangpayWay);
			ordersService.saveOrder(order);
			//更新订单直接变成入住处理
			OrderCheckin ocin = new OrderCheckin(roomId, order.getId(), peopleNumber, peopleIds, yajinNum, yajinWay, note);
			ordersService.orderCheckIn(order.getId(), ocin);
			
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "orders";
	}
}
