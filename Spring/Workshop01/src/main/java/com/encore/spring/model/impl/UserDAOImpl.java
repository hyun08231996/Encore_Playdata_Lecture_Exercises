package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.User;
import com.encore.spring.model.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public User getUser(String userId, String password) throws Exception {
		User user = new User(userId,password);
		return sqlSession.selectOne("UserMapper.getUser",user);
	}

	@Override
	public List<User> getUserList() throws Exception {
		return sqlSession.selectList("UserMapper.getUserList");
	}
	
	
}
