package com.sample.persistence;

import com.sample.vo.User;

public interface IUserDAO {
	User loadByUserAndPassword(String userName, String password);
}
