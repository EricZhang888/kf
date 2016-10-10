package com.ddkfang.dao.repositories.order;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.ddkfang.dao.entity.order.Order;

public interface OrderRepo extends CrudRepository<Order, Serializable>{
	
}
