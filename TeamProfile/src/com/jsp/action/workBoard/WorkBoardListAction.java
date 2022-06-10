package com.jsp.action.workBoard;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.CriteriaCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.service.WorkBoardService;

public class WorkBoardListAction implements Action {
	
	private WorkBoardService workBoardService;

	public void setWorkBoardService(WorkBoardService workBoardService) {
		this.workBoardService = workBoardService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/workBoard/list";
		
		try {
			CriteriaCommand criCMD = HttpRequestParameterAdapter.execute(request, CriteriaCommand.class);
			Criteria cri = criCMD.toCriteria();
			
			Map<String, Object> dataMap = workBoardService.getWorkBoardList(cri);
			request.setAttribute("dataMap", dataMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return url;
	}

}
