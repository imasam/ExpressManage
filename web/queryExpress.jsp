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
    <title>查询快件</title>
</head>
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
