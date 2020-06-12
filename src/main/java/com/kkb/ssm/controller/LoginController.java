package com.kkb.ssm.controller;

import org.springframework.http.HttpCookie;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login(HttpSession session, String username, String password){
        // Service进行用户身份验证
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return "redirect:/login.jsp";
        }
        //保存到Session中
        session.setAttribute("username", username);
        return "redirect:/item/init";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        //session.removeAttribute("username");
        //清空session
        session.invalidate();
        return "redirect:/login.jsp";
    }
}
