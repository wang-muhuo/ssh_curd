<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
<form action="<%=basePath %>CustomerAction_login.action" method="post">
    	<table>
    		<tr>
    			<td>用户名</td>
    			<td><input type="text" name="vo.username"></td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td><input type="password" name="vo.password"></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="登陆"></td>
    		</tr>
    	</table>
    </form>
</body>
</html>