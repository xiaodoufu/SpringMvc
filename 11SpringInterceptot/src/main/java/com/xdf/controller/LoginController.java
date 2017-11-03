package com.xdf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    /**
     * 用户的登录
     */
    @RequestMapping("/login")
    public  String login(String userName, HttpSession session){
        System.out.println("进入了  login!");
        session.setAttribute("userName",userName);
        return "forward:/user/main"; //转发到userController中的main
    }

}
