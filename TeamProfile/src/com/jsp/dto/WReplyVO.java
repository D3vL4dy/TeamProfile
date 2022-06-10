package com.jsp.dto;

import java.util.Date;

public class WReplyVO {
	private int w_rno;			//고유번호
	private int wno;			//게시글 번호
	private String replyer;		//댓글내용
	private String replytext;	//작성자
	private Date regdate;		//등록일
	private Date updatedate;	//수정일
	
	private String picture;		//작성자 사진

	public int getW_rno() {
		return w_rno;
	}

	public void setW_rno(int w_rno) {
		this.w_rno = w_rno;
	}

	public int getWno() {
		return wno;
	}

	public void setWno(int wno) {
		this.wno = wno;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
}
