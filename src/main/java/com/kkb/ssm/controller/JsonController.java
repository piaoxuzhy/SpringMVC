package com.kkb.ssm.controller;

import com.kkb.ssm.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;

@RequestMapping("json")
@Controller
public class JsonController {

    //produces = {"text/plain;charset=UTF-8"}解决返回值是？？？？的问题
    //@RequestMapping中的consumes 和 produces 分别设置消息请求头和响应头的contentType
    @RequestMapping(value = "responseString",produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String responseString(){
        // 如果在使用@ResponseBody注解的前提下，如果返回值是String类型，则返回值会由StringHttpMessageConverter进行处理
        return "查询成功";
    }

    @RequestMapping(value = "responsePojo", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User responsePojo(){
        // 如果在使用@ResponseBody注解的前提下，如果返回值是POJO类型，则返回值会由MappingJacksonHttpMessageConverter（需要第三方jar包支持）进行处理
        User user = new User();
        user.setId(1);
        user.setUsername("haiya");
        user.setSex("女");
        return user;
    }
}
