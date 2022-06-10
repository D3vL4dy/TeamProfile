package com.jsp.action.workBoard;

import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileUploadResolver;
import com.jsp.controller.GetUploadPath;
import com.jsp.controller.XSSMultipartHttpServletRequestParser;
import com.jsp.dto.WorkBoardVO;
import com.jsp.dto.WorkFileVO;
import com.jsp.exception.NotMultipartFormDataException;
import com.jsp.service.WorkBoardService;

public class WorkBoardRegistAction implements Action {
	
	private WorkBoardService workBoardService;

	public void setWorkBoardService(WorkBoardService workBoardService) {
		this.workBoardService = workBoardService;
	}
	
	final private int MEMORY_THRESHOLD = 1024 * 1024 * 3; //3MB
	final private int MAX_FILE_SIZE = 1024 * 1024 * 40; //40MB
	final private int MAX_REQUEST_SIZE = 1024 *1024 * 200; //200MB
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/workBoard/regist_success";
		
		XSSMultipartHttpServletRequestParser multi = null;
		List<WorkFileVO> workFileList = null;
		
		//파일 업로드
		
		try {
			
			//파싱
			multi = new XSSMultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
			
			//경로
			String uploadPath = GetUploadPath.getUploadPath("workBoard.upload");
			//저장
			List<File> fileList = FileUploadResolver.fileUpload(multi.getFileItems("uploadFile"), uploadPath);
			
			//리스트 변환
			if(fileList != null) {
				workFileList = new ArrayList<WorkFileVO>();
				for(File file : fileList) {
					WorkFileVO workFile = new WorkFileVO();
					workFile.setFileName(file.getName());
					workFile.setUploadpath(uploadPath);
					workFile.setFileType(file.getName().substring(file.getName().lastIndexOf(".") + 1));
					
					workFileList.add(workFile);
				}
			}
			
		} catch (NotMultipartFormDataException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		//DB처리
		WorkBoardVO workBoard = new WorkBoardVO();
		workBoard.setTitle(multi.getParameter("title"));
		workBoard.setContent(multi.getParameter("content"));
		workBoard.setWriter(multi.getXSSParameter("writer"));
		workBoard.setWorkFileList(workFileList);
		String selectEnd = multi.getParameter("selectEnd");
		if(selectEnd.equals("y")) {
			String endDateStr = multi.getParameter("endDate");
//			System.out.println("endDateStr :" + endDateStr);
			Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);
			workBoard.setEndDate(endDate);
		} else {
			System.out.println("null");
			workBoard.setEndDate(workBoard.getEndDate());
		}
		
		try {
			workBoardService.regist(workBoard);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return url;
	}

}
