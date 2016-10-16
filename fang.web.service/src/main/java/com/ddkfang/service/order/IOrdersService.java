package com.ddkfang.service.order;


import java.util.Map;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ddkfang.dao.entity.order.Order;

public interface IOrdersService {

	public Order createOrder(Map<String, Object> infoMap, Set<String> dayDetail) throws Exception;
	
	public Order saveOrder(Order order) throws Exception;
	
	public void updatePriceCalendarForOvertimeOrder(Order or) throws Exception;
	
	public Page<Order> getOrdersByBookerAndStatus(String userId, int status, Pageable pageable) throws Exception;
	
	public Page<Order> getOrdersByBooker(String userId, Pageable pageable) throws Exception;
	
	public Order getOrdersById(String id) throws Exception;
	
	public void updateExpiredOrdersCalendar() throws Exception;
}
