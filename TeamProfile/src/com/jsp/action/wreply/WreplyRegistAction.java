package com.jsp.action.wreply;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dto.WReplyVO;
import com.jsp.service.WreplyService;

public class WreplyRegistAction implements Action {

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
			wreplyService.registWReply(wreply);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		
		//realEndPage
		int realEndPage = 1;
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(new Criteria());
		pageMaker.setTotalCount(wreplyService.getWReplyListCount(wreply.getWno()));
		
		realEndPage = pageMaker.getRealEndPage();
		
		PrintWriter out = response.getWriter();
		out.println(realEndPage);
		
		out.close();
		
		return url;
	}

}
