<%@ page import="dao.Dao" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/5/15
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>主页</title>
  </head>
  <%
    String loginType = "",account = "",password = "";
    Cookie[] cookies = request.getCookies();
    if(cookies != null){
        for(Cookie cookie:cookies){
            if(cookie == null) break;

            switch (cookie.getName()){
              case "loginType":loginType = cookie.getValue();break;
              case "account":account = cookie.getValue();break;
              case "password":password = cookie.getValue();break;
            }
        }
    }

    String headerContent;
    if(Dao.instance().login(loginType,account,password)) {
      session.setAttribute("loginType", loginType);
      session.setAttribute("account", account);
    }

    // session中存在账号则登录
    account = (String)session.getAttribute("account");
    if(account != null){
        headerContent=  "<label>欢迎，" + account + "</label>"
                +"(<a href = 'login.jsp'>注销</a>)";
    }
    else{
      headerContent=  "<a href = 'login.jsp'>登录</a>"
              +"|<a href = 'register.jsp'>注册</a>";
    }
  %>
  <body>
  <div id = "headerDiv" align="right">
    <%=headerContent%>
    <br><br>
  </div>
  <div id = "chooseDiv" align="center">
    <a href="newExpress.jsp">我要寄件</a><br>
    <a href="queryExpress.jsp">物流查询</a><br>
    <a href="queryAllExpress.jsp">物流记录</a><br>
    <a href="updateExpress.jsp">更新物流</a><br>
  </div>
  </body>
</html>
