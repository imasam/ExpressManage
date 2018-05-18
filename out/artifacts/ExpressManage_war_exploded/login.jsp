<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/5/15
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>登录</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div align="center">
    <form action="login.action" method="post">
        <p>
        <input type="radio" name="loginType" value="user" id="user" checked="checked">
        <label for="user">普通用户</label>
        <input type="radio"  name="loginType" value="courier" id="courier">
        <label for="courier">快递员</label><br>
        </p>
        <p>账号：<input type="text" name="account"><br></p>
        <p>密码：<input type="password" name="password"><br></p>
        <p><input type="submit" value="登录"></p>
        <a href="register.jsp" style="font-size: x-small">点此注册</a>
    </form>
</div>
</body>
</html>
