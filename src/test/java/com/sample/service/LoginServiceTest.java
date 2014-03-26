package com.sample.service;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.createNiceMock;

import java.security.NoSuchAlgorithmException;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sample.persistence.IUserDAO;
import com.sample.persistence.UserDAO;
import com.sample.util.EncryptionUtil;
import com.sample.vo.User;

public class LoginServiceTest extends TestCase 
{
	private ILoginService loginService = null;
	private IUserDAO mockUserDao = null;
	private EncryptionUtil mockEncryptUtil = null;
	
	@Before
	protected void setUp() throws Exception 
	{
		loginService = new LoginService();
		mockUserDao = createStrictMock(IUserDAO.class);
		mockEncryptUtil = createStrictMock(EncryptionUtil.class);
		
		((LoginService) loginService).setEncryptionUtil(mockEncryptUtil);
		((LoginService) loginService).setUserDAO(mockUserDao);
		
	}

	@After
	protected void tearDown() throws Exception 
	{
		loginService = null;
		mockUserDao = null;
		mockEncryptUtil = null;
	}

	/**
	 * Test method for 'com.sample.LoginService.login(String, String)'
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	public void testLogin() throws NoSuchAlgorithmException 
	{
		User outputUser = new User();
		String userName = "testUser";
		String password = "testPassword";
		
		/**
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(password.getBytes());
		String pwdHash = new String(messageDigest.digest()); 
		*/
		
		//Tell mock objects what to expect
		expect(mockEncryptUtil.getEncryptedPassword(password)).andReturn(password);
		expect(mockUserDao.loadByUserAndPassword(eq(userName), eq(password))).andReturn(outputUser);
		
		//Prepare mock objects to be ready for replay
		replay(mockEncryptUtil);
		replay(mockUserDao);
		
		Boolean loggedIn = loginService.login(userName, password);
		
		System.out.println("userName: " + userName + " : " + "password : " + password + " : loggedIn : " + loggedIn.toString());
		
		Assert.assertTrue("Sucess scenario", loggedIn);
		
		verify(mockEncryptUtil);
		verify(mockUserDao);
	}
}
