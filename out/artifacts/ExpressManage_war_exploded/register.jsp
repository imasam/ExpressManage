<%@ page import="dao.Dao" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/5/18
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<div align="center">
    <form action="register.action" method="post">
        <p>
            *用户类型
            <input type="radio" name="loginType" value="user" id="user" checked="checked">
            <label for="user">普通用户</label>
            <input type="radio"  name="loginType" value="courier" id="courier">
            <label for="courier">快递员</label><br>
        </p>
        <p>*账号：<input type="text" name="account"><br></p>
        <p>*密码：<input type="password" name="password"><br></p>

        <section id="courier-info">
            <p>姓名（*快递员必填）：<input name="name" type="text"></p>
            <p>地区（*快递员必填）：
                <select id="province">
                    <option value="">省份</option>
                </select>
                <select id="city" name="city">
                    <option value="">城市</option>
                </select>
            </p>
            <p>手机（*快递员必填）：<input name="tel" type="tel"></p>
        </section>
        <p><input type="submit" value="注册"></p>
    </form>
</div>
</body>

<script type="text/javascript">
    document.getElementById("user").onclick = function () {
        document.getElementById("courier-info").style.display = "none";
    }
    document.getElementById("courier").onclick = function () {
        document.getElementById("courier-info").style.display = "block";
    }
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
            document.getElementById("province").options.add(new Option(p, p));
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
    document.getElementById("province").onchange = function (ev) {
        var i = document.getElementById("province").options.selectedIndex;
        var province = document.getElementById("province").options.item(i).value;
        setCities(province);
    }
    /*
     * 设置城市列表
     */
    function setCities(province) {
        document.getElementById("city").options.length = 1;
        var c = cities[province];
        for (var i = 0; i < c.length; i++) {
            var p = c[i];
            document.getElementById("city").options.add(new Option(p, p));
        }
    }
</script>
</html>
