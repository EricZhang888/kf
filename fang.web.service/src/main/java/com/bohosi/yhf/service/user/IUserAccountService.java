package com.bohosi.yhf.service.user;

import com.bohosi.yhf.dao.entity.user.Booker;

public interface IUserAccountService
{

	public Booker getUserByMobile(String mobile);

	public Booker getUserByEmail(String email);

	public Booker createUser(Booker user);

	public boolean checkUserExistByMobile(String mobile);

	public boolean updateUserPasswordByMobile(String mobile, String passwd) throws Exception;

	public boolean updateUserPasswordByOld(Booker user, String newPasswd) throws Exception;
}
