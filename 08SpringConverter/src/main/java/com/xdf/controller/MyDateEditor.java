package com.xdf.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.beans.PropertyEditor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class MyDateEditor extends PropertiesEditor {

    @Override
    public void setAsText(String source) throws IllegalArgumentException {
        //根据用户传递过来的source来创建对应的日期格式
        SimpleDateFormat sdf=getSimpleDateFormat(source);
        Date date=null;
        try {
            date=sdf.parse(source);
            setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据用户传递过来的source来创建对应的日期格式
     */
    private SimpleDateFormat getSimpleDateFormat(String source) {
        SimpleDateFormat sdf=null;
        if (Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$",source)){
            sdf=new SimpleDateFormat("yyyy/MM/dd");
        }else if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$",source)){
            sdf=new SimpleDateFormat("yyyy-MM-dd");
        }else if (Pattern.matches("^\\d{4}\\d{2}\\d{2}$",source)){
            sdf=new SimpleDateFormat("yyyyMMdd");
        }else {
            throw  new TypeMismatchException("",Date.class);
        }
        return  sdf;
    }
}
