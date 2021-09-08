package ibatis.services.user;

import java.util.List;

import ibatis.services.domain.User;

/*
 * Service Layer
 * ::
 * Data가공과 관련있는 레이어
 * ::
 * 5개의 비지니스 템플릿 기능 중에서
 * 서비스 레이어와 전혀 관련이 없는 기능 :: removeUser 
 * 서비스 레이어와 가장 관련이 많은 기능 :: getUser, getUserList
 */
public interface UserService {
	void addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
