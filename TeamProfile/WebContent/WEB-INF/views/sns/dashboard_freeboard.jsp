<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${dataMap.pageMaker }" var="pageMaker"/>
<c:set value="${dataMap.FreeBoardList }" var="freeBoard"/>
<c:set value="${pageMaker.cri }" var="cri"/>
<div class="card">
<div class="card-header" style="padding-top:5px;">
	<h3 class="card-title">
	최신글
	</h3>
	<div class="card-tools">
		<ul class="pagination pagination-sm">
			<li class="page-item"><a href="#" class="page-link">&laquo;</a></li>
			<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="page">
				<li class="page-item ${page eq cri.page ? 'active' : ''}">
					<a class="page-link" href="javascript:dashBoardList_go(${page }, 'pds')">
					${page }
					</a>
				</li>
			</c:forEach>
			<li class="page-item"><a href="#" class="page-link">&raquo;</a></li>
		</ul>
	</div>
</div>

<div class="card-body">
	<table class="table table-bordered text-center">
		<tr style="font-size:0.95em;">
			<th style="width:60%;">제 목</th>
			<th style="width:25%;">등록날짜</th>
			<th style="width:15%;">작성자</th>
		</tr>	
		<c:forEach items="${freeBoard }" var="board">
			<tr style='font-size:0.85em;'>
				<td id="boardTitle" style="text-align:left;max-width: 100px; overflow: hidden;
							 white-space: nowrap; text-overflow: ellipsis;">
					<a href="javascript:OpenWindow('<%=request.getContextPath() %>/FreeBoard/detail.do?fno=${board.fno }&from=list','상세보기',800,700);">
						<span class="col-sm-12 ">${board.title }</span>
					</a>
				</td>
				<td>
					<fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/>
				</td>
				<td>${board.id }</td>
			</tr>
		</c:forEach>	
		</table>
	</div>
</div>
<%@ include file="./dashboard_js.jsp" %>
