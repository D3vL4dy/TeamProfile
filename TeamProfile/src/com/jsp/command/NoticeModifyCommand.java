package com.jsp.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jsp.dto.NoticeVO;

public class NoticeModifyCommand {
	private String nno;
	private String title;
	private String content;
	private String writer;
	private String fix;
	private String endDate;
	
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
	public String getNno() {
		return nno;
	}
	public void setNno(String nno) {
		this.nno = nno;
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
		notice.setNno(Integer.parseInt(this.nno));
		notice.setTitle(this.title);
		notice.setContent(this.content);
		notice.setWriter(this.writer);
		notice.setFix(this.fix);
		Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(this.endDate);
		notice.setEndDate(endDate);
		
		return notice;
	}
}
