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