package com.ddkfang.dao.repositories.order;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ddkfang.dao.entity.order.Order;

public interface OrderRepo extends PagingAndSortingRepository<Order, Serializable>
{

	public Page<Order> findByBookerIdAndStatusOrderByCreateTimeDesc(String userId, int status, Pageable pageable);

	public Page<Order> findByBookerIdOrderByCreateTimeDesc(String userId, Pageable pageable);

	public List<Order> findByStatus(int status);

	public Order findById(String id);
	
	@Query("select o.status, count(o.status) from Order o where o.bookerId = ? group by o.status")
	public List<Object[]> countOrderStatus(String bookerId);
	
	public Order findByOrderNumber(String orderNo);
}
