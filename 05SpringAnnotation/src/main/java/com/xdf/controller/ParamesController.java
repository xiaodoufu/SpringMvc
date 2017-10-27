package com.xdf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamesController {
    /**
     * 详细注释请看 readMe.txt
     */
    @RequestMapping(method = RequestMethod.POST,value = {"add","adduser","haha"},params = {"userName","password"})
    public  String addUser(HttpServletRequest request){
        System.out.println("进入了 addUser");
        System.out.println("用户名==》"+request.getParameter("userName"));
        System.out.println("密码==》"+request.getParameter("password"));
        return "success";
    }
}
