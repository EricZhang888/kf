package com.ddkfang.service.user;

import com.ddkfang.dao.entity.user.Booker;

public interface IUserAccountService {

	public Booker getUserByMobile(String mobile);
	
	public Booker getUserByEmail(String email);
	
	public boolean checkUserExistByMobile(String mobile);
	
	public boolean updateUserPasswordByMobile(String mobile, String passwd) throws Exception;
	
	public boolean updateUserPasswordByOld(Booker user, String newPasswd) throws Exception;
}
