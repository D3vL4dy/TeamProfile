package com.jsp.command;

import com.jsp.dto.QBoardVO;

public class QBoardModifyCommand {
		private String qno;
		private String title;
		private String writer;
		private String content;
		private String status;
		
		
		
		public QBoardVO toQBoardVO() {
			QBoardVO qboard = new QBoardVO();
			qboard.setQno(Integer.parseInt(this.qno));
			qboard.setTitle(title);
			qboard.setContent(content);
			qboard.setWriter(writer);
			qboard.setStatus(status);
			
			return qboard;
		}



		public String getQno() {
			return qno;
		}



		public void setQno(String qno) {
			this.qno = qno;
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



		public String getStatus() {
			return status;
		}



		public void setStatus(String status) {
			this.status = status;
		}



		
		
}
