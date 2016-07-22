<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"   isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  	<script type="text/javascript">
  		function changePage(obj){
  			if(isNaN(obj.value)){
  				alert("必须是数字！");
  				obj.value=${page.thispage}
  				return;
  			}else if(obj.value<=0 || obj.value>${page.countpage}){
  					alert("页码必须在有效范围内");
  						obj.value=${page.thispage}
  						return;
  			}else{
  				window.location="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage="+obj.value;
  			}
  				
  		}
  	
  		
  	</script>
  	
  	<script type="text/javascript">
  		var obj = document.getElementById('myform');
  		function go(){
  			obj.submit();
  			obj.setAttribute(name,${param.name} );
  			obj.setAttribute(gender,${param.gender} );
  			obj.setAttribute(type,${param.type} );
  		}
  	</script>
  	
  	  	<script type="text/javascript">
  		function checkAll(allC){
  			//alert(allC.checked);
  			var otherCs = document.getElementsByName("delId");
  			for(var i=0; i<otherCs.length; i++){
  				otherCs[i].checked = allC.checked;
  			}
  		}
  	</script>
  
  </head>
  <body style="text-align:center;">
	<h1>分页查询客户信息</h1><hr>
		<form  action="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage=1" method="POST" >
		客户姓名：<input type="text" name="name" value="${sessionScope.cust.name }"/>
		客户性别：<input type="radio" name="gender" value="男" 
  					<c:if test="${sessionScope.cust.gender =='男' }">checked='checked'</c:if>
  					/>男
  					
  					<input type="radio" name="gender" value="女" 
  					<c:if test="${sessionScope.cust.gender =='女' }">checked='checked'</c:if>
  					/>女
  					
  					<input type="radio" name="gender" value="" 
  					<c:if test="${sessionScope.cust.gender =='' }">checked='checked'</c:if>
  					/>无
			   
		客户类型：
			<select name="type">
						<option value=""
  							<c:if test="${sessionScope.cust.type=='' }">
  					 			selected='selected'
  					 		</c:if>
  						></option>
  						<option value="钻石客户"
  							<c:if test="${sessionScope.cust.type=='钻石客户' }">
  					 			selected='selected'
  					 		</c:if>
  						>钻石客户</option>
  						<option  value="白金客户"
  							<c:if test="${sessionScope.cust.type=='白金客户' }">
  					 			selected='selected'
  					 		</c:if>
  						>白金客户</option>
  						<option  value="黄金客户"
  							<c:if test="${sessionScope.cust.type=='黄金客户' }">
  					 			selected='selected'
  					 		</c:if>
  						>黄金客户</option>
  						<option  value="白银客户"
  							<c:if test="${sessionScope.cust.type=='白银客户' }">
  					 			selected='selected'
  					 		</c:if>
  						>白银客户</option>
  						<option  value="青铜客户"
  							<c:if test="${sessionScope.cust.type=='青铜客户' }">
  					 			selected='selected'
  					 		</c:if>
  						>青铜客户</option>
  						<option  value="黑铁客户
  							<c:if test="${sessionScope.cust.type=='黑铁客户' }">
  					 			selected='selected'
  					 		</c:if>
  						">黑铁客户</option>
  						<option  value="屌丝客户"
  							<c:if test="${sessionScope.cust.type=='屌丝客户' }">
  					 			selected='selected'
  					 		</c:if>
  						>屌丝客户</option>
  					</select>
		<input type="submit" value="条件查询客户" />
	</form>	
	<form action="${pageContext.request.contextPath }/servlet/BatchDelServlet?thispage=${param.thispage}" method="POST">
	<table border="1" width="100%">
		<tr>
			<th><input type="checkbox" onclick="checkAll(this)"/>全选</th>
			<th>客户姓名</th>
			<th>客户性别</th>
			<th>生日日期</th>
			<th>手机号码</th>
			<th>电子邮箱</th>
			<th>客户爱好</th>
			<th>客户类型</th>
			<th>描述信息</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${requestScope.page.list }" var="cust">
			<tr>
				<td><input type="checkbox" name="delId" value="${cust.id }"/></td>
				<td><c:out value="${cust.name }"/></td>
				<td><c:out value="${cust.gender }"/></td>
				<td><c:out value="${cust.birthday }"/></td>
				<td><c:out value="${cust.cellphone }"/></td>
				<td><c:out value="${cust.email }"/></td>
				<td><c:out value="${cust.preference }"/></td>
				<td><c:out value="${cust.type }"/></td>
				<td><c:out value="${cust.description }"/></td>
				<td><a href="${pageContext.request.contextPath }/servlet/CustInfoServlet?id=${cust.id}&thispage=${page.thispage}">修改</a></td>
				<td><a href="${pageContext.request.contextPath }/servlet/DelCustServlet?id=${cust.id}&thispage=${page.thispage }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="批量删除"/>
	</form>
	共${page.selectcountpage }条记录
	共${page.countpage }页
	<a href="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage=${page.firstpage }">首页</a>
	<a href="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage=${page.prepage }">上一页</a>
	<!-- 分页逻辑开始 -->

	<c:if test="${page.countpage<=5 }">
		<c:set var="begin" value="1" scope="page"></c:set>
		<c:set var="end" value="${page.countpage }" scope="page"></c:set>
	</c:if>
	
	<c:if test="${page.countpage>5 }">
		<c:choose>
			<c:when test="${page.thispage<=3 }">
				<c:set var="begin" value="1" scope="page"></c:set>
				<c:set var="end" value="5" scope="page"></c:set>
			</c:when>
			<c:when test="${page.thispage>=page.countpage-2 }">
				<c:set var="begin" value="${page.countpage-4 }" scope="page"></c:set>
				<c:set var="end" value="${page.countpage }" scope="page"></c:set>
			</c:when>
			<c:otherwise>
				<c:set var="begin" value="${page.thispage-2 }" scope="page"></c:set>
				<c:set var="end" value="${page.thispage+2 }" scope="page"></c:set>
			</c:otherwise>
		</c:choose>
	</c:if>
	
	<c:forEach begin="${begin }" end="${end }" step="1" var="i"> 
		<c:if test="${i == page.thispage }">
			${i }
		</c:if>
		<c:if test="${i != page.thispage }">
				<a href="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage=${i }" >${i }</a>
		</c:if>
	
	</c:forEach>

	<!-- 分页逻辑结束 -->
	<a href="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage=${page.nextpage }">下一页</a>
	<a href="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage=${page.lastpage }">尾页</a>
	跳到<input type="text" value="${page.thispage }" size="1xp" onchange="changePage(this)"/>页
  </body>
</html>
