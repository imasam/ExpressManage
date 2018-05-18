<%@ page import="dao.entities.ExpressInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.Dao" %>
<%@ page import="com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/5/18
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已收快递</title>
</head>
<body>
<%
    String courierAccount = request.getParameter("account");
    List<ExpressInfo> expresses = Dao.instance().getCourierExpresses(courierAccount);
%>
<div align="center">
    <%
        for(int i = 0;i < expresses.size();i++){
            ExpressInfo express = (ExpressInfo) expresses.get(i);
    %>
    <form>
        收件人姓名：<p><textarea name="title"style="BORDER-BOTTOM: 0px solid;
                BORDER-LEFT: 0px solid;
                BORDER-RIGHT: 0px solid;
                BORDER-TOP: 0px solid;
                vertical-align:middle;" readonly="readonly">
        <%=express.getToName()%></textarea></p>
        收件人电话：<p><textarea name="category" style="BORDER-BOTTOM: 0px solid;
                 BORDER-LEFT: 0px solid;
                  BORDER-RIGHT: 0px solid;
                  BORDER-TOP: 0px solid;
                  vertical-align:middle;" readonly="readonly" >
        <%=express.getToTel()%></textarea></p>
        收件人地址：<p><textarea name="content" style="BORDER-BOTTOM: 0px solid;
                BORDER-LEFT: 0px solid;
                BORDER-RIGHT: 0px solid;
                BORDER-TOP: 0px solid;
                vertical-align:middle;"readonly="readonly" >
        <%=express.getToArea()%></textarea></p>
        <hr>
    </form>
    <%
        }
    %>
    <a href="index.jsp">点击跳转操作选择页面</a>
</div>
</body>
</html>
