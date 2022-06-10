package com.jsp.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import com.jsp.dao.WorkBoardDAO;
import com.jsp.dao.WorkFileDAO;
import com.jsp.dao.WreplyDAO;
import com.jsp.dto.WorkBoardVO;
import com.jsp.dto.WorkFileVO;

public class WorkBoardServiceImpl implements WorkBoardService {
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	private WorkBoardDAO workBoardDAO;
	public void setWorkBoardDAO(WorkBoardDAO workBoardDAO) {
		this.workBoardDAO = workBoardDAO;
	}
	
	private WorkFileDAO workFileDAO;
	public void setWorkFileDAO(WorkFileDAO workFileDAO) {
		this.workFileDAO = workFileDAO;
	}
	
	private WreplyDAO wreplyDAO;
	public void setWreplyDAO(WreplyDAO wreplyDAO) {
		this.wreplyDAO = wreplyDAO;
	}
	
	@Override
	public Map<String, Object> getWorkBoardList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<WorkBoardVO> workBoardList = workBoardDAO.selectWorkBoardCriteria(session, cri);
		
			// reply count 입력
			if(workBoardList != null) for(WorkBoardVO wBoard : workBoardList) {
				int replycnt = wreplyDAO.countWReply(session, wBoard.getWno());
				wBoard.setWreplycnt(replycnt);
			}
			
			if (workBoardList != null)
				for (WorkBoardVO workBoard : workBoardList)
					addWorkFileList(session, workBoard);
			
			//마감일
			if (workBoardList != null) {
				for (WorkBoardVO workBoard : workBoardList) {
					Date endDate = workBoard.getEndDate();
					Date today = new Date();
					if(endDate != null && endDate.before(today)) {
						workBoard.setView("end");
					}
				}
			}
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(workBoardDAO.selectWorkBoardCriteriaTotalCount(session, cri));

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("workBoardList", workBoardList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}
	
	private void addWorkFileList(SqlSession session, WorkBoardVO workBoard) throws SQLException {

		if (workBoard == null)
			return;

		int wno = workBoard.getWno();
		List<WorkFileVO> workFileList = workFileDAO.selectWorkFilesByWno(session, wno);

		workBoard.setWorkFileList(workFileList);
	}

	@Override
	public WorkBoardVO getWorkBoard(int wno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			WorkBoardVO workBoard = workBoardDAO.selectWorkBoardByWno(session, wno);
			addWorkFileList(session, workBoard);
			
			return workBoard;
		} finally {
			session.close();
		}
	}

	@Override
	public WorkBoardVO getWorkBoardForModify(int wno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void regist(WorkBoardVO workBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			int wno = workBoardDAO.getSeqNextValue(session);

			workBoard.setWno(wno);
			workBoardDAO.insertWorkBoard(session, workBoard);

			if (workBoard.getWorkFileList() != null)
				for (WorkFileVO workFile : workBoard.getWorkFileList()) {
					workFile.setWno(wno);
					workFileDAO.insertWorkFile(session, workFile);
				}
		} finally {
			session.close();
		}
	}

	@Override
	public void modify(WorkBoardVO workBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			workBoardDAO.updateWorkBoard(session, workBoard);	
			if (workBoard.getWorkFileList() != null)
				for (WorkFileVO workFile : workBoard.getWorkFileList()) {
					workFile.setWno(workBoard.getWno());
					workFileDAO.insertWorkFile(session, workFile);
				}

		} finally {
			session.close();
		}
	}

	@Override
	public void remove(int wno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			workBoardDAO.deleteWorkBoard(session, wno);
			
		} finally {
			session.close();
		}

	}

	@Override
	public WorkBoardVO read(int wno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			WorkBoardVO workBoard = workBoardDAO.selectWorkBoardByWno(session, wno);
			workBoardDAO.increaseViewCnt(session, wno);
			
			addWorkFileList(session, workBoard);
			return workBoard;
		} finally {
			session.close();
		}
	}

	@Override
	public WorkFileVO getWorkFileByWAno(int w_ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			WorkFileVO workFile = workFileDAO.selectWorkFileByWAno(session, w_ano);

			return workFile;
		} finally {
			session.close();
		}
	}

	@Override
	public void removeAttachByAno(int w_ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			workFileDAO.deleteWorkFile(session, w_ano);

		} finally {
			session.close();
		}

	}

	@Override
	public Map<String, Object> getDeadWordBoardList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<WorkBoardVO> workBoardList = workBoardDAO.selectWorkBoardCriteria(session, cri);
			List<WorkBoardVO> deadWordBoardList = new ArrayList<WorkBoardVO>();
			
			// reply count 입력
			if(workBoardList != null) for(WorkBoardVO wBoard : workBoardList) {
				Date endDate = wBoard.getEndDate();
				Date today = new Date();
				if(endDate != null && endDate.before(today)) {
					wBoard.setView("end");
				}
				
				if(wBoard.getEndDate() != null) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(today);
					cal.add(Calendar.DATE, 3);
					boolean deadline = cal.getTime().after(endDate);
					if(endDate.after(today) && deadline) {					
						deadWordBoardList.add(wBoard);
						int replycnt = wreplyDAO.countWReply(session, wBoard.getWno());
						wBoard.setWreplycnt(replycnt);
						addWorkFileList(session, wBoard);
					}
				}
			}
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(deadWordBoardList.size());

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("workBoardList", deadWordBoardList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}

}
