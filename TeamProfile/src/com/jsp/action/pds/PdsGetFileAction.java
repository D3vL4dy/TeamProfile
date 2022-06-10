package com.jsp.action.pds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileDownloadResolver;
import com.jsp.dto.PFileVO;
import com.jsp.service.PdsService;

public class PdsGetFileAction implements Action{

	private PdsService pdsService;
	
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		try {
			int p_ano = Integer.parseInt(request.getParameter("p_ano"));
			
			PFileVO pfile = pdsService.getPFileByAno(p_ano);
			
			String fileName = pfile.getFilename();
			String uploadPath = pfile.getUploadpath();
			
			FileDownloadResolver.sendFile(fileName, uploadPath, request, response);
		}catch(Exception e) {
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			url=null;
			e.printStackTrace();
		}
		
		return url;
	}

}
