package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.QBoardVO;

public interface QBoardDAO {
	

	List<QBoardVO> selectQBoardCriteria(SqlSession session,Criteria cri) throws SQLException;

	int selectQBoardCriteriaTotalCount(SqlSession session,Criteria cri) throws SQLException;

	QBoardVO selectQBoardByQno(SqlSession session,int qno) throws SQLException;

	void insertQBoard(SqlSession session,QBoardVO qboard) throws SQLException;

	void updateQBoard(SqlSession session,QBoardVO qboard) throws SQLException;

	void deleteQBoard(SqlSession session,int qno) throws SQLException;

	// viewcnt 증가
	void increaseViewCnt(SqlSession session,int qno) throws SQLException;

	// board_seq.nextval 가져오기
	int selectQBoardSeqNext(SqlSession session) throws SQLException;
	
	// 답변완료된 List 가져오기
	List<QBoardVO> selectStatusQBoardList(SqlSession session, Criteria cri) throws SQLException;
	int selectStatusQBoardListCount(SqlSession session) throws SQLException;
}
