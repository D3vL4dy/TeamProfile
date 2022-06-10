package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.QReplyVO;

public interface QReplyDAO {
	
	void insertQReply(SqlSession session, QReplyVO qreply) throws SQLException;
	void updateQReply(SqlSession session, QReplyVO qreply) throws SQLException;
	void deleteQReply(SqlSession session, int q_Rno) throws SQLException;
	
	int selectQReplySeqNextValue(SqlSession session) throws SQLException;
	List<QReplyVO> selectQReplyListPage(SqlSession session,int qno, Criteria cri) throws SQLException;
	int countQReply(SqlSession session, int qno) throws SQLException;
}
