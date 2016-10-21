package com.ddkfang.api.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ddkfang.api.controller.BaseController;
import com.ddkfang.constant.HttpStatusConstant;
import com.ddkfang.dao.entity.user.Booker;
import com.ddkfang.service.common.IVerifyCodeService;
import com.ddkfang.service.user.IUserAccountService;
import com.ddkfang.util.verify.BCryptUtil;
import com.yhf.dao.util.QueryTool;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController
{

	@Autowired
	IUserAccountService userAccountService;

	@Autowired
	IVerifyCodeService verifyCodeService;

	/**
	 * 用户根据手机，验证码 修改密码
	 * 
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "changePasswordByMobile", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> changePasswordByMobile(@RequestBody JSONObject json)
	{

		//JSONObject json = JSONObject.parseObject(jsonString);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		//check if the account exist by mobile
		try
		{
			if (!userAccountService.checkUserExistByMobile(json.getString("mobile")))
			{
				responseMap.put("status", HttpStatusConstant.userAccount.accountNotExist.getCode());
				responseMap.put("msg", HttpStatusConstant.userAccount.accountNotExist.getMsg());
				return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
			}
			//check verification code 
			if (!verifyCodeService.findLatestCodeByPhone(json.getString("mobile")).equals(json.getString("code")))
			{
				responseMap.put("status", HttpStatusConstant.userAccount.vcodeError.getCode());
				responseMap.put("msg", HttpStatusConstant.userAccount.vcodeError.getMsg());
				return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
			}
			//change user's pwd
			userAccountService.updateUserPasswordByMobile(json.getString("mobile"), json.getString("password"));
			responseMap.put("status", HttpStatusConstant.userAccount.ok.getCode());
			responseMap.put("msg", HttpStatusConstant.userAccount.ok.getMsg());
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e)
		{
			return internalError();
		}
	}

	/**
	 * 用户根据手机，验证码 修改密码
	 * 
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "changePasswordByOld", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> changePasswordByOld(@RequestBody JSONObject json,
			HttpServletRequest request)
	{

		//JSONObject json = JSONObject.parseObject(jsonString);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		//check if the account exist by mobile
		try
		{

			Booker user = (Booker) request.getSession().getAttribute("user");
			if (!BCryptUtil.checkBcryptPwd(json.getString("oldPasswd"), user.getBookerPwd()))
			{
				responseMap.put("status", HttpStatusConstant.userAccount.oldPasswdError.getCode());
				responseMap.put("msg", HttpStatusConstant.userAccount.oldPasswdError.getMsg());
				return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
			}

			userAccountService.updateUserPasswordByOld(user, json.getString("newPasswd"));
			responseMap.put("status", HttpStatusConstant.userAccount.ok.getCode());
			responseMap.put("msg", HttpStatusConstant.userAccount.ok.getMsg());
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e)
		{
			return internalError();
		}
	}

	@RequestMapping(value = "loginByPasswd", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> loginByPasswd(@RequestBody JSONObject json, HttpServletRequest request)
	{

		//JSONObject json = JSONObject.parseObject(jsonString);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		//check if the account exist by mobile
		try
		{

			Booker user = userAccountService.getUserByMobile(json.getString("mobile"));
			if (user == null)
			{
				responseMap.put("status", HttpStatusConstant.userAccount.accountNotExist.getCode());
				responseMap.put("msg", HttpStatusConstant.userAccount.accountNotExist.getMsg());
				return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
			}
			//check passwd 
			if (!BCryptUtil.checkBcryptPwd(json.getString("password"), user.getBookerPwd()))
			{
				responseMap.put("status", HttpStatusConstant.userAccount.passwdError.getCode());
				responseMap.put("msg", HttpStatusConstant.userAccount.passwdError.getMsg());
				return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
			}

			//login
			responseMap.put("data", HttpStatusConstant.userAccount.ok.getCode());
			responseMap.put("status", HttpStatusConstant.userAccount.ok.getCode());
			responseMap.put("msg", HttpStatusConstant.userAccount.ok.getMsg());
			request.getSession().setAttribute("user", user);
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e)
		{
			e.printStackTrace();
			return internalError();
		}
	}

	@RequestMapping(value = "loginByVerifyCode", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> loginByVerifyCode(@RequestBody JSONObject json,
			HttpServletRequest request)
	{

		//JSONObject json = JSONObject.parseObject(jsonString);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		//check if the account exist by mobile
		try
		{
			String mobile = json.getString("mobile");
			String code = json.getString("code");
			Booker user = userAccountService.getUserByMobile(mobile);
			if (user == null)
			{
				//first time login, create account
				user = new Booker();
				user.setBookerMobile(mobile);
				user.setUpdateTime(QueryTool.getCurrentTs());
				userAccountService.createUser(user);
			}
			//check verification code 
			if (!verifyCodeService.findLatestCodeByPhone(mobile).equals(code))
			{
				responseMap.put("status", HttpStatusConstant.userAccount.vcodeError.getCode());
				responseMap.put("msg", HttpStatusConstant.userAccount.vcodeError.getMsg());
				return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
			}

			//login
			responseMap.put("data", HttpStatusConstant.userAccount.ok.getCode());
			responseMap.put("status", HttpStatusConstant.userAccount.ok.getCode());
			responseMap.put("msg", HttpStatusConstant.userAccount.ok.getMsg());
			request.getSession().setAttribute("user", user);
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e)
		{
			e.printStackTrace();
			return internalError();
		}
	}

	@RequestMapping(value = "checkUserLogin", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> checkUserLogin(HttpServletRequest request)
	{

		Map<String, Object> responseMap = new HashMap<String, Object>();
		Booker user = (Booker) request.getSession().getAttribute("user");
		responseMap.put("data", user);
		responseMap.put("status", HttpStatusConstant.userAccount.ok.getCode());
		responseMap.put("msg", HttpStatusConstant.userAccount.ok.getMsg());

		return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
	}

	@RequestMapping(value = "userLogout", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> userLogout(HttpServletRequest request) throws ServletException
	{
		request.getSession().invalidate();
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("status", HttpStatusConstant.userAccount.ok.getCode());
		responseMap.put("msg", HttpStatusConstant.userAccount.ok.getMsg());
		return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
	}

}
