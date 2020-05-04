<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改客户信息</title>
</head>
<body>
     <s:form action="CustomerAction_update" method="post" >
		<h4><s:text name="修改客户信息"></s:text></h4>
		<s:actionerror/>
		<s:textfield  name="customer.cust_id" value ="%{#customer.cust_id}" label="cust_id" readonly="true"></s:textfield>
		<s:textfield  name="customer.cust_name" value ="%{#customer.cust_name}" label="cust_name"></s:textfield>
		<s:textfield  name="customer.cust_source" value ="%{#customer.cust_source}" label="cust_source"></s:textfield>
		<s:textfield  name="customer.cust_industry" value ="%{#customer.cust_industry}" label="cust_industry"></s:textfield>
		<s:textfield  name="customer.cust_level" value ="%{#customer.cust_level}" label="cust_level"></s:textfield>
		<s:textfield  name="customer.cust_phone" value ="%{#customer.cust_phone}" label="cust_phone"></s:textfield>
		<s:textfield  name="customer.cust_mobile" value ="%{#customer.cust_mobile}"  label="cust_mobile"></s:textfield>
		<s:submit value="提交"/>
	</s:form>
</body>
</html>