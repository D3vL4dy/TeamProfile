package com.jsp.action.qboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.QBoardVO;
import com.jsp.service.QBoardService;

public class QBoardModifyFormAction implements Action {

	private QBoardService qboardService;
	public void setQboardService(QBoardService qboardService) {
		this.qboardService = qboardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/q_board/modify";

		try {
			int qno = Integer.parseInt(request.getParameter("qno"));

			QBoardVO qboard = qboardService.getQBoardForModify(qno);

			request.setAttribute("qboard", qboard);
		} catch (Exception e) {
			e.printStackTrace();
			url = null;
			throw e;
		}

		return url;
	}

}
