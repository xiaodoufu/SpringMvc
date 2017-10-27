package com.xdf.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 可以同时处理N个请求
 */
public class UserController extends MultiActionController{

      /**
       * 新增
       */
      public ModelAndView  addUser(HttpServletRequest request, HttpServletResponse response){
            System.out.println("进入了 addUser");
            return  new ModelAndView("add","result","新增页面");
      }
      /**
       * 删除
       */
      public ModelAndView delUser(HttpServletRequest request, HttpServletResponse response){
            System.out.println("进入了 delUser");
            return  new ModelAndView("del","result","删除页面");
      }
      /**
       * 修改
       */
      public ModelAndView  updateUser(HttpServletRequest request, HttpServletResponse response){
            System.out.println("进入了 updateUser");
            return  new ModelAndView("update","result","修改页面");
      }
      /**
       * 查询
       */
      public ModelAndView  findUser(HttpServletRequest request, HttpServletResponse response){
            System.out.println("进入了 findUser");
            return  new ModelAndView("select","result","查询页面");
      }

}
