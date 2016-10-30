package com.bohosi.yhf.dao.repositories.order.admin.impl;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.bohosi.yhf.dao.entity.order.Order;
import com.bohosi.yhf.dao.repositories.base.AbstractSearchableJpaRepository;

public class OrderAdminRepoImpl extends AbstractSearchableJpaRepository<Order>
{

	public Iterable<Order> findAll(Sort sort)
	{
		return null;
	}

	public Page<Order> findAll(Pageable pageable)
	{
		return null;
	}

	public <S extends Order> S save(S entity)
	{
		return null;
	}

	public <S extends Order> Iterable<S> save(Iterable<S> entities)
	{
		return null;
	}

	public Order findOne(Serializable id)
	{
		return null;
	}

	public boolean exists(Serializable id)
	{
		return false;
	}

	public Iterable<Order> findAll()
	{
		return null;
	}

	public Iterable<Order> findAll(Iterable<Serializable> ids)
	{
		return null;
	}

	public long count()
	{
		return 0;
	}

	public void delete(Serializable id)
	{
		
	}

	public void delete(Order entity)
	{
		
	}

	public void delete(Iterable<? extends Order> entities)
	{
		
	}

	public void deleteAll()
	{
		
	}

	

	

}
