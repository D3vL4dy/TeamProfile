package com.jsp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.FReplyDAO;
import com.jsp.dao.FreeBoardDAO;
import com.jsp.dto.FreeBoardVO;

public class FreeBoardServiceImpl implements FreeBoardService{
	

	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private FreeBoardDAO freeBoardDAO;
	public void setFreeBoardDAO(FreeBoardDAO freeBoardDAO) {
		this.freeBoardDAO = freeBoardDAO;
	}

	private FReplyDAO freplyDAO;
	public void setFreplyDAO(FReplyDAO freplyDAO) {
		this.freplyDAO = freplyDAO;
	}

	@Override
	public FreeBoardVO getFBoardForModify(int fno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			FreeBoardVO freeBoard = freeBoardDAO.selectFreeBoardByFno(session, fno);
			return freeBoard;
		} finally {
			session.close();
		}
	}

	@Override
	public FreeBoardVO getFBoard(int fno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			FreeBoardVO freeBoard = freeBoardDAO.selectFreeBoardByFno(session, fno);
			freeBoardDAO.increaseViewCnt(session, fno);
			return freeBoard;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(FreeBoardVO freeBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			int fno = freeBoardDAO.selectFreeBoardSeqNext(session);

			freeBoard.setFno(fno);

			freeBoardDAO.insertFreeBoard(session, freeBoard);
		} finally {
			session.close();
		}
	}

	@Override
	public void modify(FreeBoardVO freeBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			freeBoardDAO.updateFreeBoard(session, freeBoard);
		} finally {
			session.close();
		}
	}

	@Override
	public void remove(int fno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			freeBoardDAO.deleteFreeBoard(session, fno);
		} finally {
			session.close();
		}
	}

	@Override
	public Map<String, Object> getFreeBoardList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			Map<String, Object> dataMap = new HashMap<String, Object>();

			// 현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
			List<FreeBoardVO> FreeBoardList = freeBoardDAO.selectFreeBoardCriteria(session, cri);
			
			// reply count 입력
			if(FreeBoardList !=null) for(FreeBoardVO freeBoard : FreeBoardList) {
				int replycnt = freplyDAO.countReply(session, freeBoard.getFno());
				freeBoard.setReplycnt(replycnt);
			}
			
			// 전체 board 개수
			int totalCount = freeBoardDAO.selectFreeBoardCriteriaTotalCount(session, cri);

			// PageMaker 생성.
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);

			dataMap.put("FreeBoardList", FreeBoardList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}

	@Override
	public Map<String, Object> getRecentFreeBoardList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			Map<String, Object> dataMap = new HashMap<String, Object>();

			// 현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
			List<FreeBoardVO> FreeBoardList = freeBoardDAO.selectFreeBoardCriteria(session, cri);
			List<FreeBoardVO> recentFreeBoardList = new ArrayList<FreeBoardVO>();
			
			// reply count 입력
			if(FreeBoardList !=null) for(FreeBoardVO freeBoard : FreeBoardList) {
				Date currentDate = new Date();
				Date regDate = freeBoard.getRegDate();
				Calendar cal = Calendar.getInstance();
				cal.setTime(currentDate);
				cal.add(Calendar.DATE, -3);
				System.out.println(cal.getTime());
				boolean recent = regDate.after(cal.getTime());
				if(recent) {
					System.out.println(freeBoard);
					recentFreeBoardList.add(freeBoard);
					int replycnt = freplyDAO.countReply(session, freeBoard.getFno());
					freeBoard.setReplycnt(replycnt);
				}
			}
			
			// 전체 board 개수
			int totalCount = recentFreeBoardList.size();

			// PageMaker 생성.
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);

			dataMap.put("FreeBoardList", recentFreeBoardList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}
}
