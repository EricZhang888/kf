package com.ddkfang.dao.repositories.order;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.ddkfang.dao.entity.order.UnionpayRes;

public interface UnionpayRepo extends CrudRepository<UnionpayRes, Serializable>{

}
