package com.jsp.action.workBoard;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.jsp.action.Action;
import com.jsp.controller.FileUploadResolver;
import com.jsp.controller.GetUploadPath;
import com.jsp.controller.XSSMultipartHttpServletRequestParser;
import com.jsp.dto.WorkBoardVO;
import com.jsp.dto.WorkFileVO;
import com.jsp.service.WorkBoardService;

public class WorkBoardModifyAction implements Action {

	private WorkBoardService workBoardService;

	public void setWorkBoardService(WorkBoardService workBoardService) {
		this.workBoardService = workBoardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/workBoard/modify_success";
		
		try {
			//파일 삭제, 저장
			WorkBoardVO workBoard = modifyAttaches(request, response);
			
			//DB 처리
			workBoardService.modify(workBoard);

			request.setAttribute("workBoard", workBoard);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return url;
	}

	//업로드 파일 환경설정
		final private int MEMORY_THRESHOLD = 1024 * 1024 * 3; //3MB
		final private int MAX_FILE_SIZE = 1024 * 1024 * 40; //40MB
		final private int MAX_REQUEST_SIZE = 1024 *1024 * 200; //200MB
		
		private WorkBoardVO modifyAttaches(HttpServletRequest request, HttpServletResponse response) throws Exception {
			WorkBoardVO workBoard = null;
			
			XSSMultipartHttpServletRequestParser multi = new XSSMultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
			
			//파일 삭제 및 DB삭제
			String[] deleteFiles = multi.getParameterValues("deleteFile");
			if(deleteFiles != null && deleteFiles.length > 0) {
				for(String w_anoStr :deleteFiles) {
					int w_ano = Integer.parseInt(w_anoStr);
					WorkFileVO workFile = workBoardService.getWorkFileByWAno(w_ano);
					String filePath = workFile.getUploadPath() + File.separator + workFile.getFileName();
					File targetFile = new File(filePath);
					
					if(targetFile.exists()) {
						targetFile.delete();
					}
					workBoardService.removeAttachByAno(w_ano);
				}
			}
			
			//추가된 파일 저장
			FileItem[] fileItems = multi.getFileItems("uploadFile");
			List<WorkFileVO> workFileList = null;
			if(fileItems != null && fileItems.length > 0) {
				String uploadPath = GetUploadPath.getUploadPath("workBoard.upload");
				List<File> fileList = FileUploadResolver.fileUpload(fileItems, uploadPath);
				
				workFileList = new ArrayList<WorkFileVO>();
				if(fileList.size() > 0) for(File file : fileList) {
					WorkFileVO workFile = new WorkFileVO();
					workFile.setFileName(file.getName());
					workFile.setUploadpath(uploadPath);;
					workFile.setFileType(file.getName().substring(file.getName().lastIndexOf(".") + 1));
					workFileList.add(workFile);
				}
				
			}
			workBoard = new WorkBoardVO();
			workBoard.setWno(Integer.parseInt(multi.getParameter("wno")));
			workBoard.setTitle(multi.getXSSParameter("title"));
			workBoard.setContent(multi.getParameter("content"));
			workBoard.setWriter(multi.getXSSParameter("writer"));
			workBoard.setWorkFileList(workFileList);
			String selectEnd = multi.getParameter("selectEnd");
			if(selectEnd.equals("y")) {
				String endDateStr = multi.getParameter("endDate");
				Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);
				workBoard.setEndDate(endDate);
			} else {
				workBoard.setEndDate(null);
			}
			
			return workBoard;
		}
}
