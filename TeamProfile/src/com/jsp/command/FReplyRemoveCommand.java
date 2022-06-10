package com.jsp.command;

public class FReplyRemoveCommand {
	
	private String fno;
	private String f_rno;
	private String page;
	
	
	public int getFno() {
		return Integer.parseInt(fno);
	}
	public void setFno(String fno) {
		this.fno = fno;
	}
	public int getF_rno() {
		return Integer.parseInt(f_rno);
	}
	public void setF_rno(String f_rno) {
		this.f_rno = f_rno;
	}
	public int getPage() {
		return Integer.parseInt(page);
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	
	
	
	
	
	
}
