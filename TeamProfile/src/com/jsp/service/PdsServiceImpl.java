package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.PFileDAO;
import com.jsp.dao.PdsDAO;
import com.jsp.dto.PFileVO;
import com.jsp.dto.PdsVO;

public class PdsServiceImpl implements PdsService {
	

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private PdsDAO pdsDAO;
	public void setPdsDAO(PdsDAO pdsDAO) {
		this.pdsDAO = pdsDAO;
	}
	

	private PFileDAO pfileDAO;
	public void setPfileDAO(PFileDAO pfileDAO) {
		this.pfileDAO = pfileDAO;
	}
	

	@Override
	public Map<String, Object> getList(Criteria cri, String loginUserId) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<PdsVO> pdsList = pdsDAO.selectPdsCriteria(session, cri);
			List<PdsVO> readPdsList = pdsDAO.selectReadPdsListById(session, loginUserId);
			
			if (pdsList != null)
				for (PdsVO pds : pdsList)
					addPFileList(session, pds);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(pdsDAO.selectPdsCriteriaTotalCount(session, cri));

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("pdsList", pdsList);
			dataMap.put("pageMaker", pageMaker);
			dataMap.put("readPdsList", readPdsList);

			return dataMap;
		} finally {
			session.close();
		}
	}

	@Override
	public PdsVO getPds(int pno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			PdsVO pds = pdsDAO.selectPdsByPno(session, pno);
			addPFileList(session, pds);
			
			return pds;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(PdsVO pds) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			int pno = pdsDAO.getSeqNextValue(session);

			pds.setPno(pno);
			pdsDAO.insertPds(session, pds);		

			if (pds.getPfileList() != null)
				for (PFileVO pfile : pds.getPfileList()) {
					pfile.setPno(pno);
					pfileDAO.insertPFile(session, pfile);
				}
		} finally {
			session.close();
		}
	}

	@Override
	public void modify(PdsVO pds) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			pdsDAO.updatePds(session, pds);		
			if (pds.getPfileList() != null)
				for (PFileVO pfile : pds.getPfileList()) {
					pfile.setPno(pds.getPno());
					pfileDAO.insertPFile(session, pfile);
				}

		} finally {
			session.close();
		}
	}

	@Override
	public void remove(int pno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			pdsDAO.deletePds(session, pno);
			
		} finally {
			session.close();
		}
	}

	@Override
	public PdsVO read(int pno, String loginUserId) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			PdsVO pds = pdsDAO.selectPdsByPno(session, pno);
			pdsDAO.increaseViewCnt(session, pno);
			
			addPFileList(session, pds);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("pno", pno);
			params.put("reader", loginUserId);
	
			int readPdsCount = pdsDAO.selectCheckReadPds(session, params);
			
			if(readPdsCount == 0) {
				params.put("rpno", pdsDAO.getRpnoSeqNextValue(session));
				pdsDAO.insertReadPds(session, params);
			}
			
			return pds;
		} finally {
			session.close();
		}
	}


	private void addPFileList(SqlSession session, PdsVO pds) throws SQLException {

		if (pds == null)
			return;

		int pno = pds.getPno();
		List<PFileVO> pfileList = pfileDAO.selectPFilesByPno(session, pno);

		pds.setPfileList(pfileList);
	}



	@Override
	public PFileVO getPFileByAno(int p_ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			PFileVO pfile = pfileDAO.selectPFileByAno(session, p_ano);

			return pfile;
		} finally {
			session.close();
		}
	}

	@Override
	public void removePFileByAno(int p_ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			pfileDAO.deletePFile(session, p_ano);

		} finally {
			session.close();
		}

	}


	@Override
	public Map<String, Object> getImportantList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<PdsVO> pdsList = pdsDAO.selectImportantPdsList(session, cri);
			
			if (pdsList != null)
				for (PdsVO pds : pdsList)
					addPFileList(session, pds);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(pdsDAO.selectImportantPdsListCount(session));

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("pdsList", pdsList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}
}
