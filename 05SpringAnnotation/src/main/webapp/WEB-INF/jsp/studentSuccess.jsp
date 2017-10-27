<%--
  Created by IntelliJ IDEA.
  User: 小豆腐
  Date: 2017/10/27
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>studentSuccess</title>
</head>
<body>
   学生姓名：${userName}
   学生年龄： ${age}  <br/>
<hr/>


   学生姓名：${student.name}
   学生年龄： ${student.age}  <br/>
   teacher姓名：${student.teacher.name}
   teacher年龄： ${student.teacher.age}  <br/>

</body>
</html>
