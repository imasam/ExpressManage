<%@ page import="java.util.List" %>
<%@ page import="dao.entities.RouteInfo" %>
<%@ page import="dao.Dao" %>
<%@ page import="dao.entities.ExpressInfo" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/5/18
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>物流信息</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%
    String expressNo = request.getParameter("expressNo");
    ArrayList<RouteInfo> rInfo = Dao.instance().queryExpress(expressNo);
%>
<table align="center">
    <caption>单号：<%=expressNo%></caption>
    <tr>
        <th>时间</th>
        <th>物流信息</th>
    </tr>
    <%
        for(int i = 0; i < rInfo.size(); i++) {
            RouteInfo ri = rInfo.get(i);
    %>
    <tr>
        <td><%=ri.getTime().toString().substring(0,19)%></td>
        <td><%=ri.getInfo()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
