package com.jsp.action.wreply;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.CriteriaCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.controller.JSONResolver;
import com.jsp.service.WreplyService;

public class WreplyListAction implements Action {

	private WreplyService wreplyService;
	public void setWreplyService(WreplyService wreplyService) {
		this.wreplyService = wreplyService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		int wno = Integer.parseInt(request.getParameter("wno"));
		
		CriteriaCommand criCMD = HttpRequestParameterAdapter.execute(request, CriteriaCommand.class);
		Criteria cri = criCMD.toCriteria();
		
		Map<String, Object> dataMap = wreplyService.getWReplyList(wno, cri);
		
		JSONResolver.view(response, dataMap);
		
		return url;
	}

}
