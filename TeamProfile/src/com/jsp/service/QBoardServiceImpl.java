package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.QBoardDAO;
import com.jsp.dao.QReplyDAO;
import com.jsp.dto.QBoardVO;

public class QBoardServiceImpl implements QBoardService{
	

	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private QBoardDAO qboardDAO;
	public void setQBoardDAO(QBoardDAO qboardDAO) {
		this.qboardDAO = qboardDAO;
	}
	
	private QReplyDAO qreplyDAO;
	public void setQReplyDAO(QReplyDAO qreplyDAO) {
		this.qreplyDAO = qreplyDAO;
	}
	
	
	@Override
	public QBoardVO getQBoardForModify(int qno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			QBoardVO qboard = qboardDAO.selectQBoardByQno(session, qno);
			return qboard;
		} finally {
			session.close();
		}
	}

	@Override
	public QBoardVO getQBoard(int qno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			QBoardVO qboard = qboardDAO.selectQBoardByQno(session, qno);
			qboardDAO.increaseViewCnt(session, qno);
			return qboard;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(QBoardVO qboard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			int qno = qboardDAO.selectQBoardSeqNext(session);

			qboard.setQno(qno);

			qboardDAO.insertQBoard(session, qboard);
		} finally {
			session.close();
		}
	}

	@Override
	public void modify(QBoardVO qboard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			qboardDAO.updateQBoard(session, qboard);
		} finally {
			session.close();
		}
	}

	@Override
	public void remove(int qno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			qboardDAO.deleteQBoard(session, qno);
		} finally {
			session.close();
		}
	}

	@Override
	public Map<String, Object> getQBoardList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			Map<String, Object> dataMap = new HashMap<String, Object>();

			// ?????? page ????????? ?????? ???????????? perPageNum ?????? ?????? ????????????.
			List<QBoardVO> qboardList = qboardDAO.selectQBoardCriteria(session, cri);
			
			// reply count ??????
			if(qboardList != null) 
				for(QBoardVO qboard : qboardList) {
					int replycnt = qreplyDAO.countQReply(session, qboard.getQno());
					qboard.setReplycnt(replycnt);
				}
			
			// ?????? board ??????
			int totalCount = qboardDAO.selectQBoardCriteriaTotalCount(session, cri);

			// PageMaker ??????.
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);

			dataMap.put("qboardList", qboardList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}


	@Override
	public Map<String, Object> getStatusQBoardList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			Map<String, Object> dataMap = new HashMap<String, Object>();

			// ?????? page ????????? ?????? ???????????? perPageNum ?????? ?????? ????????????.
			List<QBoardVO> qboardList = qboardDAO.selectStatusQBoardList(session, cri);
			
			// reply count ??????
			if(qboardList != null) 
				for(QBoardVO qboard : qboardList) {
					int replycnt = qreplyDAO.countQReply(session, qboard.getQno());
					qboard.setReplycnt(replycnt);
				}
			
			// ?????? board ??????
			int totalCount = qboardDAO.selectStatusQBoardListCount(session);

			// PageMaker ??????.
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);

			dataMap.put("qboardList", qboardList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}
}
