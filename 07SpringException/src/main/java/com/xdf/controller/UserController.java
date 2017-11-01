package com.xdf.controller;

import com.xdf.controller.bean.User;
import com.xdf.controller.pexception.AgeException;
import com.xdf.controller.pexception.NameException;
import com.xdf.controller.pexception.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController extends   BaseController {

    @RequestMapping("/add")
    public String addUser(User user) throws  UserException{
        System.out.println("进入了===》Add");
        if (!"admin".equals(user.getName())){
            throw  new NameException("用户名错误");
        }
        if (0>user.getAge()){
            throw  new AgeException("年龄错误");
        }
        System.out.println(5/0);  //模拟默认异常
         return "forward:userMain";
    }
    @RequestMapping("/userMain")
    public ModelAndView  userMain(User user){
        System.out.println("进入了====》userMain");
        ModelAndView mv=new ModelAndView("success");
        mv.addObject("user",user);
        return mv;
    }
}
