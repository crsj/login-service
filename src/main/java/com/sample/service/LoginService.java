/**
 * 
 */
package com.sample.service;

import com.sample.persistence.IUserDAO;
import com.sample.util.EncryptionUtil;
import com.sample.vo.User;

/**
 * @author 604242745
 */
public class LoginService implements ILoginService 
{
	
	private IUserDAO userDAO;
	private EncryptionUtil encryptionUtil;

	/**
	 * Default Constructor
	 */
	public LoginService() 
	{
		super();
	}

	/**
	 * @param userDAO The userDAO to set.
	 */
	public void setUserDAO(IUserDAO userDAO) 
	{
		this.userDAO = userDAO;
	}
	
	public void setEncryptionUtil(EncryptionUtil encryptionUtil)
	{
		this.encryptionUtil = encryptionUtil;
	}

	/**
	 * @see com.sample.service.ILoginService#login(java.lang.String, java.lang.String)
	 */
	public boolean login(String userName, String password) 
	{
		boolean loginSuccess = false;
		
		String pwdHash = encryptionUtil.getEncryptedPassword(password);
		User user = userDAO.loadByUserAndPassword(userName, pwdHash);
		
		if(user != null)
			loginSuccess = true;
		
		return loginSuccess;
	}
}
