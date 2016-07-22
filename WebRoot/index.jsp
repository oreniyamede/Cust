<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>

<html>
  <head>
  </head>
  <body>
  	<h1>客户管理系统</h1><hr>
  	<a href="${pageContext.request.contextPath }/addCust.jsp">添加客户</a><br>          
  	<a href="${pageContext.request.contextPath }/servlet/ListCustServlet">客户列表</a>  <font color="red">this 功能  already 失效，Please to using 分页查询客户，the 功能 already 合并</font><br>
  	<a href="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage=1">分页查询客户</a><br>
  	
  </body>
</html>
