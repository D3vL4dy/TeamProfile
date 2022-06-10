package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.PdsVO;

public class PdsDAOImpl implements PdsDAO{
	

	@Override
	public List<PdsVO> selectPdsCriteria(SqlSession session,Criteria cri) throws SQLException {
		
		
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds=new RowBounds(offset,limit);
		
		List<PdsVO> pdsList=
		   session.selectList("Pds-Mapper.selectSearchPdsList",cri,rowBounds);	
			
		return pdsList;
	}

	@Override
	public int selectPdsCriteriaTotalCount(SqlSession session,Criteria cri) throws SQLException {
		int count=session.selectOne("Pds-Mapper.selectSearchPdsListCount",cri);
		return count;
	}

	@Override
	public PdsVO selectPdsByPno(SqlSession session,int pno) throws SQLException {
		PdsVO pds=session.selectOne("Pds-Mapper.selectPdsByPno",pno);
		return pds;
	}

	@Override
	public void insertPds(SqlSession session,PdsVO pds) throws SQLException {
		session.update("Pds-Mapper.insertPds",pds);
	}

	@Override
	public void updatePds(SqlSession session,PdsVO pds) throws SQLException {
		session.update("Pds-Mapper.updatePds",pds);
	}

	@Override
	public void deletePds(SqlSession session,int pno) throws SQLException {
		session.update("Pds-Mapper.deletePds",pno);
	}

	@Override
	public void increaseViewCnt(SqlSession session,int pno) throws SQLException {
		session.update("Pds-Mapper.increaseViewCnt",pno);
	}

	@Override
	public int getSeqNextValue(SqlSession session) throws SQLException {
		int pno=session.selectOne("Pds-Mapper.selectPdsSeqNext");
		return pno;
	}

	@Override
	public int getRpnoSeqNextValue(SqlSession session) throws SQLException {
		int rpno = session.selectOne("Pds-Mapper.selectRpnoSeqNext");
		return rpno;
	}

	@Override
	public void insertReadPds(SqlSession session, Map<String, Object> params) throws SQLException {
		session.update("Pds-Mapper.insertReadPds", params);
	}

	@Override
	public int selectCheckReadPds(SqlSession session, Map<String, Object> params) throws SQLException {
		int count = session.selectOne("Pds-Mapper.selectCheckReadPds", params);
		return count;
	}

	@Override
	public List<PdsVO> selectReadPdsListById(SqlSession session, String loginUserId) throws SQLException {
		List<PdsVO> readPdsList = session.selectList("Pds-Mapper.selectReadPdsListById", loginUserId);
		return readPdsList;
	}

	@Override
	public List<PdsVO> selectImportantPdsList(SqlSession session, Criteria cri) throws SQLException {
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds=new RowBounds(offset,limit);
		
		List<PdsVO> pdsList = session.selectList("Pds-Mapper.selectImportantPdsList",null,rowBounds);
		return pdsList;
	}

	@Override
	public int selectImportantPdsListCount(SqlSession session) throws SQLException {
		int count = session.selectOne("Pds-Mapper.selectImportantPdsListCount");
		return count;
	}
}
