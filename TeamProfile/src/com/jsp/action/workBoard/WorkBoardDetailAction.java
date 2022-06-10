package com.jsp.action.workBoard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.MakeFileName;
import com.jsp.dto.WorkBoardVO;
import com.jsp.dto.WorkFileVO;
import com.jsp.service.WorkBoardService;

public class WorkBoardDetailAction implements Action {

	private WorkBoardService workBoardService;

	public void setWorkBoardService(WorkBoardService workBoardService) {
		this.workBoardService = workBoardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/workBoard/detail";
		
		int wno = Integer.parseInt(request.getParameter("wno"));
		String from = request.getParameter("from");
		
		try {
			WorkBoardVO workBoard = null;
			if(from!=null && from.equals("list")) {
				workBoard = workBoardService.read(wno);
				url ="redirect:/workBoard/detail.do?wno="+wno;
			} else {
				workBoard = workBoardService.getWorkBoard(wno);
			}
			
			List<WorkFileVO> renamedWorkFileList = MakeFileName.parseFileNameFromWorkFile(workBoard.getWorkFileList(), "\\$\\$");
			workBoard.setWorkFileList(renamedWorkFileList);
			
			if(workBoard.getEndDate() != null) {
				String endStr = new SimpleDateFormat("yyyy-MM-dd").format(workBoard.getEndDate());
				request.setAttribute("endStr", endStr);
			}
			
			request.setAttribute("workBoard", workBoard);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return url;
	}

}
