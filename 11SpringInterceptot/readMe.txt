创建自定义的拦截器
01.务必实现 HandlerInterceptor!
02.我们使用的拦截器其实就是针对于Handler的拦截器===》处理器拦截器
03.核心控制器中的HandleMapping返回的就是一个
  处理器执行链 =  Handler+ Interceptors(处理器拦截器）


  HandlerInterceptor接口中的三个方法：


  01.preHandle 如果返回值是false,则不会执行后续的操作！ 一个拦截器
  02.如果有多个拦截器，则之后拦截器中的所有方法都不会执行！



 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      return false;
  }


 之后指定了对应Handler中的方法之后 才执行！
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


只要是当前拦截器中的preHandle返回true则此方法必须执行！
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }