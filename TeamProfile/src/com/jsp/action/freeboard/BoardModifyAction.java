package com.jsp.action.freeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.FreeBoardModifyCommand;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.dto.FreeBoardVO;
import com.jsp.service.FreeBoardService;

public class BoardModifyAction implements Action {
	
	private FreeBoardService freeBoardService;
	public void setFreeBoardService(FreeBoardService freeBoardService) {
		this.freeBoardService = freeBoardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws Exception{		
		String url = "redirect:/FreeBoard/detail.do?from=modify&fno="+request.getParameter("fno");
		
		try {
		FreeBoardModifyCommand modifyReq 
		= (FreeBoardModifyCommand)XSSHttpRequestParameterAdapter.execute(request, FreeBoardModifyCommand.class, true);
		
		FreeBoardVO freeBoard = modifyReq.toBoardVO();
		freeBoard.setContent(request.getParameter("content"));
		
		freeBoardService.modify(freeBoard);
		}catch(Exception e) {
			e.printStackTrace();
			url = null;
			throw e;
		}			
		
		return url;
	}

}








