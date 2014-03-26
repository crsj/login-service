/**
 * 
 */
package com.sample.persistence;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sample.util.HibernateUtil;
import com.sample.vo.User;

/**
 * @author 604242745
 */
public class UserDAO implements IUserDAO {

	/**
	 * Default Constructor
	 */
	public UserDAO() {
		super();
	}

	/**
	 * @see com.sample.persistence.IUserDAO#loadByUserAndPassword(java.lang.String, java.lang.String)
	 */
	public User loadByUserAndPassword(String userName, String password) {
		
		User returnUser = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		
		String hqlQuery = "from USERS where USER_NAME=:uName and PASSWORd=:pwd";
		
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			query = session.createQuery(hqlQuery);
			query.setParameter("uName", userName);
			query.setParameter("pwd", password);
			 
			List<User> users = query.list();
			
			if(users.size()>=1)
			{
				returnUser = users.get(0);
			}
		}
		finally
		{
			transaction.commit();
			session.close();
			HibernateUtil.cleanUp();
		}		
		return returnUser;
	}

}
