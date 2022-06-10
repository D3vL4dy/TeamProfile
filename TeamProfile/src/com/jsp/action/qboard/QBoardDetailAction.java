package com.jsp.action.qboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.QBoardVO;
import com.jsp.service.QBoardService;

public class QBoardDetailAction implements Action {

	private QBoardService qboardService;
	public void setQboardService(QBoardService qboardService) {
		this.qboardService = qboardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/q_board/detail";

		try {
			int qno = Integer.parseInt(request.getParameter("qno"));
			String from = request.getParameter("from");
			
			QBoardVO qboard;
			if(from!=null && from.equals("list")) {
				qboard=qboardService.getQBoard(qno);
				url="redirect:/qboard/detail.do?qno="+qno;
			}else {				
				qboard=qboardService.getQBoardForModify(qno);
			}
			request.setAttribute("qboard", qboard);
		} catch (Exception e) {
			e.printStackTrace();
			url = null;
			throw e;
		}

		return url;
	}


}
