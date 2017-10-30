异常处理机制：
 用户在前端输入错误数据之后，我们在后台怎么处理？

实现方式：
01. 在核心配置文件中增加
bean==》SimpleMappingExceptionResolver
里面需要注意点：
   001.默认的异常属性值是exception 如果想更改找exceptionAttribute
   002.设置默认的异常处理界面  defaultErrorView
   003.自定义的异常处理页面  exceptionMappings

02.自定义异常处理器
 前提 实现===》HandlerExceptionResolver
 重写 resolveException方法

03.使用注解
   实现思路：
      001.每个controller都书写各种异常！！！ 可行吗？ 代码冗余吗？
      002.把所有公共的异常处理部分提取成一个公共类 让其他controller去继承！
      疑问？
      唯一继承的机会给异常！！！
       如果真的要继承！那么这个公共类（BaseController）不只是异常处理了！！






