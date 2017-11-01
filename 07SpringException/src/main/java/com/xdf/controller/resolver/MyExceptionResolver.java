package com.xdf.controller.resolver;

import com.xdf.controller.pexception.AgeException;
import com.xdf.controller.pexception.NameException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的异常处理器
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    /**
     * @param request  请求
     * @param response  响应
     * @param handler  异常发生的controller
     * @param ex       发生的异常类型
     * @return   视图和数据
     */
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
          ModelAndView mv=new ModelAndView("/errors/defaultError.jsp");//默认的异常视图
          mv.addObject("ex",ex); //异常信息
        if (ex instanceof NameException){
            mv.setViewName("/errors/nameException.jsp");
        }
        if (ex instanceof AgeException){
            mv.setViewName("/errors/ageException.jsp");
        }
        return mv;
    }
}
