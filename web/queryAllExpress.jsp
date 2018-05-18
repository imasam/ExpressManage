<%@ page import="java.util.List" %>
<%@ page import="dao.entities.ExpressInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.Dao" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/5/18
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 权限检查
    ArrayList<ExpressInfo> infos = null;
    String loginType = (String)session.getAttribute("loginType");
    String account = (String)session.getAttribute("account");
    if(account == null) {
        out.print("<script>alert('请先登录！'); window.location='./login.jsp';</script>");
        return;
    }
    if(loginType.equals("user"))
        infos = Dao.instance().getUserExpresses(account);
    else if(loginType.equals("courier"))
        infos = Dao.instance().getCourierExpresses(account);
%>
<html>
<head>
    <title>所有快递订单</title>
</head>
<body>
<%@include file="header.jsp" %>
<table>
    <caption>最近100条订单</caption>
    <tr>
        <th>ID</th>
        <th>时间</th>
        <th>单号</th>
        <th>寄件人账号</th>
        <th>快递员账号</th>
        <th></th>
        <th>寄件人姓名</th>
        <th>寄件人电话</th>
        <th>寄件人地址</th>
        <th></th>
        <th>收件人姓名</th>
        <th>收件人电话</th>
        <th>收件人地址</th>
    </tr>
    <%
        for(int i=0; i<infos.size(); i++) {
            ExpressInfo ei = infos.get(i);
    %>
    <tr>
        <td><%=i+1%></td>
        <td><%="time"%></td>
        <td><%=ei.getExpressNo()%></td>
        <td><%=ei.getFromAccount()%></td>
        <td><%=ei.getCourierAccount()%></td>
        <td></td>
        <td><%=ei.getFromName()%></td>
        <td><%=ei.getFromTel()%></td>
        <td><%=ei.getFromArea()%></td>
        <td></td>
        <td><%=ei.getToName()%></td>
        <td><%=ei.getToTel()%></td>
        <td><%=ei.getToArea()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
