package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.dao.QReplyDAO;
import com.jsp.dto.MemberVO;
import com.jsp.dto.QReplyVO;

public class QReplyServiceImpl implements QReplyService {
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	private QReplyDAO qreplyDAO;
	public void setQReplyDAO(QReplyDAO qreplyDAO) {
		this.qreplyDAO = qreplyDAO;
	}
	
	private MemberDAOImpl memberDAO;
	public void setMemberDAO(MemberDAOImpl memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public Map<String, Object> getQReplyList(int qno, Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		try {
			List<QReplyVO> qreplyList = qreplyDAO.selectQReplyListPage(session, qno, cri);
			
			if(qreplyList != null) for(QReplyVO qreply : qreplyList) {
				MemberVO member = memberDAO.selectMemberById(session, qreply.getReplyer());
			}
			
			int count = qreplyDAO.countQReply(session,qno);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(count);
	
			dataMap.put("qreplyList", qreplyList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
			
		}finally{
			session.close();
		}
		
	}

	@Override
	public int getQReplyListCount(int qno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int count = qreplyDAO.countQReply(session, qno);
			return count;
		} finally {
			session.close();
		}
	}

	@Override
	public void registQReply(QReplyVO qreply) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int q_Rno = qreplyDAO.selectQReplySeqNextValue(session);
			qreply.setQ_Rno(q_Rno);

			qreplyDAO.insertQReply(session,qreply);
		} finally {
			session.close();
		}
		

	}

	@Override
	public void modifyQReply(QReplyVO qreply) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			qreplyDAO.updateQReply(session,qreply);
		} finally {
			session.close();
		}		
	}

	@Override
	public void removeQReply(int q_Rno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			qreplyDAO.deleteQReply(session,q_Rno);
		} finally {
			session.close();
		}

	}

}
