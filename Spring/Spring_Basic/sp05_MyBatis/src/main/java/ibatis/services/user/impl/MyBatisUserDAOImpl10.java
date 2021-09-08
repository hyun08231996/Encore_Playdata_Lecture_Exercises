package ibatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ibatis.services.domain.User;
import ibatis.services.user.UserDAO;

/*
 * Persistence Layer Component :: MyBatisUserDAOImpl10
 * SqlSession을 DI 하는 컴포넌트
 * 1) 필드에 SqlSession 선언
 * 2) setter로 주입
 * 
 * MyBatisUserDAOImpl10의 Persistence Layer Component가 잘 만들어졌는지를 확인하는
 * Persistence Layer의 단위테스트는 MyBatisTestApp102
 */

public class MyBatisUserDAOImpl10 implements UserDAO {
	private SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int addUser(User user) throws Exception {
		int result = sqlSession.insert("User10.addUser",user);
		sqlSession.commit();
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update("User10.updateUser",user);
		sqlSession.commit();
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = sqlSession.delete("User10.removeUser",userId);
		sqlSession.commit();
		return result;
	}

	@Override
	public User getUser(String userId) throws Exception {
		return sqlSession.selectOne("User10.getUser", userId);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		return sqlSession.selectList("User10.getUserList", user);
	}

}
