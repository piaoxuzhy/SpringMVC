package com.kkb.ssm.controller.advice;

import com.kkb.ssm.exception.CustomException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyControllerAdvice {
    //应用到所有@RequestMapping注解方法，在其执行之前把返回值放入ModelMap中
    @ModelAttribute
    public Map<String, Object> before(){
        Map<String, Object> map = new HashMap<>();
        map.put("msg","MyControllerAdvice...before");
        return map;
    }

    // 应用到所有【带参数】的@RequestMapping注解方法，在其执行之前初始化数据绑定器
    //可以替代配置文件中的conversionService配置
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 给数据绑定器注册一个新的属性编辑器(第一个参数是目标类型，第二个参数是自定义编辑器)
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        System.out.println("......initBinder......");
    }

    // 应用到所有@RequestMapping注解的方法，在其抛出指定异常时执行
    @ExceptionHandler(value = IOException.class)
    @ResponseBody
    public String handleException(Exception e){
        // 异常处理思路
        // 自定义预期异常
        CustomException customException = null;
        // 如果抛出的是系统自定义的异常
        if(e instanceof  CustomException){
            customException = (CustomException) e;
        }else{
            e = new CustomException("未知错误");
        }
        return customException.getMsg();
    }
}
