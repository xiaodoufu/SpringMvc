package com.xdf.controller.converter;

import org.springframework.beans.TypeMismatchException;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 自定义类型转换器
 * String : 源类型
 * Date:    目标类型
 */
public class MyDateConverter  implements Converter<String,Date>{

    /**
     * 用户传递来一个String类型的值，我们转换成Date
     * source字符串的具体类型我们确定吗？
     * 你知道是 /
     * 还是 -
     * 还是+ .......
     */
    public Date convert(String source) {
        //根据用户传递过来的source来创建对应的日期格式
        SimpleDateFormat sdf=getSimpleDateFormat(source);
        Date date=null;
        try {
            date=sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
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
