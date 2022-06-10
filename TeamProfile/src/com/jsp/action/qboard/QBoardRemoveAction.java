package com.jsp.action.qboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.QBoardService;

public class QBoardRemoveAction implements Action {

	private QBoardService qboardService;
	public void setQboardService(QBoardService qboardService) {
		this.qboardService = qboardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="/q_board/remove_success";
		try {
			int qno = Integer.parseInt(request.getParameter("qno"));
		
			qboardService.remove(qno);
		}catch(Exception e) {			
			url= null;
			e.printStackTrace();
			throw e;
		}
		
		
		return url;
	}

}
