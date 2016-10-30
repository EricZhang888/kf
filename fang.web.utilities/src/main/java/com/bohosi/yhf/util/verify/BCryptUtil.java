package com.bohosi.yhf.util.verify;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtil
{

	private static final int HASHING_ROUNDS = 10;

	private static SecureRandom RANDOM = null;
	static
	{
		try
		{
			RANDOM = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e)
		{

		}
	}

	public static boolean checkBcryptPwd(String passwd, String orgPasswd)
	{
		return BCrypt.checkpw(passwd, orgPasswd);
	}

	public static String genBcryptPwd(String passwd)
	{
		String salt = BCrypt.gensalt();
		byte[] pwd = BCrypt.hashpw(passwd, salt).getBytes();
		return new String(pwd);
	}

	public static void main(String[] args)
	{
		String s = genBcryptPwd("Qwer1234");
		System.out.println(s);
		System.out.println(checkBcryptPwd("zaqweb", s));
		System.out.println(BCrypt.checkpw("zaqweb", "$2a$10$a6sC3kRU/odC3mh4iHJGYe15BSeLshUd.uezJHFtNBb93D9DsuZz2"));
	}
}
