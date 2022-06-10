package com.jsp.action.qboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.QBoardModifyCommand;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.dto.QBoardVO;
import com.jsp.service.QBoardService;

public class QBoardModifyAction implements Action {

	private QBoardService qboardService;
	public void setQboardService(QBoardService qboardService) {
		this.qboardService = qboardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "redirect:/qboard/detail.do?from=modify&qno="+request.getParameter("qno");
		
		try {
		QBoardModifyCommand modifyReq 
		= (QBoardModifyCommand)XSSHttpRequestParameterAdapter.execute(request, QBoardModifyCommand.class, true);
		
		
		QBoardVO qboard = modifyReq.toQBoardVO();
		qboard.setContent(request.getParameter("content"));
		qboardService.modify(qboard);
		}catch(Exception e) {
			e.printStackTrace();
			url = null;
			throw e;
		}			
		
		return url;
	}

}
