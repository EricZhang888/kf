package com.bohosi.yhf.util.verify;

public enum SmsTypeEnum
{

	login("SMS_16360290"), changePwd("SMS_16375147"), roomPaidUser("SMS_21755102"),roomPaidAdmin("SMS_21670076");

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
