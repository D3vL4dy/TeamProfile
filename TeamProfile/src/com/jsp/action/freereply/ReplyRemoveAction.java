package com.jsp.action.freereply;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.command.FReplyRemoveCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.service.FReplyService;

public class ReplyRemoveAction implements Action {
	
	private FReplyService freplyService;
	public void setFreplyService(FReplyService freplyService) {
		this.freplyService = freplyService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		FReplyRemoveCommand removeCMD = HttpRequestParameterAdapter
				.execute(request,FReplyRemoveCommand.class);
		
		//DB
		freplyService.removeReply(removeCMD.getF_rno());
		
		//page number		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(new Criteria());
		pageMaker.setTotalCount(freplyService.getReplyListCount(removeCMD.getFno()));

		int realEndPage = pageMaker.getRealEndPage();

		int page=removeCMD.getPage();
		if (page > realEndPage) {			
			page = realEndPage;
		}

		PrintWriter out = response.getWriter();
		out.print(page);
		out.close();
		
		return url;
	}

}
