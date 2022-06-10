package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.FreeBoardVO;

public interface FreeBoardDAO {

	List<FreeBoardVO> selectFreeBoardCriteria(SqlSession session,Criteria cri) throws SQLException;

	int selectFreeBoardCriteriaTotalCount(SqlSession session,Criteria cri) throws SQLException;

	FreeBoardVO selectFreeBoardByFno(SqlSession session,int fno) throws SQLException;

	void insertFreeBoard(SqlSession session,FreeBoardVO freeBoard) throws SQLException;

	void updateFreeBoard(SqlSession session,FreeBoardVO freeBoard) throws SQLException;

	void deleteFreeBoard(SqlSession session,int fno) throws SQLException;

	// viewcnt 증가
	void increaseViewCnt(SqlSession session,int fno) throws SQLException;

	// board_seq.nextval 가져오기
	int selectFreeBoardSeqNext(SqlSession session) throws SQLException;
}
