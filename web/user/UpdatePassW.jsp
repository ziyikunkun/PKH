<%--
  Created by IntelliJ IDEA.
  User: PKH
  Date: 2018/8/14
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>密码修改</title>
</head>
<body>
<form method="post" action="/UpdatePassW">
    用户名：<input type="text" name="userName">
    <br>
    旧密码：<input type="password" name="oldPass">
    <br>
    新密码：<input type="password" name="newPass">
    <br>
    确认新密码：<input type="password" name="surePass">
    <br>
    验证码：<input type="password" name="code">
    <img src="/CodeServlet" alt="" onclick="javascript:this.src='/CodeServlet'+new Date().getTime()">
    <br>
    <input type="submit">
</form>
</body>
</html>
