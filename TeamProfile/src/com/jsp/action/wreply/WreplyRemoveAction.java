package com.jsp.action.wreply;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.command.WreplyRemoveCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.service.WreplyService;

public class WreplyRemoveAction implements Action {

	private WreplyService wreplyService;
	public void setWreplyService(WreplyService wreplyService) {
		this.wreplyService = wreplyService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		String w_rno = request.getParameter("w_rno");
		WreplyRemoveCommand removeCMD = HttpRequestParameterAdapter.execute(request, WreplyRemoveCommand.class);
		wreplyService.removeWReply(removeCMD.getW_rno());
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(new Criteria());
		pageMaker.setTotalCount(wreplyService.getWReplyListCount(removeCMD.getWno()));
		
		int realEndPage = pageMaker.getRealEndPage();
		
		int page = removeCMD.getPage();
		if(page > realEndPage) {
			page = realEndPage;
		}
		
		PrintWriter out = response.getWriter();
		out.print(page);
		out.close();
		
		return url;
	}

}
