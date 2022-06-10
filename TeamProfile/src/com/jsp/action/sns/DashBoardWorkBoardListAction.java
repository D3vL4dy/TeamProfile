package com.jsp.action.sns;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.service.WorkBoardService;

public class DashBoardWorkBoardListAction implements Action{

	private WorkBoardService workBoardService;
	
	public void setWorkBoardService(WorkBoardService workBoardService) {
		this.workBoardService = workBoardService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/sns/dashboard_workboard";
		String page = request.getParameter("page");
		
		try {
			Criteria cri = new Criteria();
			
			boolean criFlag = true;
			criFlag = criFlag && page != null
							  && !page.isEmpty();
			try {				
				cri.setPage(Integer.parseInt(page));
				cri.setPerPageNum(5);
			}catch(Exception e) {
				e.printStackTrace();
				response.sendError(response.SC_BAD_REQUEST);
				return null;
			}
			
			Map<String, Object> dataMap = workBoardService.getDeadWordBoardList(cri);
			request.setAttribute("dataMap", dataMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return url;
	}

}
