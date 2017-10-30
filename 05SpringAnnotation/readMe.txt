使用注册配置springmvc！


@Controller 写在对应的Controller声明处！
标识 这个类是一个Controller！

@RequestMapping("/user/add"):可以定义在方法或者类上
标识 用户的请求地址

如果定义在类上，则表示 类中所有的@RequestMapping的路径前面
必须加上类上的定义！

如果@RequestMapping中只有一个参数，这个参数就是value,可以省略属性名！


请求中携带参数！
还是使用我们之前request.getParameter(name)！

问题？
01.前台传递的参数和后台接收的参数名称不匹配
02.在后台必须获取某些字段
03.多个请求进入后台的同一个方法
04.乱码

@RequestMapping中的其中一个属性
  params = {"userName","password"}：请求中必须携带这两个参数
  params = {"!userName"}：请求中必须不能携带这个参数
  params = {"userName=admin"}：请求中携带这个参数的值必须是admin

先满足value确定需要执行的方法
再看params的规则，如果不匹配儿规则也是不会执行方法的！

method = RequestMethod.GET
请求的方式必须是get才能进入方法
多个请求进入后台的同一个方法
value={"路径1",路径2",路径3"}
value本身就是一个数组


解决乱码问题？

 get乱码： 在服务器中的server.xml文件中 URIEncoding=UTF-8
 post乱码： 使用Filter

 springmvc!  Filter不用我们自己书写！

Filter需要配置在web.xml文件中


前端接收后台的参数

01.通过request.getParameter(name)
    name就是前端的name属性值
02.在后台的方法参数中加上name属性值
03.在前台传递一个对象

如果前台的name属性值和后台参数不一致？？？
使用@RequestParame("前端的name属性值")

之前我们的url都是这样的。。。。
user/delete?id=1

现在是把参数放在了路径中
user/delete/1
user/1/delete
只需要在后台定义这个路径规则！
然后前台在传递值的时候会默认匹配我们书写的规则！



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















