package com.xdf.controller;

import com.sun.xml.internal.ws.spi.db.DatabindingException;
import com.xdf.controller.bean.User;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/add")
     public  void addUser(User user){
        System.out.println("2");
        System.out.println(user.getAge()+1);
        System.out.println(user.getBirthday());
     }

     /*初始化参数绑定  仅限于当前controller中使用
     * 本类中所有的方法执行之前 执行！
     * */
     @InitBinder
    public   void  initBinder(WebDataBinder binder){
         System.out.println("1");
         binder.registerCustomEditor(Date.class,new MyDateEditor());
     }

}
