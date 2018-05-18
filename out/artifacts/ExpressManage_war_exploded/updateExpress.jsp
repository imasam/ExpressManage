<%@ page import="dao.entities.ExpressInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.Dao" %>
<%@ page import="com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader" %>
<%@ page import="java.sql.Timestamp" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/5/18
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>更新物流</title>
</head>
<%
    String loginType = (String)session.getAttribute("loginType");
    if(loginType == null){
        out.print("<script>alert('请先登录！'); window.location='./login.jsp';</script>");
        return;
    }
    else if(!loginType.equals("courier"))
        out.print("<script>alert('您没有该权限！点击”确认“返回主页');" +
                " window.location='./index.jsp';</script>");
%>
<body>
<%@ include file="header.jsp" %>
<form action="updateExpress.action" method="post">
    <div>
        <p>快递单号：<input name="expressNo" type="text"></p>
        <p>更新时间：
            <input name="time" type="datetime-local" value="<%=
            new Timestamp(System.currentTimeMillis()).toString()%>">
        </p>
        <p>物流信息：<textarea name="info"></textarea></p>
        <p><input type="submit" value="更新信息"></p>
    </div>
</form>
</body>
</html>
