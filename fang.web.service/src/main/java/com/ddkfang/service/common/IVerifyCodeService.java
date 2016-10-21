package com.ddkfang.service.common;

import com.ddkfang.dao.entity.common.VerifyCode;

public interface IVerifyCodeService
{

	public void insertNewCode(VerifyCode code);

	public String findLatestCodeByPhone(String phone);
}
