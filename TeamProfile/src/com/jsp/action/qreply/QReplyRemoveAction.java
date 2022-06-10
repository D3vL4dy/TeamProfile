package com.jsp.action.qreply;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.command.QReplyRemoveCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.service.QReplyService;

public class QReplyRemoveAction implements Action {
	
	private QReplyService qreplyService;
	public void setQreplyService(QReplyService qreplyService) {
		this.qreplyService = qreplyService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		QReplyRemoveCommand removeCMD = HttpRequestParameterAdapter.execute(request,QReplyRemoveCommand.class);
		//DB
		qreplyService.removeQReply(removeCMD.getQ_Rno());
		
		//page number		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(new Criteria());
		pageMaker.setTotalCount(qreplyService.getQReplyListCount(removeCMD.getQno()));

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
