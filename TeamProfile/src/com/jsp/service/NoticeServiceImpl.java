package com.jsp.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.NoticeDAO;
import com.jsp.dto.NoticeVO;

public class NoticeServiceImpl implements NoticeService{
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private NoticeDAO noticeDAO;
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	@Override
	public Map<String, Object> getNoticeList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();

			List<NoticeVO> noticeList = noticeDAO.selectSearchNoticeList(session, cri);

			int totalCount = noticeDAO.selectSearchNoticeListCount(session, cri);
			
			//마감일
			if (noticeList != null) {
				for (NoticeVO notice : noticeList) {
					Date endDate = notice.getEndDate();
					Date today = new Date();
					if(endDate != null && endDate.before(today)) {
						notice.setView("end");
					}
				}
			}
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);

			dataMap.put("noticeList", noticeList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
			
		} finally {
			session.close();
		}
	}

	@Override
	public NoticeVO getNotice(int nno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			NoticeVO board = noticeDAO.selectNoticeByNno(session, nno);
			noticeDAO.increaseViewCount(session, nno);
			return board;
		} finally {
			session.close();
		}
	}

	@Override
	public NoticeVO getNoticeForModify(int nno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			NoticeVO board = noticeDAO.selectNoticeByNno(session, nno);
			return board;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(NoticeVO notice) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int nno = noticeDAO.selectNoticeSequenceNextValue(session);
			notice.setNno(nno); 
			noticeDAO.insertNotice(session, notice);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void modify(NoticeVO notice) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			noticeDAO.updateNotice(session, notice);
		} finally {
			session.close();
		}
	}

	@Override
	public void remove(int nno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			noticeDAO.deleteNotice(session, nno);
		} finally {
			session.close();
		}
	}
	
}
