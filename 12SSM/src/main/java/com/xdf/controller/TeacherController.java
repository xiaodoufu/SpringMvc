package com.xdf.controller;

import com.xdf.bean.User;
import com.xdf.service.TeacherService;
import com.xdf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    @RequestMapping("/add")
    public ModelAndView add(){
        System.out.println("进入了 controller");
        teacherService.insertInto();
        return new ModelAndView("/success.jsp");
    }

}
