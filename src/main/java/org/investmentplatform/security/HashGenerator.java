package org.investmentplatform.security;

import com.lambdaworks.crypto.SCryptUtil;

public class HashGenerator 
{
	public static String GenerateHashFromPassword (String userPassword)
	{
		String hashPassword = SCryptUtil.scrypt(userPassword, 16, 16, 16);
		return hashPassword;
	}

	public static boolean check(String userPassword, String userHash) 
	{
		boolean isPassword = false;
		try 
		{
			isPassword = SCryptUtil.check(userPassword, userHash);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isPassword;
	}
}
