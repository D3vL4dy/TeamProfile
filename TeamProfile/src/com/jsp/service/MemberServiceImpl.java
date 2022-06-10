package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.MemberDAOImpl;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIdException;

public class MemberServiceImpl {

	private MemberDAOImpl memberDAO;
	private SqlSessionFactory sqlSessionFactory;
	
	public void setMemberDAO(MemberDAOImpl memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public List<MemberVO> getMemberList() throws SQLException{
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<MemberVO> memberList = memberDAO.selectMemberList(session);
			
			return memberList;
		}finally {
			session.close();
		}
	}
	
	public MemberVO getMember(String id) throws SQLException{
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			MemberVO member = memberDAO.selectMemberById(session, id);
			
			return member;
		}finally {
			session.close();
		}
	}
	
	public void login(String id, String pwd) throws NotFoundIdException, InvalidPasswordException, SQLException{
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			MemberVO member = memberDAO.selectMemberById(session, id);
			
			if(member == null) {
				throw new NotFoundIdException();
			}
			if(!pwd.equals(member.getPwd())) {
				throw new InvalidPasswordException();
			}
		}finally {
			session.close();
		}
	}
}
