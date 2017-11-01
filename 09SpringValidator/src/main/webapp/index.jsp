<%--
  Created by IntelliJ IDEA.
  User: 小豆腐
  Date: 2017/11/1
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="user/add" method="post">
    用户名： <input name="name">${nameError} <br/>
    年龄： <input  name="age">${ageError}<br/>
    电话： <input  name="phone">${phoneError}<br/>
    <input type="submit" value="注册">
</form>
</body>
</html>
