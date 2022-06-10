package com.jsp.action.freeboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.dto.FreeBoardVO;
import com.jsp.service.FreeBoardService;

public class BoardRegistAction implements Action{
	
	private FreeBoardService freeBoardService;
	public void setFreeBoardService(FreeBoardService freeBoardService) {
		this.freeBoardService = freeBoardService;
	}

	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url="/FreeBoard/regist_success";
		
		
		try {
			FreeBoardVO freeBoard 
		= (FreeBoardVO)XSSHttpRequestParameterAdapter.execute(request, FreeBoardVO.class,true);
		
			freeBoard.setContent(request.getParameter("content"));
		
			freeBoardService.regist(freeBoard);
		}catch(Exception e) {
			e.printStackTrace();
			//url=null;
			throw e;
		}		
		
		
		return url;
	}

}





