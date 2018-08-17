<%--
  Created by IntelliJ IDEA.
  User: PKH
  Date: 2018/8/15
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <script src="/static/js/jquery-3.2.0.min.js"></script>
</head>
<body>
<%--<form action="/register" method="post">--%>
    <%--电话：<input type="text" name="phone" value="${requestScope.phone}" >--%>
    <%--<br>--%>
    <%--<br>--%>
    <%--身份证：<input type="text" name="Idcard" value="${requestScope.Idcard}" disabled>--%>
    <%--<br><br>--%>
    <%--登录名：<input type="text" name="uname" value="${requestScope.uname}" disabled>--%>
    <%--<br><br>--%>
    <%--密码：<input type="text" name="password" value="${requestScope.password}" disabled>--%>
    <%--<br><br>--%>
    <%--&lt;%&ndash;<input type="submit">&ndash;%&gt;--%>
<%--</form>--%>

    电话：<input type="text" name="phone" id="phone" value="${requestScope.phone}" >
    <br>
    <br>
    身份证：<input type="text" name="Idcard" id="Idcard" value="${requestScope.Idcard}" disabled>
    <br><br>
    登录名：<input type="text" name="uname" id="uname" value="${requestScope.uname}" disabled>
    <br><br>
    密码：<input type="text" name="password" id="password" value="${requestScope.password}" disabled>
    <br><br>
    <input type="submit">


</body>
</html>
