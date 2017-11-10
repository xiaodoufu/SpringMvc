package com.xdf.controller;


import com.xdf.bean.User;
import com.xdf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService  userService;

    @RequestMapping("/login")
    public ModelAndView login(String userName, String password){
     User user= userService.login(userName,password);
        System.out.println(user);
        return new ModelAndView("/success.jsp");
    }

}
