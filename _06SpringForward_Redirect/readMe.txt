
springmvc的转发和重定向 注意事项：
01. 转发是服务器的行为
    重定向是客户端的行为

02.转发URL不会发生变化
  重定向URL会发生变化

03.转发数据不丢失
  重定向数据丢失

04.在返回值中如果出现forward:或者redirect  则不会执行视图解析器

05.如果想从一个方法中跳转到本controller中的一个方法或者另一个controller中 都可以是使用转发或者重定向


06.无论是转发还是重定向
    后台  不加/  默认以访问路径为准
           加/   以服务器根路径为准localhost:8080/


比如：
   01. 请求   localhost:8080/add.jsp
   02. add.jsp中有超链接
    <a href="user/add">跳转</a>
   03.点击跳转 请求变成 localhost:8080/user/add
   04.localhost:8080/user/add到达的controller中有可能还有
     转发或者重定向
   05.依据的路径就是  localhost:8080/user/+转发或者重定向的路径















