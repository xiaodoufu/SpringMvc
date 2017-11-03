<%--
  Created by IntelliJ IDEA.
  User: 小豆腐
  Date: 2017/11/3
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <form action="user/add" method="post" enctype="multipart/form-data">
     <%-- <input type="file" name="file">  单文件上传--%>
      <input type="file" name="files">
      <input type="file" name="files">
      <input type="file" name="files">
      <button type="submit">文件上传</button>
  </form>


</body>
</html>
