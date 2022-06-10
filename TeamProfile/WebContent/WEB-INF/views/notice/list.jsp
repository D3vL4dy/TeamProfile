<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<c:set var="noticeList" value="${dataMap.noticeList }" />
<c:set var="pageMaker" value="${dataMap.pageMaker }" />
<c:set var="cri" value="${dataMap.pageMaker.cri }" />

<head></head>

<title>공지목록</title>

<body>
	 <!-- Main content -->
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>공지목록</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>공지사항
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	목록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	 
	 <!-- Main content -->
    <section class="content">		
		<div class="card">
			<div class="card-header with-border">
				<button type="button" class="btn btn-primary" id="registBtn" onclick="OpenWindow('registForm.do','공지등록',800,700);">공지등록</button>				
				<div id="keyword" class="card-tools" style="width:540px;">
					<div class="input-group row">
						<select class="form-control col-md-3" name="perPageNum" id="perPageNum"
					  		onchange="list_go(1);">
					  		<option value="10" ${cri.perPageNum eq 10 ? "selected":"" }>정렬개수</option>
					  		<option value="20" ${cri.perPageNum eq 20 ? "selected":"" }>20개씩</option>
					  		<option value="50" ${cri.perPageNum eq 50 ? "selected":"" }>50개씩</option>
					  		<option value="100" ${cri.perPageNum eq 100 ? "selected":"" }>100개씩</option>
					  		
					  	</select>						
						<select class="form-control col-md-4" name="searchType" id="searchType">
							<option value="tcw" ${cri.searchType=='tcw' ? "selected":"" }>전 체</option>
							<option value="t" ${cri.searchType=='t' ? "selected":"" }>제 목</option>
							<option value="w" ${cri.searchType=='w' ? "selected":"" }>작성자</option>
							<option value="c" ${cri.searchType=='c' ? "selected":"" }>내 용</option>
							<option value="tc" ${cri.searchType=='tc' ? "selected":"" }>제목+내용</option>
							<option value="cw" ${cri.searchType=='cw' ? "selected":"" }>작성자+내용</option>							
							<option value="tcw" ${cri.searchType=='tcw' ? "selected":"" }>작성자+제목+내용</option>
						</select>					
						<input  class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${param.keyword }"/>
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" onclick="list_go(1);" 
							data-card-widget="search">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					</div>
				</div>						
			</div>
			<div class="card-body">
				<table class="table table-bordered text-center" >					
					<tr style="font-size:0.95em;">
						<th style="width:10%;">번 호</th>
						<th style="width:40%;">제 목</th>
						<th style="width:10%;">작성자</th>
						<th style="width:15%;">등록일</th>
						<th style="width:15%;">마감일</th>
						<th style="width:10%;">조회수</th>
					</tr>				
					<c:if test="${!empty noticeList }">	
						<c:forEach items="${noticeList }" var="notice">
							<c:if test="${notice.fix eq '1'}">
								<tr style="font-size:0.85em;cursor:pointer;" onclick="OpenWindow('detail.do?from=list&nno=${notice.nno }','상세보기',800,700)">
								<td style="color:red;font-weight:bold">[공지]</td>
								<c:if test="${notice.view eq 'end' }" >
									<td id="boardTitle" style="text-align:left;max-width: 100px; overflow: hidden; 
														white-space: nowrap; text-overflow: ellipsis; color:red;font-weight:bold; text-decoration:line-through;" >
										${notice.title }
									</td>
								</c:if>
								<c:if test="${notice.view ne 'end' }" >
									<td id="boardTitle" style="text-align:left;max-width: 100px; overflow: hidden; 
														white-space: nowrap; text-overflow: ellipsis; color:red;font-weight:bold; " >
										${notice.title }
									</td>
								</c:if>
							</c:if>
							<c:if test="${notice.fix eq '0'}">
								<tr style="font-size:0.85em;cursor:pointer;" onclick="OpenWindow('detail.do?from=list&nno=${notice.nno }','상세보기',800,700)">
								<td>${notice.nno }</td>
								<c:if test="${notice.view eq 'end' }" >
									<td id="boardTitle" style="text-align:left;max-width: 100px; overflow: hidden; 
														white-space: nowrap; text-overflow: ellipsis; text-decoration:line-through;" >
										${notice.title }
									</td>
								</c:if>
								<c:if test="${notice.view ne 'end' }" >
									<td id="boardTitle" style="text-align:left;max-width: 100px; overflow: hidden; 
														white-space: nowrap; text-overflow: ellipsis; " >
										${notice.title }
									</td>
								</c:if>
							</c:if>
								<td data-target="notice-writer">${notice.writer }</td>							
								<td>
									<fmt:formatDate value="${notice.regDate }" pattern="yyyy-MM-dd" />
								</td>
								<c:if test="${empty notice.endDate }">
									<td>
										<span>-</span>
									</td>
								</c:if> 
								<c:if test="${!empty notice.endDate }">
									<td><fmt:formatDate value="${notice.endDate }" pattern="yyyy-MM-dd"/></td>
								</c:if>	
								<td><span class="badge bg-red">${notice.viewcnt }</span></td>		
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty noticeList }">
		     			<tr>
		     				<td colspan="7" class="text-center">
		     					해당내용이 없습니다.
		     				</td>
		     			</tr>
	     			</c:if>
				</table>				
			</div>
			<div class="card-footer">
				<%@ include file="/WEB-INF/views/common/pagination.jsp" %>
			</div>
		
		</div>
		
    </section>