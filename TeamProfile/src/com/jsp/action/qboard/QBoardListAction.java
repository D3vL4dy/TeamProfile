package com.jsp.action.qboard;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.CriteriaCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.service.MemberServiceImpl;
import com.jsp.service.QBoardService;

public class QBoardListAction implements Action {
	

	private QBoardService qboardService;
	public void setQboardService(QBoardService qboardService) {
		this.qboardService = qboardService;
	}
	
	private MemberServiceImpl memberService;
	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url = "/q_board/list";
		
		try {

			CriteriaCommand criCMD
			=(CriteriaCommand)HttpRequestParameterAdapter.execute(request, CriteriaCommand.class);
			
			Criteria cri = criCMD.toCriteria();	

			
			Map<String, Object> dataMap = qboardService.getQBoardList(cri);
			request.setAttribute("dataMap", dataMap);
			
		}catch (Exception e) {			
			e.printStackTrace();			
			//url="/error/500.jsp";
			throw e;
		}
		
		return url;
	}

}
