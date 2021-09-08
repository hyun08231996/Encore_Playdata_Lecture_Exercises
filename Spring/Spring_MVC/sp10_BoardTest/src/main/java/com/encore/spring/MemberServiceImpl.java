package com.encore.spring;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.MemberDAO;
import com.encore.spring.MemberVO;


@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public MemberVO loginCheck(MemberVO vo) throws SQLException {
		
		return memberDAO.loginCheck(vo);
	}

	@Override
	public void add(MemberVO vo) throws Exception {
		memberDAO.add(vo);
		
	}

	@Override
	public List<MemberVO> getAllMembers() throws Exception {
		return memberDAO.getAllMembers();
	}

	@Override
	public MemberVO idCheck(String id) throws SQLException {
		return memberDAO.idCheck(id);
	}

}
