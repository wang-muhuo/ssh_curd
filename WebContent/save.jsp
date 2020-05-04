<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>保存客户</title>

  </head>

  <body>
    <h1><font color="red">保存客户</font></h1>
     <form action="CustomerAction_save" method="post" enctype = "multipart/form-data">
        <input type="hidden" name="method:save">
        cust_name:<input type="text" name="customer.cust_name"> <br/>
        cust_source:<input type="text" name="customer.cust_source"> <br/>
        cust_industry:<input type="text" name="customer.cust_industry"> <br/>
        cust_level:<input type="text" name="customer.cust_level"> <br/>
        cust_phone:<input type="text" name="customer.cust_phone"> <br/>
        cust_mobile:<input type="text" name="customer.cust_mobile"> <br/>
        <input type="submit" name="submit" value="提交">
     </form> <br/>
  </body>
</html>