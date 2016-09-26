package com.ddkfang.util.verify;

public enum SmsTypeEnum {

	login("SMS_16360290"), changePwd("SMS_16375147");
	
	private String tempName;

	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}
	 
	
	private SmsTypeEnum (String tempName) {
		this.tempName = tempName;
	}
}
