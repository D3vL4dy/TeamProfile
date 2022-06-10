package com.jsp.action.freereply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.dto.FReplyVO;
import com.jsp.service.FReplyService;

public class ReplyModifyAction implements Action {

	private FReplyService freplyService;
	public void setFreplyService(FReplyService freplyService) {
		this.freplyService = freplyService;
	}


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url =null;
		
		ObjectMapper mapper = new ObjectMapper();
		FReplyVO reply = mapper.readValue(request.getReader(),FReplyVO.class);
		
		//XSS
		reply.setReplytext(HTMLInputFilter.htmlSpecialChars(reply.getReplytext()));
		
		//DB
		try {
			freplyService.modifyReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		
		return url;
	}

}
