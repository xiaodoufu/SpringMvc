<%--
  Created by IntelliJ IDEA.
  User: 小豆腐
  Date: 2017/10/23
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--引入css文件--%>
    <style  type="text/css">
        @import url("statics/css/style.css");
    </style>
</head>
<body>
<%--  当用户点击hello的时候，
 01.web.xml文件中配置的核心控制器会拦截这个请求
 02.然后根据url的映射去核心配置文件中查询有没有对应的bean--%>
  <a href="hello">Hello</a>
  <img src="statics/images/cat.jpg" height="50px" width="50px"/>


<%--静态资源的访问--%>
<script type="text/javascript" src="statics/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
    $(function () {
         alert("能看到我吗？");
    })
</script>
</body>
</html>
