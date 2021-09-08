package com.encore.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.User;
import com.encore.spring.model.UserDAO;
import com.encore.spring.model.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User getUser(String userId, String password) throws Exception {
		return userDAO.getUser(userId,password);
	}

	@Override
	public List<User> getUserList() throws Exception {
		return userDAO.getUserList();
	}
}
