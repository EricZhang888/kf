package com.ddkfang.util.verify;

public class VerifyCodeUtil {

	public static boolean sendVerifyCode(String mobile) {
		return false;
	}
	
	public static boolean checkVerifyCode(String code) {
		if (!code.equals("123456")) {
			return false;
		}
		return true;
	}
}
