package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.PFileVO;


public class PFileDAOImpl implements PFileDAO{

	@Override
	public List<PFileVO> selectPFilesByPno(SqlSession session, int pno) throws SQLException {
		List<PFileVO> pfileList = session.selectList("PFile-Mapper.selectPFilesByPno", pno);
		return pfileList;
	}

	@Override
	public PFileVO selectPFileByAno(SqlSession session, int p_ano) throws SQLException {
		PFileVO pfile = session.selectOne("PFile-Mapper.selectPFileByAno", p_ano);
		return pfile;
	}

	@Override
	public void insertPFile(SqlSession session, PFileVO pfile) throws SQLException {
		session.update("PFile-Mapper.insertPFile", pfile);
	}

	@Override
	public void deletePFile(SqlSession session, int p_ano) throws SQLException {
		session.update("PFile-Mapper.deletePFile", p_ano);
	}

	@Override
	public void deleteAllPFile(SqlSession session, int pno) throws SQLException {
		session.update("PFile-Mapper.deleteAllPFile", pno);
	}
}
