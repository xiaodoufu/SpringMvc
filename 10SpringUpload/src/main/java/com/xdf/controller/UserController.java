package com.xdf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * 文件上传名称的规范：
 * 系统毫秒数+随机数+文件名称
 *  防止文件覆盖
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**单文件上传
    @RequestMapping("/add")
    public String uploadFile(MultipartFile file, HttpSession session){
       String path= session.getServletContext().getRealPath("/files");
       String fileName=file.getOriginalFilename();
        try {
            file.transferTo(new File(path,fileName)); //真正的文件上传
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/success.jsp";

        //String type=file.getContentType();
        // String paramName=file.getName();
        // System.out.println("文件的名称===》"+fileName);
        // System.out.println("表单中的name属性值===》"+paramName);
        // System.out.println("文件的类型===》"+type);
    }
 */



    @RequestMapping("/add")
    public String uploadFile(@RequestParam MultipartFile [] files, HttpSession session){
        String path= session.getServletContext().getRealPath("/files");
         for (MultipartFile file:files){
           String fileName=  file.getOriginalFilename();
             try {
                 file.transferTo(new File(path,fileName));
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }

        return "/success.jsp";
    }
}
