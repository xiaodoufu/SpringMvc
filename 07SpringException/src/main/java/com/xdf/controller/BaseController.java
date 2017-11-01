package com.xdf.controller;

import com.xdf.controller.pexception.AgeException;
import com.xdf.controller.pexception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 一个所有Controller中公共方法或者属性的公共类
 */

@Controller
public class BaseController {

    /**
     * 只要是继承了BaseController的类中出现了NameException异常
     * 就会进入此方法进行处理
     */
    @ExceptionHandler(NameException.class)
    public ModelAndView  nameException(NameException ex){
        ModelAndView  mv=new ModelAndView("/errors/nameException.jsp");
        mv.addObject("ex",ex);
        return  mv;
    }
    @ExceptionHandler(AgeException.class)
    public ModelAndView  nameException(AgeException ex){
        ModelAndView  mv=new ModelAndView("/errors/ageException.jsp");
        mv.addObject("ex",ex);
        return  mv;
    }

    /**
     * 除了上面的name和age异常之外的其他异常进入此方法
     */
    @ExceptionHandler
    public ModelAndView  defaultException(Exception ex){
        ModelAndView  mv=new ModelAndView("/errors/defaultError.jsp");
        mv.addObject("ex",ex);
        return  mv;
    }


}
