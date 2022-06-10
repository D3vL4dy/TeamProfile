package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.WReplyVO;

public interface WreplyDAO {
	void insertWReply(SqlSession session, WReplyVO wReply) throws SQLException;
	void updateWReply(SqlSession session, WReplyVO wReply) throws SQLException;
	void deleteWReply(SqlSession session, int w_rno) throws SQLException;
	
	int selectWReplySeqNextValue(SqlSession session) throws SQLException;
	
	List<WReplyVO> selectWReplyListPage(SqlSession session, int wno, Criteria cri) throws SQLException;
	
	int countWReply(SqlSession session, int wno) throws SQLException;
}
