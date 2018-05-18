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
    <title>快递信息</title>
</head>
<body>
<%
    String expressNo = request.getParameter("expressNo");
    RouteInfo express = Dao.instance().queryExpress(expressNo);

    System.out.println(express.getExpressNo());
%>
<form>
    快递单号：<p><textarea name="title"style="BORDER-BOTTOM: 0px solid;
                BORDER-LEFT: 0px solid;
                BORDER-RIGHT: 0px solid;
                BORDER-TOP: 0px solid;
                vertical-align:middle;" readonly="readonly"><%=express.getExpressNo()%></textarea></p>
    物流信息：<p><textarea name="category" style="BORDER-BOTTOM: 0px solid;
                 BORDER-LEFT: 0px solid;
                  BORDER-RIGHT: 0px solid;
                  BORDER-TOP: 0px solid;
                  vertical-align:middle;" readonly="readonly" ><%=express.getInfo()%></textarea></p>
    时间：<p><textarea name="content" style="BORDER-BOTTOM: 0px solid;
                BORDER-LEFT: 0px solid;
                BORDER-RIGHT: 0px solid;
                BORDER-TOP: 0px solid;
                vertical-align:middle;"readonly="readonly" ><%=express.getTime()%></textarea></p>
</form>
</body>
</html>
