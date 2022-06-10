package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.FreeBoardVO;

public class FreeBoardDAOImpl implements FreeBoardDAO{
	
	@Override
	public List<FreeBoardVO> selectFreeBoardCriteria(SqlSession session,Criteria cri) throws SQLException {
		
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();		
		RowBounds rowBounds=new RowBounds(offset,limit);		
		
		List<FreeBoardVO> FreeboardList=
				session.selectList("FreeBoard-Mapper.selectSearchFreeBoardList",cri,rowBounds);
		
		return FreeboardList;
	}
	
	@Override
	public int selectFreeBoardCriteriaTotalCount(SqlSession session,Criteria cri) throws SQLException {
		
		int count=session.selectOne("FreeBoard-Mapper.selectSearchFreeBoardListCount",cri);
		return count;
	}
	
	@Override
	public FreeBoardVO selectFreeBoardByFno(SqlSession session,int fno) throws SQLException {
		FreeBoardVO FreeboardList=
				session.selectOne("FreeBoard-Mapper.selectFreeBoardByFno",fno);
		return FreeboardList;
	}

	@Override
	public void insertFreeBoard(SqlSession session,FreeBoardVO freeBoard) throws SQLException {
		session.update("FreeBoard-Mapper.insertFreeBoard",freeBoard);
	}

	@Override
	public void updateFreeBoard(SqlSession session,FreeBoardVO freeBoard) throws SQLException {
		session.update("FreeBoard-Mapper.updateFreeBoard",freeBoard);
	}

	@Override
	public void deleteFreeBoard(SqlSession session,int fno) throws SQLException {
		session.update("FreeBoard-Mapper.deleteFreeBoard",fno);
	}

	@Override
	public void increaseViewCnt(SqlSession session,int fno) throws SQLException {
		session.update("FreeBoard-Mapper.increaseViewCnt",fno);
	}

	@Override
	public int selectFreeBoardSeqNext(SqlSession session) throws SQLException {
		int seq_num=
				session.selectOne("FreeBoard-Mapper.selectFreeBoardSeqNext");
		return seq_num;
	}
	
}
