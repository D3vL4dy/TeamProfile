package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.QReplyVO;

public interface QReplyService {
	
	// 리스트보기
	Map<String, Object> getQReplyList(int qno, Criteria cri) throws SQLException;
	
	// 리스트 개수
	int getQReplyListCount(int qno) throws SQLException;
	
	// 등록
	void registQReply(QReplyVO qreply) throws SQLException;
	
	// 수정
	void modifyQReply(QReplyVO qreply) throws SQLException;
	
	// 삭제
	void removeQReply(int q_Rno) throws SQLException;
}
