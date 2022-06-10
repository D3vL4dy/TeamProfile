package com.jsp.action.qreply;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.CriteriaCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.controller.JSONResolver;
import com.jsp.dto.QReplyVO;
import com.jsp.service.QReplyService;

public class QReplyListAction implements Action{

	private QReplyService qreplyService;
	public void setQreplyService(QReplyService qreplyService) {
		this.qreplyService = qreplyService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		int qno = Integer.parseInt(request.getParameter("qno"));
		
		CriteriaCommand criCMD = HttpRequestParameterAdapter.execute(request, CriteriaCommand.class);
		Criteria cri = criCMD.toCriteria();
		
		Map<String, Object> dataMap = qreplyService.getQReplyList(qno, cri);
		
		JSONResolver.view(response, dataMap);
		
		
		return url;
	}

}
