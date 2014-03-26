package com.sample.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil
{
	public EncryptionUtil()
	{
		super();
	}

	public String getEncryptedPassword(String password) 
	{
		String pwdHash = null;
		
		try
		{
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(password.getBytes());
			pwdHash = new String(messageDigest.digest());
		} catch (NoSuchAlgorithmException nsaException)
		{
			nsaException.printStackTrace();
		}
		return pwdHash;
	}
}
