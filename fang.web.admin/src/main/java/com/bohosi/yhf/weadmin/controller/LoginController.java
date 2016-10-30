package com.bohosi.yhf.weadmin.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bohosi.yhf.dao.entity.admin.Master;
import com.bohosi.yhf.service.admin.IMasterService;
import com.bohosi.yhf.util.verify.BCryptUtil;

@Controller
public class LoginController
{
	private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	IMasterService masterService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login()
	{
		return "login";
	}
	
	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest req)
	{
		String userAccountInfo = req.getParameter("mailOrMobile");
		String userPwd = req.getParameter("passwd");
		//check user exist
		if(userAccountInfo.isEmpty()) {
			return "login";
		}
		Master ms = masterService.getMasterByEmailOrMbile(userAccountInfo);
		
		//no account
		if(ms == null) {
			return "login";
		}
		//passwd error
		if(!BCryptUtil.checkBcryptPwd(userPwd,ms.getPasswd())) {
			return "login";
		}
		req.getSession().setAttribute("adminMail", ms.getEmail());
		req.getSession().setAttribute("adminApart", ms.getApartment());
		return "forward:index";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req)
	{
		req.getSession().invalidate();
		return "redirect:login";
	}
}
