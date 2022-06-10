package com.jsp.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.MemberRegistCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class MemberRegistAction implements Action {

	private MemberService memberService;
	public void setSearchMemberService(MemberService memberService) {
		this.memberService=memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//화면
		String url="/member/regist_success";
				
		//입력
		try {
			
			//리플렉션 연습 - > class<T>
			request.setCharacterEncoding("utf-8");
			
			MemberRegistCommand command =HttpRequestParameterAdapter.execute(request,
							MemberRegistCommand.class ); // type 이여서 .class 쓴다
			MemberVO member = command.toMemberVO();
					
			//처리
			memberService.regist(member);
		
		}catch(Exception e) {
			e.printStackTrace();
			//exception 처리.....
			url="/member/regist_fail";
		}
		
		return url;
	}

}
