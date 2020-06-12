package com.kkb.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("item")
@Controller
public class RequestMappingController {
    //使用场景：查询页面的查询条件是一个下拉菜单，里面的数据需要初始化
    @ModelAttribute("itemMap")
    public Map<String, Object> before(){
        Map<String, Object> map = new HashMap<>();
        map.put("1","面包");
        map.put("2","奶茶");
        System.out.println(map);
        return map;
    }

    @RequestMapping("init")
    public String init(){
        return "item";
    }
    // 演示RequestMapping注解method属性的作用,method=GET (默认)
    // 将URL[findItem]和RequestMappingInfo对象（@RequestMapping）进行映射（存储到Map中）
    // 将RequestMappingInfo对象和HandlerMethod对象，进行映射（存储到Map中）
    @RequestMapping("findItem")
    public String findItem(Model model){
        System.out.println("findItem method");
        model.addAttribute("msg","RequestMappingController...findItem方法被执行了");
        return "success";
    }

    // 演示RequestMapping注解method属性的作用，method=POST
    @RequestMapping(value = "findItem", method = RequestMethod.POST)
    public String findItem2(Model model){
        System.out.println("findItem2 method");
        model.addAttribute("msg","RequestMappingController...findItem2方法被执行了");
        return "success";
    }
    //使用String作为返回值，如果没有@ResponseBody标签，则返回一个逻辑视图名
    @RequestMapping(value = "findItem", method = RequestMethod.GET)
    public String findItem3(Model model){
        System.out.println("findItem3 method");
        model.addAttribute("msg","RequestMappingController...findItem3方法被执行了");
        return "success";
    }


    @RequestMapping(value = "removeItem", params = {"name","price>5000"})
    public String removeItem(Model model){
        System.out.println("removeItem method");
        model.addAttribute("msg","RequestMappingController...removeItem方法被执行了");
        return "success";
    }
}
