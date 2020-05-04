<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>主页</title>
  </head>
  <body>
    <h1><font color="red">欢迎</font></h1>
    <s:a href="save.jsp">保存客户</s:a><br/>
    <s:a href="CustomerAction_list.action">客户列表</s:a>
  </body>
</html>