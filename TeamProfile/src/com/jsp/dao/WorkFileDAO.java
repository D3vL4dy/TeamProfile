package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.WorkFileVO;

public interface WorkFileDAO {
	public List<WorkFileVO> selectWorkFilesByWno(SqlSession session, int wno)throws SQLException;
	public WorkFileVO selectWorkFileByWAno(SqlSession session, int w_ano)throws SQLException;
	
	public void insertWorkFile(SqlSession session, WorkFileVO workFile) throws SQLException;

	public void deleteWorkFile(SqlSession session, int w_ano) throws SQLException;

	public void deleteAllWorkFile(SqlSession session, int wno)throws SQLException;
}
