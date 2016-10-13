package com.ddkfang.dao.repositories.order;


import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ddkfang.dao.entity.order.Order;

public interface OrderRepo extends PagingAndSortingRepository<Order, Serializable>{
	
	public Page<Order> findByBookerIdAndStatus(String userId, int status, Pageable pageable);
	
	public Page<Order> findByBookerId(String userId, Pageable pageable);
}
