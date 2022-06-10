package com.jsp.command;

public class SearchCriteria extends Criteria {
	private String keyword;  //Member-Mapper 에서 참조
	private String searchType;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	
}
