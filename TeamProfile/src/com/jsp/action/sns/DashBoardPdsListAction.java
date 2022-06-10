package com.jsp.action.sns;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.controller.JSONResolver;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;

public class DashBoardPdsListAction implements Action{

	private PdsService pdsService;
	
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/sns/dashboard_pds";
		
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
			
			Map<String, Object> dataMap = pdsService.getImportantList(cri);
			request.setAttribute("dataMap", dataMap);
		}catch(Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		
		return url;
	}

}
