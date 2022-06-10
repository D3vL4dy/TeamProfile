<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:set var="pageMaker" value="${dataMap.pageMaker }" />
<c:set var="workBoardList" value="${dataMap.workBoardList }" /> 
<c:set var="cri" value="${pageMaker.cri }" />

<head>
<style>
	table th,td{
		text-align:center;
	}
	
</style>
</head>

<body>
  
    <!-- Content Header (Page header) -->
    <section class="content-header">
    	<div class="container-fluid">
    		<div class="row mb-2">
    			<div class="col-sm-6">
	      			<h1>취업정보방</h1>
	      		</div>	      		
	    	
	       		
	       		<div class="col-sm-6">
			      <ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item"><a href="list.do"><i class="fa fa-dashboard"></i>취업정보방</a></li>
			        <li class="breadcrumb-item active">리스트</li>		        
			      </ol>
		      	</div>
	     	</div>	     	
      	</div>
    </section>

    <!-- Main content -->
    <section class="content">
		<div class="card">
			<div class="card-header with-border">
				<button type="button" class="btn btn-primary" id="registBtn" onclick="OpenWindow('registForm.do','상세보기',800,700);">취업정보등록</button>
				<div id="keyword" class="card-tools" style="width:450px;">	
					<div class="input-group row">
						<select class="form-control col-md-3" name="perPageNum" id="perPageNum">
					  		<option value="10" ${cri.perPageNum==10 ? 'selected':'' } >정렬개수</option>
					  		<option value="20" ${cri.perPageNum==20 ? 'selected':'' }>20개씩</option>
					  		<option value="30" ${cri.perPageNum==30 ? 'selected':'' }>30개씩</option>
					  		<option value="50" ${cri.perPageNum==50 ? 'selected':'' }>50개씩</option>
					  		
					  	</select>		
						<select class="form-control col-md-3" name="searchType" id="searchType">
							<option value="tcw" ${cri.searchType eq 'tcw' ? 'selected':'' }>전 체</option>
							<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제 목</option>
							<option value="w" ${cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
							<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내 용</option>
							<option value="tc" ${cri.searchType eq 'tc' ? 'selected':'' }>제목+내용</option>
							<option value="cw" ${cri.searchType eq 'cw' ? 'selected':'' }>작성자+내용</option>																			
						</select>	
										
						<input  class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${cri.keyword }"/>
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" id="searchBtn" data-card-widget="search" onclick="list_go(1);">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					</div>						
				</div>			
			</div>
			<div class="card-body">
				<table class="table table-bordered text-center">
					<tr style="font-size:0.95em;">
						<th style="width:10%;">번 호</th>
						<th style="width:40%;">제 목</th>
						<th style="width:10%;">첨부파일</th>
						<th style="width:10%;">작성자</th>
						<th style="width:10%;">등록일</th>
						<th style="width:10%;">마감일</th>
						<th style="width:10%;">조회수</th>
					</tr>
					<c:if test="${empty workBoardList }" >
						<tr>
							<td colspan="6">
								<strong>해당 내용이 없습니다.</strong>
							</td>
						</tr>
					</c:if>							
					<c:forEach items="${workBoardList }" var="workBoard">
						<tr style='font-size:0.85em;'>
							<td>${workBoard.wno }</td>
							<c:if test="${workBoard.view eq 'end' }" >
							<td id="boardTitle" style="text-align:left;max-width: 100px; overflow: hidden;
										 white-space: nowrap; text-overflow: ellipsis; text-decoration:line-through;">
								<a style=color:gray; href="javascript:OpenWindow('detail.do?from=list&wno=${workBoard.wno }','상세보기',800,700);">
									<span class="col-sm-12 ">${workBoard.title } (기간 마감)
										<c:if test="${workBoard.wreplycnt ne 0 }">
											<span class="nav-item">
											&nbsp;&nbsp;<i class="fa fa-comment"></i>
											<span class="badge badge-warning navbar-badge">${workBoard.wreplycnt }</span>
											</span>
										</c:if>									
									</span>
								</a>
							</td>
							</c:if>	
							<c:if test="${workBoard.view ne 'end' }" >
							<td id="boardTitle" style="text-align:left;max-width: 100px; overflow: hidden;
										 white-space: nowrap; text-overflow: ellipsis;">
								<a href="javascript:OpenWindow('detail.do?from=list&wno=${workBoard.wno }','상세보기',800,700);">
									<span class="col-sm-12 ">${workBoard.title }
										<c:if test="${workBoard.wreplycnt ne 0 }">
											<span class="nav-item">
											&nbsp;&nbsp;<i class="fa fa-comment"></i>
											<span class="badge badge-warning navbar-badge">${workBoard.wreplycnt }</span>
											</span>
										</c:if>									
									</span>
								</a>
							</td>
							</c:if>	
							<td style='text-decoration:none;'>
								<c:if test="${!empty workBoard.workFileList }">
									<i class="nav-icon fas fa-file"></i>
								</c:if>
								<c:if test="${empty workBoard.workFileList }">
									<span>-</span>
								</c:if>
							</td>
							<td>${workBoard.writer }</td>
							<td>
								<fmt:formatDate value="${workBoard.regDate }" pattern="yyyy-MM-dd"/>
							</td>
							<td>
								<c:if test="${!empty workBoard.endDate }">
									<fmt:formatDate value="${workBoard.endDate }" pattern="yyyy-MM-dd"/>
								</c:if>
								<c:if test="${empty workBoard.endDate }">
									<span>-</span>
								</c:if>
							</td>
							<td><span class="badge bg-red">${workBoard.viewcnt }</span></td>
						</tr>
					</c:forEach>	
				</table>
			</div>
			<div class="card-footer">
				<nav aria-label="pds list Navigation">
					<ul class="pagination justify-content-center m-0">
						<%@ include file="/WEB-INF/views/common/pagination.jsp" %>	
					</ul>
				</nav>
			</div>
		</div>
	</section>

</body>






