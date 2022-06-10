package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.QBoardVO;

public interface QBoardService {
	
	// 목록조회	
	Map<String,Object> getQBoardList(Criteria cri)throws SQLException;
	
	// 상세보기
	QBoardVO getQBoard(int qno)throws SQLException;	
	QBoardVO getQBoardForModify(int qno)throws SQLException;
		
	// 등록
	void regist(QBoardVO qboard)throws SQLException;
		
	// 수정
	void modify(QBoardVO qboard)throws SQLException;
	
	// 삭제
	void remove(int qno)throws SQLException;
	
	// 답변완료목록
	Map<String,Object> getStatusQBoardList(Criteria cri) throws SQLException;
}
