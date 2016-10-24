package com.bohosi.yhf.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bohosi.yhf.dao.entity.user.Booker;
import com.bohosi.yhf.dao.repositories.user.UserRepo;
import com.bohosi.yhf.service.user.IUserAccountService;
import com.bohosi.yhf.util.verify.BCryptUtil;
@Service
public class UserAccountServiceImpl implements IUserAccountService
{

	@Autowired
	UserRepo userRepo;

	public boolean checkUserExistByMobile(String mobile)
	{
		return !(userRepo.findByBookerMobile(mobile) == null);
	}

	public boolean updateUserPasswordByMobile(String mobile, String passwd) throws Exception
	{
		try
		{
			Booker user = userRepo.findByBookerMobile(mobile);
			user.setBookerPwd(BCryptUtil.genBcryptPwd(passwd));
			userRepo.save(user);
		} catch (Exception e)
		{
			throw e;
		}
		return true;
	}

	public Booker getUserByMobile(String mobile)
	{
		Booker user = userRepo.findByBookerMobile(mobile);
		return user;
	}

	public Booker getUserByEmail(String email)
	{
		Booker user = userRepo.findByBookerEmail(email);
		return user;
	}

	public boolean updateUserPasswordByOld(Booker user, String newPasswd) throws Exception
	{
		try
		{
			user.setBookerPwd(BCryptUtil.genBcryptPwd(newPasswd));
			userRepo.save(user);
			return true;
		} catch (Exception e)
		{
			return false;
		}
	}

	public Booker createUser(Booker user)
	{
		try
		{
			return userRepo.save(user);
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
