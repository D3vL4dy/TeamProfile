package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.FReplyDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.dto.FReplyVO;
import com.jsp.dto.MemberVO;

public class FReplyServiceImpl implements FReplyService {
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	private FReplyDAO freplyDAO;
	public void setFreplyDAO(FReplyDAO freplyDAO) {
		this.freplyDAO = freplyDAO;
	}
	private MemberDAOImpl memberDAO;
	public void setMemberDAO(MemberDAOImpl memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public Map<String, Object> getReplyList(int fno, Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		try {
			List<FReplyVO> replyList = freplyDAO.selectFReplyListPage(session, fno, cri);
			
			if(replyList != null) for(FReplyVO reply : replyList) {
				MemberVO member = memberDAO.selectMemberById(session, reply.getId());
				//reply.setPicture(member.getPicture());
			}
			
			int count = freplyDAO.countReply(session,fno);
			System.out.println("reply count : " + count);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(count);
	
			System.out.println("reply replyList : " + replyList);
			
			dataMap.put("replyList", replyList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
			
		}finally{
			session.close();
		}
		
	}
	
	

	@Override
	public int getReplyListCount(int fno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int count = freplyDAO.countReply(session, fno);
			return count;
		} finally {
			session.close();
		}
	}

	@Override
	public void registReply(FReplyVO freply) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int f_rno = freplyDAO.selectFReplySeqNextValue(session);
			freply.setF_rno(f_rno);

			freplyDAO.insertFReply(session,freply);
		} finally {
			session.close();
		}
		

	}

	@Override
	public void modifyReply(FReplyVO freply) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			freplyDAO.updateFReply(session,freply);
		} finally {
			session.close();
		}		
	}

	@Override
	public void removeReply(int f_rno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			freplyDAO.deleteFReply(session,f_rno);
		} finally {
			session.close();
		}

	}

}
