package com.ddkfang.dao.repositories.order;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.ddkfang.dao.entity.order.WxpayRes;

public interface WxpayRepo extends CrudRepository<WxpayRes, Serializable>
{

}
