package com.xdf.bean;

public class Student {

    private  Integer sid;
    private  Integer age;
    private  String name;

    public Student(Integer sid, Integer age, String name) {
        this.sid = sid;
        this.age = age;
        this.name = name;
    }

    public Student() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
