package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.FreeBoardVO;

public interface FreeBoardService {
	
	// 목록조회	
	Map<String,Object> getFreeBoardList(Criteria cri)throws SQLException;
	
	FreeBoardVO getFBoard(int fno)throws SQLException;	
	FreeBoardVO getFBoardForModify(int fno)throws SQLException;
		
	// 등록
	void regist(FreeBoardVO freeBoard)throws SQLException;
		
	// 수정
	void modify(FreeBoardVO freeBoard)throws SQLException;
	
	// 삭제
	void remove(int fno)throws SQLException;
	
	// 최근 등록된 글 목록
	Map<String,Object> getRecentFreeBoardList(Criteria cri) throws SQLException;
}
