package com.bohosi.yhf.api.bean;

import java.io.Serializable;

public class User implements Serializable
{
	private static final long serialVersionUID = 5832951551613610025L;

	private String id;
	
	private String pwd;
	
	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	private String phone;
	
	private String role;
	
	private int noPayOrders;
	
	private int noCheckInOrders;
	
	private int noMarkOrders;
	
	private int isLogin;

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public int getNoPayOrders()
	{
		return noPayOrders;
	}

	public void setNoPayOrders(int noPayOrders)
	{
		this.noPayOrders = noPayOrders;
	}

	public int getNoCheckInOrders()
	{
		return noCheckInOrders;
	}

	public void setNoCheckInOrders(int noCheckInOrders)
	{
		this.noCheckInOrders = noCheckInOrders;
	}

	public int getNoMarkOrders()
	{
		return noMarkOrders;
	}

	public void setNoMarkOrders(int noMarkOrders)
	{
		this.noMarkOrders = noMarkOrders;
	}

	public int getIsLogin()
	{
		return isLogin;
	}

	public void setIsLogin(int isLogin)
	{
		this.isLogin = isLogin;
	}
	
	
	
}
