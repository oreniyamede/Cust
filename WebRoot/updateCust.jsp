%@ page language="java" import="java.util.*" pageEncoding="UTF-8"   isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
  <head>
  </head>
  <body style="text-align: center;">
    <h1>客户管理系统_修改客户</h1><hr>
  	<form action="${pageContext.request.contextPath }/servlet/UpdateCustServlet?thispage=${requestScope.thispage}" method="POST">
  		<input type="hidden" name="id" value="${cust.id }">
  		<table border="1">
  			<tr>
  				<td>客户姓名：</td>
  				<td><input type="text" name="name" value="${cust.name }" readonly="readonly" style="background:gray;"/></td>
  			</tr>
  			<tr>
  				<td>客户性别：</td>
  				<td>
  					<input type="radio" name="gender" value="男" 
  					<c:if test="${cust.gender =='男' }">checked='checked'</c:if>
  					/>男
  					
  					<input type="radio" name="gender" value="女" 
  					<c:if test="${cust.gender =='女' }">checked='checked'</c:if>
  					/>女
  				</td>
  			</tr>
  			<tr>
  				<td>出生日期：</td>
  				<td><input type="text" name="birthday" value="${cust.birthday }"/></td>
  			</tr>
  			<tr>
  				<td>手机号码：</td>
  				<td><input type="text" name="cellphone" value="${cust.cellphone }"></td>
  			</tr>
  			<tr>
  				<td>电子邮箱：</td>
  				<td><input type="text" name="email" value="${cust.email }"></td>
  			</tr>
  			<tr>
  				<td>客户爱好：：</td>
  				<td>
  				
  					<input type="checkbox" name="preference" value="天空" 
  					<c:forTokens items="${cust.preference }" delims="," var="pref">
  						<c:if test="${pref == '天空' }">
  							checked='checked'
  						</c:if>
  					</c:forTokens>
  					/>天空
  					<input type="checkbox" name="preference" value="星夜" 
  					 	<c:if test="${fn:contains(cust.preference,'星夜') }">
  					 		checked='checked'
  					 	</c:if>
  					/>星夜
  					<input type="checkbox" name="preference" value="夏天" 
  						<c:if test="${fn:contains(cust.preference,'夏天') }">
  					 		checked='checked'
  					 	</c:if>
  					/>夏天
  					<input type="checkbox" name="preference" value="晴天" 
  						<c:if test="${fn:contains(cust.preference,'晴天') }">
  					 		checked='checked'
  					 	</c:if>
  					/>晴天
  					<input type="checkbox" name="preference" value="童话" 
  						<c:if test="${fn:contains(cust.preference,'童话') }">
  					 		checked='checked'
  					 	</c:if>
  					/>童话
  					<input type="checkbox" name="preference" value="动漫" 
  						<c:if test="${fn:contains(cust.preference,'动漫') }">
  					 		checked='checked'
  					 	</c:if>
  					/>动漫	
  				</td>
  			</tr>
  				<tr>
  				<td>客户类型：</td>
  				<td>
  					<select name="type">
  						<option value="钻石客户"
  							<c:if test="${cust.type=='钻石客户' }">
  					 			selected='selected'
  					 		</c:if>
  						>钻石客户</option>
  						<option  value="白金客户"
  							<c:if test="${cust.type=='白金客户' }">
  					 			selected='selected'
  					 		</c:if>
  						>白金客户</option>
  						<option  value="黄金客户"
  							<c:if test="${cust.type=='黄金客户' }">
  					 			selected='selected'
  					 		</c:if>
  						>黄金客户</option>
  						<option  value="白银客户"
  							<c:if test="${cust.type=='白银客户' }">
  					 			selected='selected'
  					 		</c:if>
  						>白银客户</option>
  						<option  value="青铜客户"
  							<c:if test="${cust.type=='青铜客户' }">
  					 			selected='selected'
  					 		</c:if>
  						>青铜客户</option>
  						<option  value="黑铁客户
  							<c:if test="${cust.type=='黑铁客户' }">
  					 			selected='selected'
  					 		</c:if>
  						">黑铁客户</option>
  						<option  value="屌丝客户"
  							<c:if test="${cust.type=='屌丝客户' }">
  					 			selected='selected'
  					 		</c:if>
  						>屌丝客户</option>
  					</select>
  				</td>
  			</tr>
  			<tr>
  				<td>描述信息：</td>
  				<td><textarea name="description" rows="6" cols="40" >${cust.description }</textarea></td>
  			</tr>
  			<tr>
  				<td colspan="10">
  					<input type="submit" value="修改客户" />
  				</td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>
