package com.xdf.dao;

import com.xdf.bean.User;


public interface UserMapper {

    /**
     * 登录
     */
    User login(String name, String pwd);
}
