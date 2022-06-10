package com.jsp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jsp.dto.PFileVO;
import com.jsp.dto.WorkFileVO;

public class MakeFileName {
	
	
	public static String toUUIDFileName(String fileName, String delimiter) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + delimiter + fileName;
	}
	
	public static String parseFileNameFromUUID(String fileName,
				String delimiter) {
		String[] uuidFileName = fileName.split(delimiter);
		return uuidFileName[uuidFileName.length - 1];
	}
	
	public static List<PFileVO> parseFileNameFromAttaches(List<PFileVO> pfileList, String delimiter){
		List<PFileVO> renamedPfileList = new ArrayList<PFileVO>();
		
		if(pfileList != null) {
			for(PFileVO pfile : pfileList) {
				String fileName = pfile.getFilename();
				fileName = parseFileNameFromUUID(fileName, delimiter);
				
				pfile.setFilename(fileName);
				
				renamedPfileList.add(pfile);
			}
		}
		
		return renamedPfileList;
	}
	
	public static List<WorkFileVO> parseFileNameFromWorkFile(List<WorkFileVO> workFileList, String delimiter){
		List<WorkFileVO> renamedAttachList = new ArrayList<WorkFileVO>();
		
		if(workFileList != null) {
			for(WorkFileVO workFile : workFileList) {
				String fileName = workFile.getFileName(); //DB상의 fileName
				fileName = parseFileNameFromUUID(fileName, delimiter); //uuid가 제거된 fileName
				workFile.setFileName(fileName);
				
				renamedAttachList.add(workFile);
			}
		}
		
		return renamedAttachList;
	}
}









