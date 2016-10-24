package com.bohosi.yhf.api.controller.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bohosi.yhf.api.controller.BaseController;
import com.bohosi.yhf.constant.HttpStatusConstant;
import com.bohosi.yhf.dao.entity.common.VerifyCode;
import com.bohosi.yhf.service.common.IVerifyCodeService;
import com.bohosi.yhf.util.verify.VerifyCodeUtil;
@RestController
@RequestMapping("/api/smsUtil")
public class SmsUtilController extends BaseController
{

	@Autowired
	IVerifyCodeService verifyCodeService;

	@RequestMapping(value = "sendVerifyCode", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> sendSms(@RequestBody JSONObject json)
	{

		Map<String, Object> responseMap = new HashMap<String, Object>();
		try
		{
			//gen sms code
			String code = VerifyCodeUtil.createSmsCode();

			boolean isSent = VerifyCodeUtil.sendVerifyCode(json.getString("mobile"), code,
					VerifyCodeUtil.getSmsTemp(json.getIntValue("type")));
			if (isSent)
			{
				VerifyCode codeBean = new VerifyCode();
				codeBean.setCode(code);
				codeBean.setPhone(json.getString("mobile"));
				codeBean.setCreateTime(Timestamp.from(Calendar.getInstance().toInstant()));
				verifyCodeService.insertNewCode(codeBean);
			}
			responseMap.put("status", HttpStatusConstant.userAccount.ok.getCode());
			responseMap.put("msg", HttpStatusConstant.userAccount.ok.getMsg());
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
