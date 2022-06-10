package com.jsp.dto;

import java.util.Date;

public class FReplyVO {

	private int f_rno       ;
	private String replytext   ;
	private Date regdate     ;
	private Date updatedate  ;
	private int fno         ;
	private String id          ;
	
	
	public int getF_rno() {
		return f_rno;
	}
	public void setF_rno(int f_rno) {
		this.f_rno = f_rno;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}                              
