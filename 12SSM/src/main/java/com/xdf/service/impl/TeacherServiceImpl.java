package com.xdf.service.impl;

import com.xdf.bean.Student;
import com.xdf.bean.Teacher;
import com.xdf.dao.StudentMapper;
import com.xdf.dao.TeacherMapper;
import com.xdf.dao.UserMapper;
import com.xdf.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherServiceImpl implements TeacherService {



    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private StudentMapper studentMapper;
    public void insertInto() {
         teacherMapper.addTeacher(new Teacher(11,"哈哈"));
        System.out.println(1/0);
       studentMapper.addStudent(new Student(11,20,"heihei"));
    }
}
