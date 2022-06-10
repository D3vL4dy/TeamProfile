package com.jsp.action.workBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileDownloadResolver;
import com.jsp.dto.WorkFileVO;
import com.jsp.service.WorkBoardService;

public class WorkBoardGetFileAction implements Action {

	private WorkBoardService workBoardService;

	public void setWorkBoardService(WorkBoardService workBoardService) {
		this.workBoardService = workBoardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		try {
			int w_ano = Integer.parseInt(request.getParameter("w_ano"));
			WorkFileVO workFile = workBoardService.getWorkFileByWAno(w_ano);
			
			String fileName = workFile.getFileName();
			String savedPath = workFile.getUploadPath();
			
			FileDownloadResolver.sendFile(fileName, savedPath, request, response);
			
		} catch (Exception e) {
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		
		return url;
	}

}
