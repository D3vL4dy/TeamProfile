package com.jsp.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jsp.dto.NoticeVO;

public class NoticeRegistCommand {
	private int nno;
	private String title;
	private String content;
	private String writer;
	private String fix;
	private String endDate;
	
	public int getNno() {
		return nno;
	}
	public void setNno(int nno) {
		this.nno = nno;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getFix() {
		return fix;
	}
	public void setFix(String fix) {
		this.fix = fix;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public NoticeVO toNoticeVO() throws ParseException {
		NoticeVO notice = new NoticeVO();
		notice.setNno(this.nno);
		notice.setTitle(this.title);
		notice.setContent(this.content);
		notice.setWriter(this.writer);
		notice.setFix(this.fix);
		Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(this.endDate);
		notice.setEndDate(endDate);
		
		return notice;
	}
}
