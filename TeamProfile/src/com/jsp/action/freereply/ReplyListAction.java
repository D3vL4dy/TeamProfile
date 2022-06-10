package com.jsp.action.freereply;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.CriteriaCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.controller.JSONResolver;
import com.jsp.service.FReplyService;

public class ReplyListAction implements Action {

	private FReplyService freplyService;
	public void setFreplyService(FReplyService freplyService) {
		this.freplyService = freplyService;
	}


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		int fno = Integer.parseInt(request.getParameter("fno"));
		
		
		CriteriaCommand criCMD = 
				HttpRequestParameterAdapter.execute(request, CriteriaCommand.class);
		Criteria cri = criCMD.toCriteria();
		
		Map<String, Object> dataMap = freplyService.getReplyList(fno,cri);
		
		//System.out.println("액션 : " + dataMap);
		
		JSONResolver.view(response, dataMap);
		
		return url;
	}

}
