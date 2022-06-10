package com.jsp.action.freeboard;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.CriteriaCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.service.FreeBoardService;
import com.jsp.service.MemberServiceImpl;

public class BoardListAction implements Action {
	

	private FreeBoardService freeBoardService;
	public void setFreeBoardService(FreeBoardService freeBoardService) {
		this.freeBoardService = freeBoardService;
	}

	private MemberServiceImpl memberservice;
	public void setMemberService(MemberServiceImpl memberService) {
		this.memberservice = memberService;
	}
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url = "/FreeBoard/list";
		
		try {

			CriteriaCommand criCMD
			=HttpRequestParameterAdapter.execute(request, CriteriaCommand.class);
			
			Criteria cri = criCMD.toCriteria();		
			
			Map<String, Object> dataMap = freeBoardService.getFreeBoardList(cri);
			request.setAttribute("dataMap", dataMap);
			
//			HttpSession session = request.getSession();
//			session.setAttribute("loginUser",memberservice.getMember("jh"));
		}catch (Exception e) {			
			e.printStackTrace();			
			//url="/error/500.jsp";
			throw e;
		}
		
		return url;
	}

}
