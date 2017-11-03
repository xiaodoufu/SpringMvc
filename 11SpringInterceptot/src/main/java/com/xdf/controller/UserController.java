package com.xdf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/main")
    public ModelAndView main(){
        System.out.println("进入了 main !");
        ModelAndView mv=new ModelAndView("/success.jsp");
        mv.addObject("welcome","恭喜您登录成功！");
        return  mv;
    }
}
