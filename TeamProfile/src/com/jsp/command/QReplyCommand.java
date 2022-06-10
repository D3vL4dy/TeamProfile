package com.jsp.command;

import com.jsp.dto.QReplyVO;

public class QReplyCommand {

	private String qno;
	private String replyer;
	private String replytext;
	public String getQno() {
		return qno;
	}
	public void setQno(String qno) {
		this.qno = qno;
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
	
	public QReplyVO toQReplyVO() {
		QReplyVO reply = new QReplyVO();
		reply.setQno(Integer.parseInt(this.qno));
		reply.setReplyer(this.replyer);
		reply.setReplytext(this.replytext);
		
		return reply;
	}
}
