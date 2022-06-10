<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>




<aside class="main-sidebar sidebar-dark-primary elevation-4" style="background:#3C5087; color:white;">
    <!-- Brand Logo -->
    <div style="display: flex; justify-content: center;">
	    <a href="index.jsp" class="brand-link" style="font-size:32px; font-weight:bold;">
	      <span class="brand-text font-weight-light">☆ POJO ★</span>
	    </a>
    </div>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
<%--         <div class="image">
          <img src="<%=request.getContextPath() %>/member/getPicture.do?id=${loginUser.id}" class="img-circle elevation-2" alt="User Image">
        </div> --%>
        <div class="info">
            <a href="tel:${loginUser.name }">name : ${loginUser.name } </a><br/>
            <a href="mailto:${loginUser.email }">email : ${loginUser.email }</a>
             <div class="row">
                <%-- <a href="javascript:OpenWindow('<%=request.getContextPath() %>/member/detail.do?id=${loginUser.id}', '내정보', '700', '800');" class="d-block" >${loginUser.name}</a>&nbsp;&nbsp;
                --%> <button onclick="location.href='<%=request.getContextPath() %>/common/logout.do';" class="btn btn-xs btn-danger col-xs-3 " type="button" style="margin-top: 10px;">LOGOUT</button>
            	
            </div>
        </div>
      </div>

      
      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column subMenuList" data-widget="treeview" role="menu" data-accordion="false">
        
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>