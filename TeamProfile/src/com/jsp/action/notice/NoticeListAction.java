package com.jsp.action.notice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.CriteriaCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.service.NoticeService;

public class NoticeListAction implements Action {
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/notice/list";
		
		Criteria cri = null;
		try {
			//입력
			CriteriaCommand command = HttpRequestParameterAdapter.execute(request, CriteriaCommand.class);
			cri = command.toCriteria();
		
			//처리
			Map<String, Object> dataMap = noticeService.getNoticeList(cri);
			request.setAttribute("dataMap", dataMap);
			
			//출력
			return url;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
