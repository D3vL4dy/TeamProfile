package com.jsp.action.wreply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.dto.WReplyVO;
import com.jsp.service.WreplyService;

public class WreplyModifyAction implements Action {

	private WreplyService wreplyService;
	public void setWreplyService(WreplyService wreplyService) {
		this.wreplyService = wreplyService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		ObjectMapper mapper = new ObjectMapper();
		WReplyVO wreply = mapper.readValue(request.getReader(), WReplyVO.class);
		
		//XSS
		wreply.setReplytext(HTMLInputFilter.htmlSpecialChars(wreply.getReplytext()));
		
		//DB
		try {
			wreplyService.modifyWReply(wreply);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		
		return url;
	}

}
