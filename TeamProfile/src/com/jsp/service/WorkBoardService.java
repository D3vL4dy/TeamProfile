package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.WorkBoardVO;
import com.jsp.dto.WorkFileVO;

public interface WorkBoardService {
	// 리스트조회
	Map<String, Object> getWorkBoardList(Criteria cri) throws SQLException;

	// 글조회
	WorkBoardVO getWorkBoard(int wno) throws SQLException;
	WorkBoardVO getWorkBoardForModify(int wno)throws SQLException;

	// 글작성
	void regist(WorkBoardVO workBoard) throws SQLException;

	// 글수정
	void modify(WorkBoardVO workBoard) throws SQLException;

	// 글삭제
	void remove(int wno) throws SQLException;

	// 글읽기(조회수증가)
	WorkBoardVO read(int wno) throws SQLException;
	
	//첨부파일 조회
	WorkFileVO getWorkFileByWAno(int w_ano)throws SQLException;
	
	//파일정보 삭제
	void removeAttachByAno(int w_ano)throws SQLException;
	
	//마감임박 목록
	Map<String,Object> getDeadWordBoardList(Criteria cri) throws SQLException;
	
}
