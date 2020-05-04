<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示客户信息</title>
</head>
<body>
	<h1>客户管理系统 </h1>
<form action="<%=basePath %>CustomerAction_list.action" method="post">
客户名称:<input type="text"   name="queryVo.custName" ><br/>
客户来源：
<select name="queryVo.custSource" >
<option value="">--请选择--</option>
<option value="6">电话营销</option>
<option value="7">网络营销</option>
</select><br/>
所属行业：
<select  name="queryVo.custIndustry">
<option value="">--请选择--</option>
<option value="1">教育培训</option>
<option value="2">电子商务</option>
<option value="3">对外贸易</option>
<option value="4">酒店旅游</option>
<option value="5">房地产</option>
</select><br/>
客户级别：
<select  name="queryVo.custLevel">
<option value="">--请选择--</option>
<option value="22">普通客户</option>
<option value="23">VIP客户</option>
</select><br/>
<button type="submit"  onclick="window.location.href='<%=basePath %>CustomerAction_list.action'">查询</button>
</form>
	<h3>客户信息</h3>
	<table border='1'>
		<tr>
			<td>ID</td><td>客户名称</td><td>客户来源</td><td>客户所属行业</td><td>客户级别</td><td>固定电话</td><td>手机</td><td>操作</td>
		</tr>
			<s:iterator value="#listAll" id="c" >
				<tr>
					<td><s:property value="#c.cust_id"/></td>
					<td><s:property value="#c.cust_name"/></td>
					<td><s:property value="#c.cust_source"/></td>
					<td><s:property value="#c.cust_industry"/></td>
					<td><s:property value="#c.cust_level"/></td>
					<td><s:property value="#c.cust_phone"/></td>
					<td><s:property value="#c.cust_mobile"/></td>
					
					<td>
						<a href="<s:url action="CustomerAction_delete"><s:param name="cust_id"><s:property value="#c.cust_id"/></s:param>
						</s:url>">删除</a>
					</td>
					<td>
						<a href="<s:url action="CustomerAction_edit"><s:param name="cust_id"><s:property value="#c.cust_id"/></s:param>
						</s:url>">修改</a>
					</td>
				</tr>
			</s:iterator>
	</table>
	<a href="main.jsp">返回主页面</a>
	<s:debug></s:debug>
</body>
</html>