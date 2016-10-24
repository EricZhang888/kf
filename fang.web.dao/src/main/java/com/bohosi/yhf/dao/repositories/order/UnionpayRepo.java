package com.bohosi.yhf.dao.repositories.order;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.bohosi.yhf.dao.entity.order.UnionpayRes;

public interface UnionpayRepo extends CrudRepository<UnionpayRes, Serializable>
{

}
