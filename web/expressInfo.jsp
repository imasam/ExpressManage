<%@ page import="java.util.List" %>
<%@ page import="dao.entities.RouteInfo" %>
<%@ page import="dao.Dao" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/5/18
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>物流信息</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%
    String expressNo = request.getParameter("expressNo");
    RouteInfo express = Dao.instance().queryExpress(expressNo);

    System.out.println(express.getExpressNo());
%>
<table>
    <caption>单号：<%=expressNo%></caption>
    <tr>
        <th>ID</th>
        <th>时间</th>
        <th>物流信息</th>
    </tr>
    <%
        for(int i=0; i<infos.size(); i++) {
            RouteInfo ei = infos.get(i);
    %>
    <tr>
        <td><%=i+1%></td>
        <td><%=ei.getRouteInfoPK().getTime().toString().substring(0,19)%></td>
        <td><%=ei.getInfo()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
