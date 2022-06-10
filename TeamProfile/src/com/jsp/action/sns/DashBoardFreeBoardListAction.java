package com.jsp.action.sns;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.service.FreeBoardService;

public class DashBoardFreeBoardListAction implements Action{

	private FreeBoardService freeBoardService;
	
	public void setFreeBoardService(FreeBoardService freeBoardService) {
		this.freeBoardService = freeBoardService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/sns/dashboard_freeboard";
		
		String page = request.getParameter("page");
		
		try {
			Criteria cri = new Criteria();
			
			boolean criFlag = true;
			criFlag = criFlag && page != null
							  && !page.isEmpty();

			
			if(criFlag) {
				try {
					cri.setPage(Integer.parseInt(page));
					cri.setPerPageNum(5);
				}catch(Exception e) {
					response.sendError(response.SC_BAD_REQUEST);
					return null;
				}
			}
			
			Map<String, Object> dataMap = freeBoardService.getRecentFreeBoardList(cri);
			request.setAttribute("dataMap", dataMap);
		}catch(Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		
		return url;
	}

}
