<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"   isELIgnored="false" %>
<html>
  <head>
  </head>
  <body style="text-align: center;">
    <h1>客户管理系统_添加客户</h1><hr>
  	<form action="${pageContext.request.contextPath }/servlet/AddCustServlet" method="POST">
  		<table border="1">
  			<tr>
  				<td>客户姓名：</td>
  				<td><input type="text" name="name" /></td>
  			</tr>
  			<tr>
  				<td>客户性别：</td>
  				<td>
  					<input type="radio" name="gender" value="男"/>男
  					<input type="radio" name="gender" value="女">女
  				</td>
  			</tr>
  			<tr>
  				<td>出生日期：</td>
  				<td><input type="text" name="birthday" /></td>
  			</tr>
  			<tr>
  				<td>手机号码：</td>
  				<td><input type="text" name="cellphone"></td>
  			</tr>
  			<tr>
  				<td>电子邮箱：</td>
  				<td><input type="text" name="email"></td>
  			</tr>
  			<tr>
  				<td>客户爱好：：</td>
  				<td>
  					<input type="checkbox" name="preference" value="天空" />天空
  					<input type="checkbox" name="preference" value="星夜" />星夜
  					<input type="checkbox" name="preference" value="夏天" />夏天
  					<input type="checkbox" name="preference" value="晴天" />晴天
  					<input type="checkbox" name="preference" value="童话" />童话
  					<input type="checkbox" name="preference" value="动漫" />动漫	
  				</td>
  			</tr>
  				<tr>
  				<td>客户类型：</td>
  				<td>
  					<select name="type">
  						<option value="钻石客户">钻石客户</option>
  						<option  value="白金客户">白金客户</option>
  						<option  value="黄金客户">黄金客户</option>
  						<option  value="白银客户">白银客户</option>
  						<option  value="青铜客户">青铜客户</option>
  						<option  value="黑铁客户">黑铁客户</option>
  						<option  value="屌丝客户">屌丝客户</option>
  					</select>
  				</td>
  			</tr>
  			<tr>
  				<td>描述信息：</td>
  				<td><textarea name="description" rows="6" cols="40"></textarea></td>
  			</tr>
  			<tr>
  				<td colspan="10">
  					<input type="submit" value="添加客户" />
  				</td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>
