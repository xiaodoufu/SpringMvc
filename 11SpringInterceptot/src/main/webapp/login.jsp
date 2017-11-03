<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 小豆腐
  Date: 2017/11/3
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <form action="login"  method="post">
      用户名： <input type="text" name="userName"/>
        <button type="submit">提交</button>
  </form>

</body>
</html>
