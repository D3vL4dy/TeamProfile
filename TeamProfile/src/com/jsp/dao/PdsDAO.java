package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.PdsVO;

public interface PdsDAO {
	

	List<PdsVO> selectPdsCriteria(SqlSession session,Criteria cri)	throws SQLException;
	int selectPdsCriteriaTotalCount(SqlSession session,Criteria cri) throws SQLException;
	
	PdsVO selectPdsByPno(SqlSession session,int pno)throws SQLException;
	
	void insertPds(SqlSession session,PdsVO pds)throws SQLException;
	void updatePds(SqlSession session,PdsVO pds)throws SQLException;
	void deletePds(SqlSession session,int pno)throws SQLException;
	
	//viewcnt  증가
	void increaseViewCnt(SqlSession session,int pno)throws SQLException;
	
	//pds_seq.nextval 가져오기
	int getSeqNextValue(SqlSession session) throws SQLException;
	
	//rpno_seq.nextval 가져오기
	int getRpnoSeqNextValue(SqlSession session) throws SQLException;
	
	//읽은글 등록
	void insertReadPds(SqlSession session, Map<String, Object> params) throws SQLException;
	
	//읽은글 체크
	int selectCheckReadPds(SqlSession session, Map<String, Object> params) throws SQLException;
	
	//읽은글 목록 가져오기
	List<PdsVO> selectReadPdsListById(SqlSession session, String loginUserId) throws SQLException;
	
	//중요한 자료글 목록 가져오기
	List<PdsVO> selectImportantPdsList(SqlSession session, Criteria cri) throws SQLException;
	int selectImportantPdsListCount(SqlSession session) throws SQLException;
}
