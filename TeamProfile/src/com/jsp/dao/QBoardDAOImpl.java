package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.QBoardVO;

public  class QBoardDAOImpl implements QBoardDAO {


	@Override
	public List<QBoardVO> selectQBoardCriteria(SqlSession session,Criteria cri) throws SQLException {
		
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();		
		RowBounds rowBounds=new RowBounds(offset,limit);		
		
		List<QBoardVO> qboardList=
				session.selectList("QBoard-Mapper.selectSearchQBoardList",cri,rowBounds);
		
		return qboardList;
	}
	
	@Override
	public int selectQBoardCriteriaTotalCount(SqlSession session,Criteria cri) throws SQLException {
		
		int count=session.selectOne("QBoard-Mapper.selectSearchQBoardListCount",cri);
		return count;
	}
	
	@Override
	public QBoardVO selectQBoardByQno(SqlSession session,int qno) throws SQLException {
		QBoardVO qboard=
				session.selectOne("QBoard-Mapper.selectQBoardByQno",qno);
		return qboard;
	}

	@Override
	public void insertQBoard(SqlSession session,QBoardVO qboard) throws SQLException {
		session.update("QBoard-Mapper.insertQBoard",qboard);
	}

	@Override
	public void updateQBoard(SqlSession session,QBoardVO qboard) throws SQLException {
		session.update("QBoard-Mapper.updateQBoard",qboard);
	}

	@Override
	public void deleteQBoard(SqlSession session,int qno) throws SQLException {
		session.update("QBoard-Mapper.deleteQBoard",qno);
	}

	@Override
	public void increaseViewCnt(SqlSession session,int qno) throws SQLException {
		session.update("QBoard-Mapper.increaseViewCnt",qno);
	}

	@Override
	public int selectQBoardSeqNext(SqlSession session) throws SQLException {
		int seq_num=
				session.selectOne("QBoard-Mapper.selectQBoardSeqNext");
		return seq_num;
	}

	@Override
	public List<QBoardVO> selectStatusQBoardList(SqlSession session, Criteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<QBoardVO> qboardList = session.selectList("QBoard-Mapper.selectStatusQBoardList", cri, rowBounds);
		return qboardList;
	}

	@Override
	public int selectStatusQBoardListCount(SqlSession session) throws SQLException {
		int totalCount = session.selectOne("QBoard-Mapper.selectStatusQBoardListCount");
		return totalCount;
	}
}