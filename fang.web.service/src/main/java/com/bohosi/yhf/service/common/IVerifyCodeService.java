package com.bohosi.yhf.service.common;

import com.bohosi.yhf.dao.entity.common.VerifyCode;

public interface IVerifyCodeService
{

	public void insertNewCode(VerifyCode code);

	public String findLatestCodeByPhone(String phone);
	
	public void sendOrderSmsNotice(String orderNo);
}
