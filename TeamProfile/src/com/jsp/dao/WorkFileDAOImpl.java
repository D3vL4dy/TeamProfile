package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.WorkFileVO;

public class WorkFileDAOImpl implements WorkFileDAO {

	@Override
	public List<WorkFileVO> selectWorkFilesByWno(SqlSession session, int wno) throws SQLException {
		List<WorkFileVO> workFileList = session.selectList("WorkFile-Mapper.selectWorkFilesByWno",wno);
		return workFileList;
	}

	@Override
	public WorkFileVO selectWorkFileByWAno(SqlSession session, int w_ano) throws SQLException {
		WorkFileVO workFile = session.selectOne("WorkFile-Mapper.selectWorkFileByWAno",w_ano);
		return workFile;
	}

	@Override
	public void insertWorkFile(SqlSession session, WorkFileVO workFile) throws SQLException {
		session.update("WorkFile-Mapper.insertWorkFile", workFile);
	}

	@Override
	public void deleteWorkFile(SqlSession session, int w_ano) throws SQLException {
		session.update("WorkFile-Mapper.deleteWorkFile", w_ano);
	}

	@Override
	public void deleteAllWorkFile(SqlSession session, int wno) throws SQLException {
		session.update("WorkFile-Mapper.deleteAllWorkFile", wno);
	}

}
