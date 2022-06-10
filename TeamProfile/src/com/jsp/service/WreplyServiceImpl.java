package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.WreplyDAO;
import com.jsp.dto.WReplyVO;

public class WreplyServiceImpl implements WreplyService {
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	private WreplyDAO wreplyDAO;
	public void setWreplyDAO(WreplyDAO wreplyDAO) {
		this.wreplyDAO = wreplyDAO;
	}
	
//	private MemberDAOImpl memberDAO;
//	public void setMemberDAOImpl(MemberDAOImpl memberDAO) {
//		this.memberDAO = memberDAO;
//	}
	
	@Override
	public Map<String, Object> getWReplyList(int wno, Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		try {
			List<WReplyVO> wReplyList = wreplyDAO.selectWReplyListPage(session, wno, cri);
			
//			if(wReplyList != null) for(WReplyVO wReply : wReplyList) {
//				MemberVO member = memberDAO.seletMemberById(session, wReply.getReplyer());
//				wReply.setPicture(member.getPicture());
//			}
			
			int count = wreplyDAO.countWReply(session, wno);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(count);
	
			dataMap.put("wReplyList", wReplyList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
			
		}finally{
			session.close();
		}
		
	}

	@Override
	public int getWReplyListCount(int wno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int count = wreplyDAO.countWReply(session, wno);
			return count;
		} finally {
			session.close();
		}
	}

	@Override
	public void registWReply(WReplyVO wReply) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int w_rno = wreplyDAO.selectWReplySeqNextValue(session);
			wReply.setW_rno(w_rno);

			wreplyDAO.insertWReply(session, wReply);
		} finally {
			session.close();
		}
		

	}

	@Override
	public void modifyWReply(WReplyVO wReply) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			wreplyDAO.updateWReply(session, wReply);
		} finally {
			session.close();
		}		
	}

	@Override
	public void removeWReply(int w_rno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			wreplyDAO.deleteWReply(session, w_rno);
		} finally {
			session.close();
		}

	}

}
