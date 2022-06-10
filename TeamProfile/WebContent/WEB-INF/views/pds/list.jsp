<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${dataMap.pdsList }" var="pdsList"/>
<c:set value="${dataMap.readPdsList }" var="readPdsList"/>
<c:set value="${dataMap.pageMaker }" var="pageMaker"/>
<c:set value="${pageMaker.cri }" var="cri"/>

	 <!-- Main content -->
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>자료실</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right" style="color:white;">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>자료실
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
				<button type="button" class="btn btn-primary" id="registBtn" onclick="OpenWindow('registForm.do','글등록',800,700);">자료 등록</button>				
				<div id="keyword" class="card-tools" style="width:450px;">
					<div class="input-group row">
						<select class="form-control col-md-3" name="perPageNum" id="perPageNum"
					  		onchange="list_go();">
					  		<option value="10" ${cri.perPageNum eq 10 ? 'selected' : '' }>정렬개수</option>
					  		<option value="20" ${cri.perPageNum eq 20 ? 'selected' : '' }>20개씩</option>
					  		<option value="50" ${cri.perPageNum eq 30 ? 'selected' : '' }>30개씩</option>
					  		<option value="100" ${cri.perPageNum eq 50 ? 'selected' : '' }>50개씩</option>
					  		
					  	</select>						
						<select class="form-control col-md-4" name="searchType" id="searchType">
							<option value="tcw" ${cri.searchType eq 'twc' ? 'selected' : '' }>전 체</option>
							<option value="t" ${cri.searchType eq 't' ? 'selected' : '' }>제 목</option>
							<option value="w" ${cri.searchType eq 'w' ? 'selected' : '' }>작성자</option>
							<option value="c" ${cri.searchType eq 'c' ? 'selected' : '' }>내 용</option>
							<option value="tc" ${cri.searchType eq 'tc' ? 'selected' : '' }>제목+내용</option>
							<option value="cw" ${cri.searchType eq 'cw' ? 'selected' : '' }>작성자+내용</option>							
							<option value="tcw" ${cri.searchType eq 'tcw' ? 'selected' : '' }>작성자+제목+내용</option>
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
						<th style="width:10%;">첨부파일</th>
						<th style="width:15%;">작성자</th>
						<th style="width:15%;">등록일</th>
						<th style="width:10%;">조회수</th>
					</tr>				
					<c:if test="${empty pdsList }" >
						<tr>
							<td colspan="5">
								<strong>해당 내용이 없습니다.</strong>
							</td>
						</tr>
					</c:if>						
					<c:forEach items="${pdsList }" var="pds">
						<tr style='font-size:0.85em;
						<c:forEach items="${readPdsList }" var="readPds">
							<c:if test="${readPds.pno eq pds.pno }">background:lightgray</c:if>
						</c:forEach>'>
							<td>${pds.pno }</td>
							<td id="pdsTitle" style="text-align:left;max-width: 100px; overflow: hidden; 
													white-space: nowrap; text-overflow: ellipsis; cursor:pointer;" 
													onclick="OpenWindow('detail.do?pno=${pds.pno }&from=list','상세보기',800,700);">
								<a href="javascript:OpenWindow('detail.do?from=list&pno=${pds.pno }','상세보기',800,700);">								
									<span class="col-sm-12 " >
										${pds.title }
									</span>								
								</a>
								<c:if test="${pds.important eq 1 }">								
									<span class="material-symbols-outlined" style="font-size: 18px; position: absolute; color:red;">
										star
									</span>
								</c:if>		
							</td>
							<td>
								<c:if test="${!empty pds.pfileList}">
									<i class="nav-icon fas fa-file"></i>
								</c:if>
								<c:if test="${empty pds.pfileList}">
									<span>-</span>
								</c:if>
							</td>
							<td>
								${pds.writer }
							</td>
							<td>
								<fmt:formatDate value="${pds.regDate }" pattern="yyyy-MM-dd"/>
							</td>
							<td><span class="badge bg-red">${pds.viewcnt }</span></td>
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
    <!-- /.content -->

