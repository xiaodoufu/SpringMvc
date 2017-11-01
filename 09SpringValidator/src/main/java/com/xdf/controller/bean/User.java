package com.xdf.controller.bean;


import javax.validation.constraints.*;

public class User {

    @NotNull(message="年龄不能为空")
    @Min(value =0,message = "年龄不能低于{value}")
    @Max(value =180,message = "年龄不能超过{value}")
    private  int age;
    @NotNull(message="电话号码不能为空")
    @Pattern(regexp = "^1[34578]\\d{9}$",message = "手机格式不匹配")
    private  String  phone;
    @Size(min = 6,max = 10,message = "长度必须在{min}和{max}之前")
    private  String  name;

    public User() {
    }

    public User(int age, String phone, String name) {

        this.age = age;
        this.phone = phone;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
