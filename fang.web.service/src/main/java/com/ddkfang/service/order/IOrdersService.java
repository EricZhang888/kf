package com.ddkfang.service.order;


import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ddkfang.dao.entity.order.Order;

public interface IOrdersService {

	public String createOrder(Map<String, Object> infoMap) throws Exception;
	
	public Page<Order> getOrdersByBookerAndStatus(String userId, int status, Pageable pageable) throws Exception;
	
	public Page<Order> getOrdersByBooker(String userId, Pageable pageable) throws Exception;
	
	public Order getOrdersById(String id) throws Exception;
}
