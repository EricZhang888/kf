package com.ddkfang.service.common.impl;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddkfang.dao.entity.common.VerifyCode;
import com.ddkfang.dao.repositories.common.VerifyCodeRepo;
import com.ddkfang.service.common.IVerifyCodeService;
@Service
public class VerifyCodeServiceImpl implements IVerifyCodeService {

	@Autowired
	VerifyCodeRepo verifyCodeRepo;
	
	public void insertNewCode(VerifyCode code) {
		verifyCodeRepo.save(code);
	}

	public String findLatestCodeByPhone(String phone) {
		
		VerifyCode code =  verifyCodeRepo.findTop1ByPhoneOrderByCreateTimeDesc(phone);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE,-5);
		Timestamp time = new Timestamp(calendar.getTimeInMillis());
		//验证码5分钟有效期
		if(code != null && time.before(code.getCreateTime())) {
			return code.getCode();
		}
		return "";
	}

	
	public static void main(String[] args) {
		//Timestamp t1 = new Timestamp(new Date())
	}
}
