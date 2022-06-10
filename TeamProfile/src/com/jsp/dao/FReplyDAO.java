package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.FReplyVO;

public interface FReplyDAO {

	void insertFReply(SqlSession session, FReplyVO freply)throws SQLException;
	void updateFReply(SqlSession session, FReplyVO freply)throws SQLException;
	void deleteFReply(SqlSession session, int fRno)throws SQLException;
	
	int selectFReplySeqNextValue(SqlSession session)throws SQLException;
	List<FReplyVO>selectFReplyListPage(SqlSession session, int bon, Criteria cri)throws SQLException;
	
	int countReply(SqlSession session, int fno)throws SQLException;
}
