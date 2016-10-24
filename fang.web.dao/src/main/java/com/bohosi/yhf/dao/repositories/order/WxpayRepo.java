package com.bohosi.yhf.dao.repositories.order;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.bohosi.yhf.dao.entity.order.WxpayRes;

public interface WxpayRepo extends CrudRepository<WxpayRes, Serializable>
{

}
