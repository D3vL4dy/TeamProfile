package com.jsp.command;

public class WreplyRemoveCommand {
	private String wno;
	private String w_rno;
	private String page;
	
	
	public int getWno() {
		return Integer.parseInt(wno);
	}
	public void setWno(String wno) {
		this.wno = wno;
	}
	public int getW_rno() {
		return Integer.parseInt(w_rno);
	}
	public void setW_rno(String w_rno) {
		this.w_rno = w_rno;
	}
	public int getPage() {
		return Integer.parseInt(page);
	}
	public void setPage(String page) {
		this.page = page;
	}
	
}
