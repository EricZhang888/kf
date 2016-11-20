package com.bohosi.yhf.util.verify;

public enum SmsTypeEnum
{

	login("SMS_26120039"), changePwd("SMS_26185079"), roomPaidUser("SMS_26100059"),roomPaidAdmin("SMS_26185080");

	private String tempName;

	public String getTempName()
	{
		return tempName;
	}

	public void setTempName(String tempName)
	{
		this.tempName = tempName;
	}

	private SmsTypeEnum(String tempName)
	{
		this.tempName = tempName;
	}
}
