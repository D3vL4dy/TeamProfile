package com.jsp.action.qreply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.dto.QReplyVO;
import com.jsp.service.QReplyService;

public class QReplyModifyAction implements Action {
	
	private QReplyService qreplyService;
	public void setQreplyService(QReplyService qreplyService) {
		this.qreplyService = qreplyService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		ObjectMapper mapper = new ObjectMapper();
		QReplyVO qreply = mapper.readValue(request.getReader(), QReplyVO.class);
		
		// XSS
//		qreply.setReplytext(HTMLInputFilter.htmlSpecialChars(qreply.getReplytext()));
		
		// DB
		try {
			qreplyService.modifyQReply(qreply);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		return url;
	}

}
