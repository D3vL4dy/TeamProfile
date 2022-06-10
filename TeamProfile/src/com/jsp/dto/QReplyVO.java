package com.jsp.dto;

import java.util.Date;

public class QReplyVO {
	
	private int q_Rno;			// 고유번호
	private int qno;			// 게시글번호
	private String replytext;	// 댓글내용
	private String replyer;		// 작성자
	private Date regdate;		// 등록일
	private Date updatedate;	// 수정일
	
	public int getQ_Rno() {
		return q_Rno;
	}
	public void setQ_Rno(int q_Rno) {
		this.q_Rno = q_Rno;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
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
	
	@Override
	public String toString() {
		return "QReplyVO [q_Rno=" + q_Rno + ", qno=" + qno + ", replytext=" + replytext + ", replyer=" + replyer
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}
	

	
	
	
}
