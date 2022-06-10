<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
 <!-- summernote -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.css">
</head>


<title>취업정보 수정페이지</title>

<body>
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
			        <li class="breadcrumb-item active">수정</li>		        
			      </ol>
		      	</div>
	     	</div>	     	
      	</div>
    </section>

   <!-- Main content -->
    <section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline card-primary">
					<div class="card-header">
							<h3>취업정보 수정</h3>
							<div class ="card-tools">
								<button type="button" class="btn btn-warning" id="modifyBtn" onclick="modify_submit();">수 정</button>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<button type="button" class="btn" id="cancelBtn" onclick="history.go(-1);">취 소</button>	
							</div>
						</div>
					</div><!--end card-header  -->
					<div class="card-body">
						<form enctype="multipart/form-data" role="form" method="post" action="modify.do" name="modifyForm">
							<input type="hidden" name="wno" value="${workBoard.wno }" />
							<label for="end">공고마감일</label> 
							<div class="col-sm-12 row" id="end">
								<select  class="form-control col-sm-4" name="selectEnd" id="selectEnd" onchange="change_go();">
									<option value="n" ${workBoard.endDate==null ? 'selected':'' } >마감일 없음</option>
									<option value="y" ${workBoard.endDate!=null ? 'selected':'' } >마감일 있음</option>
								</select >
								<div class="form-group col-sm-8">
									<input type="date" id="endDate" name="endDate" class="form-control" value="${endStr}" ${workBoard.endDate==null ? 'disabled':'' }  >
								</div>
							</div>							
							<div class="form-group">
								<label for="writer">작성자</label> 
								<input type="text" id="writer" readonly
									name="writer" class="form-control" value="${workBoard.writer }">
							</div>
							<div class="form-group">
								<label for="title">제 목</label> 
								<input type="text" id="title" value="${workBoard.title }"
									name='title' class="form-control" placeholder="제목을 쓰세요">
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea id="content" name="content">${workBoard.content }</textarea>
							</div>
							
							<div class="form-group">								
								<div class="card card-outline card-success">
									<div class="card-header">
										<h3 style="display:inline;line-height:40px;">첨부파일 : </h3>
										&nbsp;&nbsp;
										<button class="btn btn-primary"	onclick="addFile_go()" type="button" id="addFileBtn">Add File</button>
									</div>									
									<div class="card-footer fileInput">
										<ul class="mailbox-attachments d-flex align-items-stretch clearfix">
											
											<c:forEach items="${workBoard.workFileList }" var="workFile" >
											<li class="attach-item thumb${workFile.w_ano }" file-name="${workFile.fileName }" target-ano="${workFile.w_ano }">																			
												<div class="mailbox-attachment-info ">
													<a class="mailbox-attachment-name" name="attachedFile" attach-fileName="${workFile.fileName }" attach-no="${workFile.w_ano }" href="<%=request.getContextPath()%>/workBoard/getFile.do?w_ano=${workFile.w_ano }"  >													
														<i class="fas fa-paperclip"></i>
														${workFile.fileName }&nbsp;&nbsp;
														<button type="button" onclick="removeFile_go('thumb${workFile.w_ano}');return false;" style="border:0;outline:0;" 
																class="badge bg-red">X</button>																									
													</a>													
												</div>
											</li>	
											</c:forEach>
										</ul>
										<br/>														
									</div>
								</div>
							</div>
							
						
						</form>
					</div><!--end card-body  -->
					<div class="card-footer">

					</div><!--end card-footer  -->
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row -->
    </section>
    <!-- /.content -->
    
<script>
	window.onload=function(){
		summernote_go($('#content'),'<%=request.getContextPath()%>');
	}	
</script>    
<script>
function removeFile_go(className){
	//alert('X btn');
	var li = $('li.'+className);
	
	if(!confirm(li.attr("file-name")+"을 정말 삭제하시겠습니까?")){
		return;
	}
	
	li.remove();
	
	var input=$('<input>').attr({"type":"hidden",
		"name":"deleteFile",
		"value":li.attr("target-ano")
		});
	$('form[role="form"]').prepend(input);
}

var dataNum = 0;
function addFile_go(){
	//alert("add file btn");
	
	var attachedFile = $('a[name="attachedFile"]').length; //기존파일 개수
	var inputFile = $('input[name="uploadFile"]').length; //추가된 파일 개수
	var attachCount = attachedFile + inputFile;
	
	if(attachCount >= 5){
		alert("파일 추가는 5개까지만 가능합니다.");
		return;
	}
	
	var div=$('<div>').addClass("inputRow").attr("data-no",dataNum);
	var input=$('<input>').attr({"type":"file","name":"uploadFile"}).css("display","inline");
	div.append(input).append("<button onclick='remove_go("+dataNum+");' style='border:0;outline:0;' class='badge bg-red' type='button'>X</button>");
	
	$('.fileInput').append(div);
	
	dataNum++;
}

function modify_submit(){
// 	alert("modify btn");
	var form = $('form[name="modifyForm"]');
	
	//유효성 체크
	if($("input[name='title']").val()==""){
		alert(input.name+"은 필수입니다.");
		$("input[name='title']").focus();
		return;
	}
	
	//파일 첨부 확인
	var files = $('input[name="uploadFile"]');
	for(var file of files){
		console.log(file.name+" : "+file.value);
		if(file.value==""){
			alert("파일을 선택하세요.");
			file.focus();
			return false;
		}
	}
	
	form.submit();
}

function change_go() {
	var endCheck = $("#selectEnd").val();
	if(endCheck == 'y'){
		$('#endDate').attr("disabled", false);
	} else {
		$('#endDate').attr("disabled", true);
		$('#endDate').val("");
	}
}

</script>
    
</body>