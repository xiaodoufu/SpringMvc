视图解析器：

01.后台返回的视图只是一个逻辑视图！ success   add  update
02.需要把逻辑视图转换成物理视图   success.jsp    add.jsp  update.jsp

03.InternalResourceViewResolver 相当于把所有的视图都限制了存放位置

04.后台需要返回的页面能都放在一个文件中吗？ 不可能！   user/  order/  bill/  news/

这时候InternalResourceViewResolver解决不了？
使用其他的视图解析器！



使用视图  org.springframework.web.servlet.view.JstlView
      后台controller中返回的逻辑视图名称和 id对应
      url对应的就是物理视图

创建视图解析器
  <bean class="org.springframework.web.servlet.view.BeanNameViewResolver"/>

问题也出现了？
一个逻辑视图对应核心配置文件中的一个bean===》JstlView
如果有很多则需要书写多个bean !

怎么解决这个问题===》使用XmlViewResolver！
进入XmlViewResolver类 观看代码
/**
	 * Set the location of the XML file that defines the view beans.
	 * <p>The default is "/WEB-INF/views.xml".  默认xml文件的位置
	 * @param location the location of the XML file.
	 */
	public void setLocation(Resource location) {
		this.location = location;
	}
我们更改 只需要修改属性 location 即可


如果我们的主业务模块分为以下四个模块！
user/  order/  bill/  news/    需要4个xml文件才会便于我们的管理

xml这种方式只能设置一个！

怎么解决？使用ResourceBundleViewResolver！
我们可以设置多个properties文件！



既然有这么多视图解析器？我在xml文件中配置了多个？
那么这么多视图解析器怎么执行？

01.默认执行顺序是按照在xml文件中的书写顺序
02.如果不想按照书写顺序执行！ 每个视图解析器中增加属性order
03.order的值越小（正整数） 优先级越高！


