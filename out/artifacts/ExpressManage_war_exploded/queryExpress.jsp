<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/5/18
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>查询快件</title>
</head>
<%
    String loginType = (String)session.getAttribute("loginType");
    if(loginType == null){
        out.print("<script>alert('请先登录！'); window.location='./login.jsp';</script>");
        return;
    }
%>
<body>
<%@ include file="header.jsp" %>
<div align="center">
    <form action="queryExpress.action">
        <p>物流单号：<input name="expressNo" type="text"><br></p>
        <p><input type="submit" value="查询"></p>
    </form>
</div>
</body>
</html>
