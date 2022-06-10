package com.jsp.action.freereply;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dto.FReplyVO;
import com.jsp.service.FReplyService;

public class ReplyRegistAction implements Action {

	private FReplyService freplyService;
	public void setFreplyService(FReplyService freplyService) {
		this.freplyService = freplyService;
	}


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url =null;
		
		ObjectMapper mapper = new ObjectMapper();
		FReplyVO reply = mapper.readValue(request.getReader(), FReplyVO.class);
				
		//XSS
		reply.setReplytext(HTMLInputFilter.htmlSpecialChars(reply.getReplytext()));
		
		//DB
		try {
			freplyService.registReply(reply);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			return url;
		}
		
		//realEndPage
		int realEndPage = 1;
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(new Criteria());
		pageMaker.setTotalCount(freplyService.getReplyListCount(reply.getFno()));
		
		realEndPage = pageMaker.getRealEndPage();
		
		PrintWriter out = response.getWriter();
		out.print(realEndPage);
		
		out.close();
		
		return url;
	}

}
