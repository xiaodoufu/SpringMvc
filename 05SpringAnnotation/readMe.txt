使用注册配置springmvc！


@Controller 写在对应的Controller声明处！
标识 这个类是一个Controller！

@RequestMapping("/user/add"):可以定义在方法或者类上
标识 用户的请求地址

如果定义在类上，则表示 类中所有的@RequestMapping的路径前面
必须加上类上的定义！

如果@RequestMapping中只有一个参数，这个参数就是value,可以省略属性名！
