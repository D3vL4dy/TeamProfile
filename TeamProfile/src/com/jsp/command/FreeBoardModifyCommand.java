package com.jsp.command;

import java.util.Date;

import com.jsp.dto.FreeBoardVO;


public class FreeBoardModifyCommand {
	
	private String fno;
	private String title;
	private String content;
	private String id;
	
	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
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

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public FreeBoardVO toBoardVO() {
		FreeBoardVO freeBoard = new FreeBoardVO();
		
		freeBoard.setFno(Integer.parseInt(this.fno));
		freeBoard.setTitle(this.title);
		freeBoard.setContent(this.content);
		freeBoard.setId(this.id);
		
		return freeBoard;
	}

}
