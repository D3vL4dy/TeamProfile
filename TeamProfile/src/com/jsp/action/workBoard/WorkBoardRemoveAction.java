package com.jsp.action.workBoard;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.WorkFileVO;
import com.jsp.service.WorkBoardService;

public class WorkBoardRemoveAction implements Action {

	private WorkBoardService workBoardService;

	public void setWorkBoardService(WorkBoardService workBoardService) {
		this.workBoardService = workBoardService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url ="/workBoard/remove_success";
		
		int wno = Integer.parseInt(request.getParameter("wno"));
		try {
			//파일 삭제
			List<WorkFileVO> workFileList = workBoardService.getWorkBoard(wno).getWorkFileList();
			if(workFileList != null) {
				for(WorkFileVO workFile : workFileList) {
					String storedFilePath = workFile.getUploadPath() + File.separator + workFile.getFileName();
					
					File file = new File(storedFilePath);
					
					if(file.exists()) {
						file.delete();
					}
				}
			}
			
			//DB내용 삭제
			workBoardService.remove(wno);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return url;
	}

}
