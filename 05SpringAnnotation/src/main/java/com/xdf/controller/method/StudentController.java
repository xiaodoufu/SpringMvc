package com.xdf.controller.method;

import com.xdf.controller.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

    /**
     *
     * 疑问？
     * 01.参数能不能从请求中获取
     * 02.前端的输入都是String类型，但是我们参数是int  age （类型转换器）
     *
     *
     * 解决的问题：
     * 01.Springmvc会根据我们的请求参数 去 后台方法参数中进行匹配
     * 02.名称不一致 怎么办？    校正参数
     *@RequestParam("name") String userName
     * @RequestParam  必须放在对应的参数之前！
     */
    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("name") String userName, int age){
        System.out.println("用户名===》"+userName);
        System.out.println("年龄===》"+age);
        ModelAndView  mv=new ModelAndView("studentSuccess");  //逻辑视图名称
        //需要返回给前端的数据
        mv.addObject("userName",userName).addObject("age",age);
        return   mv;
    }


    /**
     * 前端传递的是一个对象
     */
    @RequestMapping("/addStudent")
    public ModelAndView addStudent(Student student){
        System.out.println("用户名===》"+student.getName());
        System.out.println("年龄===》"+student.getAge());
        System.out.println("老师用户名===》"+student.getTeacher().getName());
        System.out.println("老师年龄===》"+student.getTeacher().getAge());
        ModelAndView  mv=new ModelAndView("studentSuccess");  //逻辑视图名称
        //需要返回给前端的数据
        mv.addObject("student",student);
        return   mv;
    }

    /**
     * 路径变量
     */
    @RequestMapping("/{id}/{name}/delete")
    public void deleteStudent(@PathVariable int id,@PathVariable String name){
        System.out.println(name);
        System.out.println(id);
    }

}
