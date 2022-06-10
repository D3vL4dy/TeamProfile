<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.min.css">
</head>
<title>게시글 상세</title>
<body>

  <!-- Content Wrapper. Contains page content -->
  <div>
   
   
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>질문게시판</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>질문게시판
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	상세보기
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	 
   
      <!-- Main content -->
    <section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h3 class="card-title">상세보기</h3>
						<div class="card-tools">
							<button type="button" id="modifyBtn" class="btn btn-warning" onclick="modify_go();" ${loginUser.id ne qboard.writer ? 'style="display:none"':'' }>수정</button>						
						    <button type="button" id="removeBtn" class="btn btn-danger" onclick="remove_go();" ${loginUser.id ne qboard.writer ? 'style="display:none"':'' }>삭제</button>
						    <button type="button" id="listBtn" class="btn btn-primary" onclick="CloseWindow();">닫기</button>
					    </div>
					</div>
					<div class="card-body">
						<div class="form-group col-sm-12">
							<label for="title">제 목</label>
							<input type="text" class="form-control" id="title" readonly disabled value="${qboard.title }" />							
						</div>
						<div class="row">	
							<div class="form-group col-sm-3" >
								<label for="writer">작성자</label>
								<input type="text" class="form-control" id="writer" readonly value="${qboard.writer }"/>
							</div>		
							
							<div class="form-group col-sm-3" >
								<label for="regDate">작성일</label>
								<input type="text" class="form-control" id="regDate" readonly 
									value="<fmt:formatDate value="${qboard.regDate }" pattern="yyyy-MM-dd" />" />
							
							</div>
							
							<div class="form-group col-sm-3" >
								<label for="status">상태</label>
								<input type="text" class="form-control" ${qboard.status eq '완료' ? 'style="color:red;font-weight:bold"':'' } id="status" readonly value="${qboard.status }" />
							
							</div>
							
							<div class="form-group col-sm-3" >
								<label for="viewcnt">조회수</label>
								<input type="text" class="form-control" id="viewcnt" readonly value="${qboard.viewcnt }"/>
							</div>
						</div>		
						<div class="form-group col-sm-12">
							<label for="content">내 용</label>
							<div id="content">${qboard.content }</div>	
						</div>
												
					</div>													
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row  -->
    </section>
    <!-- /.content -->
        
    
    <!-- Reply content -->
    <section class="content container-fluid">
    	<!-- reply component start --> 
		<div class="row">
			<div class="col-md-12">
				<div class="card card-info">					
					<div class="card-body">
						<div class="timeline">
							<!-- timeline time label -->
							<div class="time-label" id="repliesDiv">
								<span class="bg-green">댓글 목록 </span>							
							</div>
							
							
						</div>
						<br/>	
						<div class="card-footer">
							<label for="newReplyText">댓글</label>
							<textarea class="textarea" name="newReplyText" id="newReplyText" rows="20"
										placeholder="REPLY TEXT" style="display: none;"></textarea>
							<br/>
							<c:choose>
								<c:when test="${qboard.status eq '완료'}">
									<input type="text" class="form-control" readonly value="답변이 완료되어 댓글을 작성하실 수 없습니다."/>
								</c:when>
								<c:otherwise>
									<button type="button" class="btn btn-primary" id="replyAddBtn" style="display: none;" onclick="replyRegist_go();">작성</button>
									<button type="button" class="btn btn-primary" id="replywriterBtn" onclick="writerReply();" >댓글창</button>
								</c:otherwise>
							</c:choose>
						</div>
						<!-- The time line -->
						<div class='text-center'>
							<ul id="pagination" class="pagination justify-content-center m-0" >
								
							</ul>
						</div>
					</div>
							
				</div>			
				
			</div><!-- end col-md-12 -->
		</div><!-- end row -->
    </section>
  </div>
  <!-- /.content-wrapper -->

<!-- Modal -->
<div id="modifyModal" class="modal modal-default fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" style="display:none;"></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>        
      </div>
      <div class="modal-body" data-rno>
        <label for="newReplyText">댓글 수정</label>
        <textarea class="textarea" name="replytext" id="replytext" rows="20"
									placeholder="REPLY TEXT" style="display: none;"></textarea>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" id="replyModBtn" onclick="replyModify_go();">수정</button>
        <button type="button" class="btn btn-danger" id="replyDelBtn" onclick="replyRemove_go();">삭제</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="summernote_off();">닫기</button>
      </div>
    </div>
  </div>
</div>



<form role="form">
	<input type="hidden" name="qno" value="${qboard.qno }" />
</form>

<script>
var writerBtn = true;

function writerReply(){
	if(writerBtn){
		$('#replyAddBtn').css("display","inline");
		summernote_go($('#newReplyText'),'<%=request.getContextPath()%>');
		writerBtn = false;
	} else {
		$('#replyAddBtn').css("display","none");
		$('#newReplyText').summernote("reset");
		$('#newReplyText').summernote("destroy");
		$('#newReplyText').css("display","none");
		writerBtn = true;
	}
	 
}

function modify_go(){
	var formObj = $("form[role='form']");
	formObj.attr({
		'action':'modifyForm.do',
		'method':'post'
	});
	formObj.submit();
}
function remove_go(){
	var formObj = $("form[role='form']");
	var answer = confirm("정말 삭제하시겠습니까?");
	if(answer){		
		formObj.attr("action", "remove.do");
		formObj.attr("method", "post");
		formObj.submit();
	}
}

</script>

 <%@ include file="./qreply_js.jsp" %>
</body> 
 
 
 
 
 
 
 
 
 
 