<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function dashBoardList_go(page, cate){
		var url = null;
		
		if(cate == 'pds') url = 'dashboardPdsList.do?page='+page
		if(cate == 'qboard') url = 'dashboardQBoardList.do?page='+page
				
		location.href = url;
	}
</script>