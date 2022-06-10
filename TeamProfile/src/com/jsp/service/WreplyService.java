package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.WReplyVO;

public interface WreplyService {
	//리스트 보기
	Map<String, Object> getWReplyList(int wno, Criteria cri) throws SQLException;
	
	//리스트 개수
	int getWReplyListCount(int wno) throws SQLException;
	
	//등록
	void registWReply(WReplyVO wReply) throws SQLException;
	
	//수정
	void modifyWReply(WReplyVO wReply) throws SQLException;
	
	//삭제
	void removeWReply(int w_rno) throws SQLException;
}
