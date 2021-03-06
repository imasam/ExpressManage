<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="dao.Dao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/5/18
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>寄件</title>
</head>
<%
    String loginType = (String)session.getAttribute("loginType");
    if(loginType == null){
        out.print("<script>alert('请先登录！'); window.location='./login.jsp';</script>");
        return;
    }
    else if(loginType.equals("courier"))
        out.print("<script>alert('您没有该权限！点击”确认“返回主页');" +
                " window.location='./index.jsp';</script>");
%>
<body>
<%@ include file="header.jsp" %>
<div align="center"  style="float:left;  width:100%; height:200px;margin-top:0px;">
    <form action="newExpress.action" method="post">
        <div style="float:left; width:50%; height:200px;">
        <p>寄件人姓名：<input type="text" name="fromName"></p>
        <p>寄件人电话：<input type="text" name="fromTel"></p>
            <p hidden>寄件人账号：<input type="text" name="fromAccount"
                value="<%=session.getAttribute("account")%>"></p>
        <p>寄件人地址：
            <select id="fromProvince">
            <option value="">省份</option>
            </select>
            <select id="fromCity" name="fromCity">
                <option value="">城市</option>
            </select>
        </p>
        <p>寄件人详细地址：<input type="text" name="fromAddr"></p>
        </div>
        <div style="width:50%;height:200px; float:right;">
        <p>收件人姓名：<input type="text" name="toName"></p>
        <p>收件人电话：<input type="text" name="toTel"></p>
        <p>收件人地址：
            <select id="toProvince">
                <option value="">省份</option>
            </select>
            <select id="toCity" name="toCity">
                <option value="">城市</option>
            </select></p>
        <p>收件人详细地址：<input type="text" name="toAddr"></p>
        </div>
        <input type="submit" value="确认寄件">
    </form>
</div>
<script type="text/javascript">
    /*
     * 获取省份列表
     */
    var provinces = "<%=Dao.instance().getProvinces().toString()%>";
    provinces = provinces.replace("[", "").replace("]", "");
    provinces = provinces.split(", ");
    setProvince();
    /*
     * 设置省份列表
     */
    function setProvince() {
        for (var i = 0; i < provinces.length; i++) {
            var p = provinces[i];
            document.getElementById("fromProvince").options.add(new Option(p, p));
            document.getElementById("toProvince").options.add(new Option(p, p));
        }
    }
    /*
     * 下面获取各省份对应的城市
     */
    var cities = new Array();
    <%
    Map<String, List<String>> cities = Dao.instance().getCities();
    for (Map.Entry<String, List<String>> entry : cities.entrySet()) { %>
    c = "<%=entry.getValue().toString()%>";
    c = c.replace("[", "").replace("]", "");
    c = c.split(", ");
    cities["<%=entry.getKey()%>"] = c;
    <% } %>
    /*
     * 省份选项改变时改变城市列表
     */
    document.getElementById("fromProvince").onchange = function (ev) {
        var i = document.getElementById("fromProvince").options.selectedIndex;
        var province = document.getElementById("fromProvince").options.item(i).value;
        setFromCities(province);
    }
    document.getElementById("toProvince").onchange = function (ev) {
        var i = document.getElementById("toProvince").options.selectedIndex;
        var province = document.getElementById("toProvince").options.item(i).value;
        setToCities(province);
    }
    /*
     * 设置城市列表
     */
    function setFromCities(province) {
        document.getElementById("fromCity").options.length = 1;
        var c = cities[province];
        for (var i = 0; i < c.length; i++) {
            var p = c[i];
            document.getElementById("fromCity").options.add(new Option(p, p));
        }
    }
    function setToCities(province) {
        document.getElementById("toCity").options.length = 1;
        var c = cities[province];
        for (var i = 0; i < c.length; i++) {
            var p = c[i];
            document.getElementById("toCity").options.add(new Option(p, p));
        }
    }
</script>
</body>
</html>
