package com.jsp.command;

import java.util.Date;

import com.jsp.dto.MemberVO;

public class MemberRegistCommand {
	private String id;
	private String pwd;
	private String name = "---";
	private String[] phone;
	private String email;
	private String address;
	

	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getPhone() {
		return phone;
	}
	public void setPhone(String[] phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public MemberVO toMemberVO() {
		String phone = "";
		
		for(String data : this.phone) {
			phone += data;
		}
		
		//MemberVO setting
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setPhone(phone);
		member.setEmail(email);
		member.setName(name);
		member.setAddress(address);
		return member;
		
	}
	
	
}


















