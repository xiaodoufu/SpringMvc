package com.xdf.controller;

import com.xdf.controller.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/add")
    public ModelAndView  addUser(@Validated User user,BindingResult result){
        System.out.println(result.getAllErrors().size());
        System.out.println(result.hasErrors());
          ModelAndView mv=new ModelAndView();
        if (result.hasErrors()){  //出现了验证错误
             if (result.getFieldError("age")!=null){
                 mv.addObject("ageError",result.getFieldError("age").getDefaultMessage());
             }
             if (result.getFieldError("phone")!=null){
                 mv.addObject("phoneError",result.getFieldError("phone").getDefaultMessage());
             }
             if (result.getFieldError("name")!=null){
                 mv.addObject("nameError",result.getFieldError("name").getDefaultMessage());
             }
            mv.setViewName("/index.jsp");
             return   mv;
        }
        mv.setViewName("/success.jsp");

        return  mv;
    }


}
