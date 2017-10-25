<%--
  Created by IntelliJ IDEA.
  User: 小豆腐
  Date: 2017/10/25
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%-- 01. 使用了 我们的 ParameterMethodNameResolver--%>
<a href="userController?methodName=addUser">新增</a>
  <a href="userController?methodName=delUser">删除</a>
  <a href="userController?methodName=updateUser">修改</a>
<a href="userController?methodName=findUser">查询</a> <br/>

<%-- 02. 使用了 我们的 SimpleUrlHandlerMapping--%>
<a href="user/addUser">新增</a>
  <a href="user/delUser">删除</a>
  <a href="user/updateUser">修改</a>
  <a href="user/findUser">查询</a> <br/>


<%-- 03. 使用了 我们的 PropertiesMethodNameResolver
  解决前台的url 不能匹配方法名--%>
<a href="user/add">新增</a>
<a href="user/del">删除</a>
<a href="user/update">修改</a>
<a href="user/find">查询</a>
</body>
</html>
