package com.bohosi.yhf.dao.repositories.user;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.bohosi.yhf.dao.entity.user.Booker;

public interface UserRepo extends CrudRepository<Booker, Serializable>
{

	public Booker findByBookerMobile(String mobile);

	public Booker findByBookerEmail(String mobile);
}
