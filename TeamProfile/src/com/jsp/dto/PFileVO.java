package com.jsp.dto;

public class PFileVO {
	private int p_ano     ;
	private String uploadpath;
	private String filename  ;
	private String filetype  ;
	private int pno       ;
	
	public int getP_ano() {
		return p_ano;
	}
	public void setP_ano(int p_ano) {
		this.p_ano = p_ano;
	}
	public String getUploadpath() {
		return uploadpath;
	}
	public void setUploadpath(String uploadpath) {
		this.uploadpath = uploadpath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	
	
}
