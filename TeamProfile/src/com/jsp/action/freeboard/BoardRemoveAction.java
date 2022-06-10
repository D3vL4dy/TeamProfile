package com.jsp.action.freeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.FreeBoardService;

public class BoardRemoveAction implements Action {


	private FreeBoardService freeBoardService;
	public void setFreeBoardService(FreeBoardService freeBoardService) {
		this.freeBoardService = freeBoardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		String url="/FreeBoard/remove_success";
		try {
			int fno = Integer.parseInt(request.getParameter("fno"));
		
			freeBoardService.remove(fno);
		}catch(Exception e) {			
			url= null;
			e.printStackTrace();
			throw e;
		}
		
		
		return url;
	}

	
	
}
