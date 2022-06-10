package com.jsp.dto;

import java.util.Date;
import java.util.List;

public class WorkBoardVO {
	private int wno;
	private String title;
	private String content;
	private Date regDate;
	private int viewcnt;
	private Date updatedate;
	private String writer;
	private Date endDate = null;
	
	private String view;
	
	private int wreplycnt;
	
	private List<WorkFileVO> workFileList;

	
	
	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getWno() {
		return wno;
	}

	public void setWno(int wno) {
		this.wno = wno;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getWreplycnt() {
		return wreplycnt;
	}

	public void setWreplycnt(int wreplycnt) {
		this.wreplycnt = wreplycnt;
	}

	public List<WorkFileVO> getWorkFileList() {
		return workFileList;
	}

	public void setWorkFileList(List<WorkFileVO> workFileList) {
		this.workFileList = workFileList;
	}
	
	
	
	
	
}
