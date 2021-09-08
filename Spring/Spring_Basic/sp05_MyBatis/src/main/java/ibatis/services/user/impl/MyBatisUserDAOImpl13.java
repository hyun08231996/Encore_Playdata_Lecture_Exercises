package ibatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ibatis.services.domain.User;
import ibatis.services.user.UserDAO;

/*
 * Persistence Layer Bean
 * 클래스 선언부 윗쪽에다가 @Repository 어노테이션 달아준다.
 * xml의 <bean>부분을 생략할 수 있다.
 * 
 * @Repository,@Autowired를 사용하면 xml에서 아래와같이 bean이 만들어진다.
 * <bean id="myBatisUserDAOImpl13" class="ibatis.services.user.impl.MyBatisUserDAOImpl13"> -> @Repository
 * 		<property name="sqlSession" ref="sqlSession"/> -> @Autowired
 * </bean>
 */

@Repository
public class MyBatisUserDAOImpl13 implements UserDAO {
	
	@Autowired //알아서 setter로 주입이 된다.
	private SqlSession sqlSession;
	
	
//	public void setSqlSession(SqlSession sqlSession) { //이 부분은 Autowired해서 필요 없어진다.
//		this.sqlSession = sqlSession;
//	}

	@Override
	public int addUser(User user) throws Exception {
		int result = sqlSession.insert("User10.addUser",user);
		//sqlSession.commit();
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update("User10.updateUser",user);
		//sqlSession.commit();
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = sqlSession.delete("User10.removeUser",userId);
		//sqlSession.commit();
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
