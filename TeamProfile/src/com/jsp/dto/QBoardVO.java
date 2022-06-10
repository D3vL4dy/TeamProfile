package com.jsp.dto;

import java.util.Date;

public class QBoardVO {

	private int qno;          // 게시판번호
	private String title;
	private String writer;
	private String content;
	private int viewcnt;      // 조회수
	private Date regDate;     // 등록날짜
	private Date updatedate;  // 수정날짜
	private String status;
	
	private int replycnt; // 댓글 개수

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public int getReplycnt() {
		return replycnt;
	}

	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
	
	@Override
	public String toString() {
		return "QBoardVO [qno=" + qno + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", viewcnt=" + viewcnt + ", regDate=" + regDate + ", updatedate=" + updatedate + ", status=" + status
				+ ", replycnt=" + replycnt + "]";
	}
	
}
