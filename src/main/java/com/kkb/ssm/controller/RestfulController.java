package com.kkb.ssm.controller;

import com.kkb.ssm.po.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主要用来演示SpringMVC对RESTful的支持
 */
@RequestMapping("rest")
@RestController
public class RestfulController {
    // springmvc通过路径模板变量{变量名}这种方式，对URL带有参数的情况进行支持
    @RequestMapping("user/{id}/{name}/{sex}")
    public User findUser(@PathVariable Integer id, @PathVariable String name, @PathVariable String sex){
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        user.setSex(sex);
        return user;
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public User saveUser(User user){
        return user;
    }
}
