package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.NoticeVO;

public interface NoticeService {
	Map<String, Object> getNoticeList(Criteria cri) throws SQLException;
	
	NoticeVO getNotice(int nno) throws SQLException;
	
	NoticeVO getNoticeForModify(int nno) throws SQLException;

	void regist(NoticeVO notice)throws SQLException;
	
	void modify(NoticeVO notice) throws SQLException;

	void remove(int nno) throws SQLException;
}
