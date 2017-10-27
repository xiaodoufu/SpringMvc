package com.xdf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*我们这个UserController就是一个 控制器 springmvc会加载*/
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response){
        System.out.println("进入了add");
        return  new ModelAndView("success","result","新增页面");
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response){
        System.out.println("进入了update");
        return  new ModelAndView("success","result","修改页面");
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response){
        System.out.println("进入了delete");
        return  new ModelAndView("success","result","删除页面");
    }

    @RequestMapping("/find")
    public ModelAndView find(HttpServletRequest request, HttpServletResponse response){
        System.out.println("进入了find");
        return  new ModelAndView("success","result","查询页面");
    }



}
