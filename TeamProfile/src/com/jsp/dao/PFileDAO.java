package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.PFileVO;

public interface PFileDAO {
	

	public List<PFileVO> selectPFilesByPno(SqlSession session, int pno)throws SQLException;
	public PFileVO selectPFileByAno(SqlSession session,int p_ano)throws SQLException;
	
	public void insertPFile(SqlSession session,PFileVO pfile) throws SQLException;

	public void deletePFile(SqlSession session,int p_ano) throws SQLException;

	public void deleteAllPFile(SqlSession session,int pno)throws SQLException;
}







