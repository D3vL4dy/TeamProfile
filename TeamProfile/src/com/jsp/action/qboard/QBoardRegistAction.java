package com.jsp.action.qboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.dto.QBoardVO;
import com.jsp.service.QBoardService;

public class QBoardRegistAction implements Action {

	private QBoardService qboardService;
	public void setQboardService(QBoardService qboardService) {
		this.qboardService = qboardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="/q_board/regist_success";
		
		try {
		QBoardVO qboard = XSSHttpRequestParameterAdapter.execute(request, QBoardVO.class,true);
		qboard.setContent(request.getParameter("content"));
		
		qboardService.regist(qboard);
		}catch(Exception e) {
			e.printStackTrace();
			//url=null;
			throw e;
		}		
		
		
		return url;
	}
	

}
