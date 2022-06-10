package com.jsp.action.qreply;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.command.QReplyCommand;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.dto.QBoardVO;
import com.jsp.dto.QReplyVO;
import com.jsp.service.QReplyService;

public class QReplyRegistAction implements Action {

	
	private QReplyService qreplyService;
	public void setQreplyService(QReplyService qreplyService) {
		this.qreplyService = qreplyService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		
		QReplyCommand qreplyCMD = XSSHttpRequestParameterAdapter.execute(request, QReplyCommand.class, true);
		QReplyVO qreply = qreplyCMD.toQReplyVO();
		qreply.setReplytext(request.getParameter("replytext"));
//	   ObjectMapper mapper=new ObjectMapper();
//	   QReplyVO qreply=mapper.readValue(request.getReader(),QReplyVO.class);
	   
//	   //XSS
//	   //qreply.setReplytext(HTMLInputFilter.htmlSpecialChars(qreply.getReplytext()));
	   
	   //DB
	   try {
		   qreplyService.registQReply(qreply);
	   } catch (SQLException e) {
		  e.printStackTrace();
		  response.sendError(response.SC_INTERNAL_SERVER_ERROR);;
		  return url;
	   }
	   
	   
	   //realEndPage
	   int realEndPage=1;
	   
	   PageMaker pageMaker=new PageMaker();
	   pageMaker.setCri(new Criteria());
	   pageMaker.setTotalCount(qreplyService.getQReplyListCount(qreply.getQno()));
	   
	   realEndPage=pageMaker.getRealEndPage();
	   
	   PrintWriter out=response.getWriter();
	   out.print(realEndPage);
	   
	   out.close();
		return url;
	}

}
