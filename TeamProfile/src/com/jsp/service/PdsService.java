package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.PFileVO;
import com.jsp.dto.PdsVO;

public interface PdsService {
	

	// 리스트조회
	Map<String, Object> getList(Criteria cri, String loginUserId) throws SQLException;

	// 글조회
	PdsVO getPds(int pno) throws SQLException;

	// 글작성
	void regist(PdsVO pds) throws SQLException;

	// 글수정
	void modify(PdsVO pds) throws SQLException;

	// 글삭제
	void remove(int pno) throws SQLException;

	// 글읽기(조회수증가)
	PdsVO read(int pno, String loginUser) throws SQLException;
	
	
	//첨부파일 조회
	PFileVO getPFileByAno(int p_ano)throws SQLException;
	
	//파일정보 삭제
	void removePFileByAno(int p_ano)throws SQLException;
	
	//중요한 자료글 목록 가져오기
	Map<String, Object> getImportantList(Criteria cri) throws SQLException;

}








