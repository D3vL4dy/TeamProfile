package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.WorkBoardVO;

public interface WorkBoardDAO {
	List<WorkBoardVO> selectWorkBoardCriteria(SqlSession session, Criteria cri)	throws SQLException;
	
	int selectWorkBoardCriteriaTotalCount(SqlSession session, Criteria cri) throws SQLException;
	
	WorkBoardVO selectWorkBoardByWno(SqlSession session, int wno)throws SQLException;
	
	void insertWorkBoard(SqlSession session, WorkBoardVO workBoard)throws SQLException;
	void updateWorkBoard(SqlSession session, WorkBoardVO workBoard)throws SQLException;
	void deleteWorkBoard(SqlSession session, int wno)throws SQLException;
	
	//viewcnt 증가
	void increaseViewCnt(SqlSession session, int wno)throws SQLException;
	
	//workBoard_seq.nextval 가져오기
	int getSeqNextValue(SqlSession session) throws SQLException;
}
