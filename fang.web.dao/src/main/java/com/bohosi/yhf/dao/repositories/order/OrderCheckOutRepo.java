package com.bohosi.yhf.dao.repositories.order;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bohosi.yhf.dao.entity.order.OrderCheckout;

public interface OrderCheckOutRepo extends PagingAndSortingRepository<OrderCheckout, Serializable>
{

}
