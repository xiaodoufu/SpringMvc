第一个问题： 解决  一个controller只能有一个方法的问题！！

01项目的问题？

01项目中我们写的Controller能写多个方法吗？
能！ 但是怎么让用户执行执行的方法？
也可以！ 类是与我们之前的servlet中的dopost（）
根据methodname 来执行指定的方法！


在springmvc中有一个专门的类来处理上述我们发现的问题！
 MultiActionController

 MultiActionController extends AbstractController
 AbstractController   implements Controller

 前台代码书写的参数 必须是对应controller中的方法名称
 然后在springmvc核心配置文件中配置参数 方法名称解析器

ParameterMethodNameResolver类中有如下的属性！
public static final String DEFAULT_PARAM_NAME = "action";

01.我们UserController extends  MultiActionController
02.MultiActionController中有一个属性就是方法名称解析器
private MethodNameResolver methodNameResolver = new InternalPathMethodNameResolver();
03.因为我们是根据参数匹配方法名称，所以需要更改methodNameResolver
04.ParameterMethodNameResolver implements MethodNameResolver
05.所以我们只需要设置UserController中的methodNameResolver
   让这个===ParameterMethodNameResolver



还可以使用 SimpleUrlHandlerMapping来根据用户的url匹配方法

有个疑问！前台传递来的url名称必须和方法名一致！
要是不一致呢？

前台     后台
add   ==>addUser
使用解析器来让 前台的key 对应我们的 value




















第二个问题： 解决 springmvc核心xml文件的位置问题！

01.在DispatcherServlet类中查询 contextConfigLocation属性
02.进入了FrameworkServlet中的setContextConfigLocation
03.发现ContextConfigLocation的默认值是根据我们web.xml
   文件中的servlet-name节点的值来决定的！
04.想改变位置，只需要在servlet节点中 改变ContextConfigLocation的属性
