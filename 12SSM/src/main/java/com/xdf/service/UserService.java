package com.xdf.service;

import com.xdf.bean.User;

public interface UserService {
    /**
     * 登录
     */
    User login(String name, String pwd);
}
