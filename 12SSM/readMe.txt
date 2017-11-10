ssm整合步骤
1.引入需要的jar
2.创建ssm需要的各种配置文件
   01.spring  02.mybatis 03.springmvc
3.配置 web.xml
4.书写dao层  接口
5.书写mapper
6.书写service层
7.书写controller



ssm中常用的注解以及作用


dao
daoImpl    @Repository   持久化层的组件注解
                         写在dao的实现类中，因为我们mybatis是mapper.xml

service
serviceImpl  @Service   业务层的组件注解
     调用dao层的时候  有两种常用方式
      01. @Resource  写在属性或者set()方法上
                     默认是按照属性名称进行自动装配
      02.@Autowired  写在属性或者set()方法上
                     默认是按照属性类型进行自动装配
         如果想按照名称使用 @Qualifier("userDao")

controller  @Controller
      调用service层的时候  有两种常用方式
           01. @Resource  写在属性或者set()方法上
                          默认是按照属性名称进行自动装配
           02.@Autowired  写在属性或者set()方法上
                          默认是按照属性类型进行自动装配
              如果想按照名称使用 @Qualifier("userService")


@RequestMapping("/user")  匹配用户的请求url

@RequestParam("userName") 校正参数

@PathVariable  解析路径变量

@Transaction  事务

@AspectJ  定义切面

@Before  之前
@AfterReturning  后置增强
@After    最终
@AfterThrowing  异常








