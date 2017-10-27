<%--
  Created by IntelliJ IDEA.
  User: 小豆腐
  Date: 2017/10/27
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>

<%--01.传递参数  后台接收使用对应的name属性--%>
<form action="student/add" method="post">
   用户名： <input name="name">
   年龄： <input  name="age">
     <input type="submit" value="注册">
</form>



<%--02.传递对象参数  后台接收使用对应的对象的属性名--%>
<form action="student/addStudent" method="post">
    用户名： <input name="name">
    年龄： <input  name="age">
    <%--teacher就是student类中的域属性--%>
    老师姓名： <input  name="teacher.name">
    老师年龄： <input  name="teacher.age">
    <input type="submit" value="注册">
</form>

<%--03.路径变量--%>

<%--<a href="student/delete/?id=1">删除id=1</a>--%>
<a href="student/1/haha/delete">删除id=1</a>

</body>
</html>
