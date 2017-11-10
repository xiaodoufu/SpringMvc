package com.xdf.service.impl;

import com.xdf.bean.User;
import com.xdf.dao.UserMapper;
import com.xdf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userDao;

    public User login(String name, String pwd) {
        return userDao.login(name,pwd);
    }
}
