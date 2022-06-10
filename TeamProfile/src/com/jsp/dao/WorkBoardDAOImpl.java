package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.WorkBoardVO;

public class WorkBoardDAOImpl implements WorkBoardDAO {

	@Override
	public List<WorkBoardVO> selectWorkBoardCriteria(SqlSession session, Criteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<WorkBoardVO> workBoardList = session.selectList("WorkBoard-Mapper.selectSearchWorkBoardList",cri,rowBounds);	
			
		return workBoardList;
	}

	@Override
	public int selectWorkBoardCriteriaTotalCount(SqlSession session, Criteria cri) throws SQLException {
		int count = session.selectOne("WorkBoard-Mapper.selectSearchWorkBoardListCount", cri);
		return count;
	}

	@Override
	public WorkBoardVO selectWorkBoardByWno(SqlSession session, int wno) throws SQLException {
		WorkBoardVO workBoard = session.selectOne("WorkBoard-Mapper.selectWorkBoardByPno", wno);
		return workBoard;
	}

	@Override
	public void insertWorkBoard(SqlSession session, WorkBoardVO workBoard) throws SQLException {
		session.update("WorkBoard-Mapper.insertWorkBoard", workBoard);
	}

	@Override
	public void updateWorkBoard(SqlSession session, WorkBoardVO workBoard) throws SQLException {
		session.update("WorkBoard-Mapper.updateWorkBoard", workBoard);
	}

	@Override
	public void deleteWorkBoard(SqlSession session, int wno) throws SQLException {
		session.update("WorkBoard-Mapper.deleteWorkBoard", wno);
	}

	@Override
	public void increaseViewCnt(SqlSession session, int wno) throws SQLException {
		session.update("WorkBoard-Mapper.increaseViewCnt", wno);
	}

	@Override
	public int getSeqNextValue(SqlSession session) throws SQLException {
		int wno = session.selectOne("WorkBoard-Mapper.selectWorkBoardSeqNext");
		return wno;
	}

}
