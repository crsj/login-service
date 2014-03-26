package com.sample.service;

public interface ILoginService
{
	/**
	 * Handles a request to login
	 * @param userName
	 * @param password
	 * @return Result of the login 
	 */
	boolean login(String userName, String password);
}
