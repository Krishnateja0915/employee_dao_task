package com.medplus.employee.service;

import com.medplus.employee.beans.User;
import com.medplus.employee.dao.UserDao;
import com.medplus.employee.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	private UserDao dao = new UserDaoImpl();
	
	@Override
	public User getUser(String username) {
		return dao.getUser(username);
	}

}
