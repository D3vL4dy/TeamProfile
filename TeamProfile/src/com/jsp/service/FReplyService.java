package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.FReplyVO;

public interface FReplyService {

	//리스트보기
	Map<String, Object> getReplyList(int fno, Criteria cri) throws SQLException;
	
	//리스트 개수
	int getReplyListCount(int fno)throws SQLException;
	
	//등록
	void registReply(FReplyVO freply)throws SQLException;
	
	//수정
	void modifyReply(FReplyVO freply)throws SQLException;
	
	//삭제
	void removeReply(int f_rno)throws SQLException;
}
