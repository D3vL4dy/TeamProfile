package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.MemberVO;

public class MemberDAOImpl {

	public List<MemberVO> selectMemberList(SqlSession session) throws SQLException{
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList");
		
		return memberList;
	}
	
	public MemberVO selectMemberById(SqlSession session, String id) throws SQLException{
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById", id);
		
		return member;
	}
	
}
