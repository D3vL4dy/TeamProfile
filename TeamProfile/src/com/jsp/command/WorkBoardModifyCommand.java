package com.jsp.command;

import com.jsp.dto.WorkBoardVO;

public class WorkBoardModifyCommand {
	private String wno;          // 게시판번호
	private String title="";     // 제목
	private String writer;	  // 작성자 (회원)
	private String content="";   // 내용 (html)
	
	public String getWno() {
		return wno;
	}
	public void setWno(String wno) {
		this.wno = wno;
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
	
	public WorkBoardVO toWorkBoardVO() {
		WorkBoardVO workBoard = new WorkBoardVO();
		
		workBoard.setWno(Integer.parseInt(this.wno));
		workBoard.setTitle(this.title);
		workBoard.setContent(this.content);
		workBoard.setWriter(this.writer);
		
		return workBoard;
		
	}
	
}
