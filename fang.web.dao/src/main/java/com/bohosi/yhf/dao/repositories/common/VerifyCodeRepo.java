package com.bohosi.yhf.dao.repositories.common;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.bohosi.yhf.dao.entity.common.VerifyCode;

public interface VerifyCodeRepo extends CrudRepository<VerifyCode, Serializable>
{

	public VerifyCode findTop1ByPhoneOrderByCreateTimeDesc(String phone);
}
