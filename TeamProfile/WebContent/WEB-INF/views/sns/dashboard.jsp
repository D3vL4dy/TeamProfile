<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>

	<style type="text/css">
		iframe{
			border:none;
			overflow: hidden;
		}
	</style>
</head>
	<section class="content-header" style="padding-bottom:0;">
		  	<div class="container-fluid">
		  		<div class="row md-2">
		  			<div class="col-sm-6">
		  				<h1>SNS</h1>  				
		  			</div>
		  			<div class="col-sm-6">
		  				<ol class="breadcrumb float-sm-right" style="color:white;">
				        <li class="breadcrumb-item">
				        	<a href="list.do">
					        	<i class="fa fa-dashboard"></i>SNS
					        </a>
				        </li>
				        <li class="breadcrumb-item active">
				        	HOME
				        </li>		        
		    	  </ol>
		  			</div>
		  		</div>
		  	</div>
	</section>
	<hr>
	 
	 <!-- Main content -->
    <section class="content">		
		<div class="row">
			<div class="col-lg-6">
				<iframe src="dashboardPdsList.do?page=1" style="width:100%;height:50vh;"></iframe>
			</div>
			<div class="col-lg-6">
				<iframe src="dashboardQBoardList.do?page=1" style="width:100%;height:50vh;"></iframe>
			</div>
			
		</div>
		<div class="row">
			<div class="col-lg-6">
				<iframe src="dashboardWorkBoardList.do?page=1" style="width:100%;height:50vh;"></iframe>
			</div>
			<div class="col-lg-6">
				<iframe src="dashboardFreeBoardList.do?page=1" style="width:100%;height:50vh;"></iframe>
			</div>
			
		</div>
		
    </section>
