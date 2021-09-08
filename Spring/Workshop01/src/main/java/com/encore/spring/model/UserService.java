package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.User;

public interface UserService {
	User getUser(String userId, String password) throws Exception;
	List<User> getUserList() throws Exception;
}
