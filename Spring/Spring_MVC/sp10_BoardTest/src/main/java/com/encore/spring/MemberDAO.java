package com.encore.spring;

import java.sql.SQLException;
import java.util.List;

import com.encore.spring.MemberVO;

public interface MemberDAO {

	MemberVO loginCheck(MemberVO vo) throws SQLException;

	void add(MemberVO m) throws Exception;
	
	List<MemberVO> getAllMembers() throws Exception;
	
	MemberVO idCheck(String id) throws SQLException;

}