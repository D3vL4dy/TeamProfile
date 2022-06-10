package com.jsp.action.freeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;

public class BoardRegistFormAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url="/FreeBoard/regist";
		
		return url;
	}

}
