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
    <title>物流服务</title>
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
    if(Dao.instance().login(loginType,account,password)){
        headerContent=  "<label>欢迎，" + account + "</label>"
                +"(<a href = 'login.jsp'>注销</a>)";
    }
    else{
      headerContent=  "<a href = 'login.jsp'>登录</a>"
              +"|<a href = 'register.jsp'>注册</a>";
    }


    for(Cookie cookie:cookies){
        System.out.println(cookie.getName()+":"+cookie.getValue());
      System.out.println("=======================");
    }

    System.out.println(Dao.instance().login(loginType,account,password));
    System.out.println("type="+loginType+"\n"+"account="+account+"\n"+"pwd="+password);
  %>
  <body>
  <div id = "headerDiv" align="right">
    <%=headerContent%>
    <br><br>
  </div>
  <div id = "chooseDiv" align="center">
    <a href="newExpress.jsp">我要寄件</a><br>
    <a href="queryExpress.jsp">物流查询</a><br>
    <a href="userExpressHistory.jsp">寄件记录</a><br>
    <a href="courierExpressistory.jsp">收件查询</a><br>
  </div>
  </body>
</html>
