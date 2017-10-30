package com.xdf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/redirectUser")
public class UserRedirectController {

 /*   @RequestMapping("/redirectUser/add")
    public void add(HttpServletRequest request, HttpServletResponse response){
        System.out.println("进入了=====》addUser");
        try {
            // 之前的转发
            request.getRequestDispatcher("/WEB-INF/jsp/addUser.jsp").forward(request,response);
          //在返回值中如果出现forward:  则不会执行视图解析器
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    @RequestMapping("/add")
    public String add(){
        System.out.println("进入了=====》add");
      /* return "addUser";  默认转发  执行视图解析器*/
      /* return "redirect:addUser"; 重定向*/
          return "forward:/WEB-INF/jsp/addUser.jsp";  //转发
    }

    //真正的新增
    @RequestMapping("/addUser")
    public String addUser(User user){
        System.out.println("进入了=====》addUser");
        System.out.println("用户名："+user.getName());
        System.out.println("年龄："+user.getAge());
     /*   return "forward:userList";  转发到当前controller中方法*/
    /*    return "redirect:userList";  重定向到当前controller中方法 */
    return  "forward:/pet/list";
    }



    @RequestMapping("/userList")
    public String list(User  user){
        System.out.println("进入了=====》list");
        System.out.println("用户名："+user.getName());
        System.out.println("年龄："+user.getAge());
        return "forward:/WEB-INF/jsp/success.jsp";
    }
}
