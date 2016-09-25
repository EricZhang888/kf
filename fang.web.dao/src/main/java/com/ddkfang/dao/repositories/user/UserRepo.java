package com.ddkfang.dao.repositories.user;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.ddkfang.dao.entity.user.Booker;

public interface UserRepo extends CrudRepository<Booker, Serializable> {

	public Booker findByBookerMobile(String mobile);
	
	public Booker findByBookerEmail(String mobile);
}
