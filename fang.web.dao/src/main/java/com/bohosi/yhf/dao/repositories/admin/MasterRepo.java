package com.bohosi.yhf.dao.repositories.admin;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.bohosi.yhf.dao.entity.admin.Master;

public interface MasterRepo extends CrudRepository<Master, Serializable>
{
	public Master findByMobileOrEmail(String mobile, String email);
	
}
