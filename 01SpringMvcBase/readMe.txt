springMVC:

 一：创建第一个项目
    01.引入需要的jar包
        web  webmvc  context  context-support
    02.在web.xml文件中 配置我们需要的核心控制器  DispatcherServlet
      <servlet>
	   <servlet-name>springmvc</servlet-name>
	   <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	  </servlet>

	  注意点：
	    <servlet-name>springmvc</servlet-name>
	    那么我们springmvc的核心配置文件名称 必须是  springmvc-servlet.xml
	    因为底层明确了文件的名称是  <servlet-name>-servlet.xml
	   这个文件的位置 现阶段 只能在web-inf 下面

	 03.在web-inf文件下创建需要的核心配置文件   springmvc-servlet.xml
	    头部信息增加
	    xmlns:mvc="http://www.springframework.org/schema/mvc"

	     http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc.xsd
	 04.书写一个controller(其实就是我们的servlet) 继承 AbastractController


二：第一个项目的整体流程

01.用户在index.jsp页面中点击Hello超链接
02.点击之后请求路径是  /hello   <a href="hello">Hello</a>
03.会被我们web.xml文件中配置的DispatcherServlet拦截
04.默认执行doDispatch()
      HandlerExecutionChain mappedHandler = null;  处理器执行链
      mappedHandler = this.getHandler(processedRequest); 根据用户的请求获取处理器执行链
        4.1.跟进getHandler（）看到了
            for (HandlerMapping hm : this.handlerMappings)
            handlerMappings是一个List<HandlerMapping>

            HandlerExecutionChain handler = hm.getHandler(request);
            hm是List<HandlerMapping>是集合中的一个元素===》HandlerMapping
            根据用户的请求在处理器映射器中查询Handler
        4.2.跟进getHandler（）看到了
            Object handler = getHandlerInternal(request); 获取需要执行的Handler

            HandlerExecutionChain executionChain = getHandlerExecutionChain(handler, request);

        4.3.跟进getHandlerExecutionChain
          发现方法中有处理器拦截器
          for (HandlerInterceptor interceptor : this.adaptedInterceptors)

   所以mappedHandler（处理器执行链）中包含一个即将执行的handler和一些列的interceptor（拦截器）

05.HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());
   获取处理器适配器
   跟进 getHandlerAdapter（）
   for (HandlerAdapter ha : this.handlerAdapters)
   handlerAdapters是一个List<HandlerAdapter>
   ha就是List<HandlerAdapter>其中一个元素 就是HandlerAdapter

          if (ha.supports(handler)) {
				return ha;
			}
   5.1：跟进supports
      进入了HandlerAdapter====》是一个接口！
      接口有5个实现类！默认执行3个！

      在webmvc的jar包中的根目录下找到DispatcherServlet.properties

       默认的处理器映射器的配置
        org.springframework.web.servlet.HandlerMapping=org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping,\
      	org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping

        默认的处理器适配器的配置
        org.springframework.web.servlet.HandlerAdapter
        =org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter,\
        org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter,\
        org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter
   5.2：回到doDispatch（）
     mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
     跟进handle（）发现 HandlerAdapter====》是一个接口的handle（）有5个实现
     首先进入HttpRequestHandlerAdapter,我们的HelloController和HttpRequestHandler没关系，继续执行下一个Adapter
     进入SimpleControllerHandlerAdapter，我们的HelloController继承了AbstractController，
     AbstractController实现了Controller！ 产生了关系！

   5.3:跟进SimpleControllerHandlerAdapter类中的handler（）

     	return ((Controller) handler).handleRequest(request, response);
        只有转换成Controller才有handleRequest这个方法！
        关键是我们的HelloController中的方法名称是handleRequestInternal（）

        001.只有转换成Controller才有handleRequest这个方法！
        002.AbstractController重写了Controller的handleRequest
        003.但是返回的是一个handleRequestInternal（）
        004.我们的HelloController中的方法名称是handleRequestInternal（）
        005.所以执行Controller的handleRequest就是执行HelloController中的handleRequestInternal（）


三：配置视图解析器
    为什么？
    01.我们controller中肯定会返回很多页面
    02.页面的前缀/WEB-INF  ==>安全
    03.后缀都是以.jsp结尾

    我们现在统一把所有的前缀和后缀写在一个地方！
    只要是后台有返回页面，我会自动的给页面加前缀和后缀！
    这时候就需要我们配置视图解析器


    有疑问？
    通关观察dispatcherServlet.properties文件我们看到了有默认的试图解析器
    就是InternalResourceViewResolver！
    那为什么我们还需要设置？
    因为我们需要对InternalResourceViewResolver视图解析器中的属性赋值！

   InternalResourceViewResolver的父类中 UrlBasedViewResolver的属性没有值

        private String prefix = "";
    	private String suffix = "";


四:静态资源的访问
   问题的引入：

  01.我们在web.xml文件中配置核心控制器的url-pattern是什么？  是  /
  02./  不能匹配 .jsp  .js .css  .png....后缀路径
  03.如果我们项目中需要这些文件，是不能使用的！

  所以需要设置允许静态资源的访问！

   解决方式3种

   01.去tomcat服务器中找到conf/web.xml中有如下配置
       <servlet-mapping>
           <servlet-name>default</servlet-name>
           <url-pattern>/</url-pattern>   不会匹配静态文件
       </servlet-mapping>

    在web.xml文件中配置
    <servlet-mapping>
      <servlet-name>default</servlet-name>
      <url-pattern>*.jpg</url-pattern>
    </servlet-mapping>

    问题？
    如果我们的图片后缀比较多！那么我们的web.xml文件中的节点是不是很多！


   02.在springmvc核心配置文件中配置   推荐使用
       注释掉web.xml文件中的配置

   03.在springmvc核心配置文件中配置
     <mvc:default-servlet-handler/>