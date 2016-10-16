package com.ddkfang.api.controller.order;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ddkfang.dao.entity.order.Order;
import com.ddkfang.service.order.IOrdersService;
import com.ddkfang.service.orderpay.union.IUnionPayService;

@RestController
@RequestMapping("/api/order/pay")
public class OrderPayController {
	
	@Autowired
	IOrdersService ordersService;
	
	@Autowired
	IUnionPayService unionPayService;

	@RequestMapping(value="unionpay", method=RequestMethod.GET)
	public void createOrder(@RequestParam(name="order_id",required=true) String orderId,
			HttpServletResponse resp,
			HttpServletRequest request) throws Exception{
		Order or = ordersService.getOrdersById(orderId);
		//判断order是否过期
		if(or.getLastPayTime().before(new Date())) {
			resp.getWriter().write("订单超时");
			String s = "/html/order/error.html?msg=订单超时&redirect=/html/user/home/orders.html";
			resp.sendRedirect(s);
		} 
		String html = unionPayService.genPayData(or.getOrderNumber(), or.getPrice(), "01");
		resp.getWriter().write(html);
	}
}
