package com.jsp.command;

public class QReplyRemoveCommand {
	
	private String qno;
	private String q_Rno;
	private String page;
	
	
	public int getQno() {
		return Integer.parseInt(qno);
	}
	public void setQno(String qno) {
		this.qno = qno;
	}
	public int getQ_Rno() {
		return Integer.parseInt(q_Rno);
	}
	public void setQ_Rno(String q_Rno) {
		this.q_Rno = q_Rno;
	}
	public int getPage() {
		return Integer.parseInt(page);
	}
	public void setPage(String page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "QReplyRemoveCommand [qno=" + qno + ", q_Rno=" + q_Rno + ", page=" + page + "]";
	}
	
	
}
