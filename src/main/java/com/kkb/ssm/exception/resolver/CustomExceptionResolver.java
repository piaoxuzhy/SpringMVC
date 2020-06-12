package com.kkb.ssm.exception.resolver;

import com.kkb.ssm.exception.CustomException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        CustomException customException = null;
        if(e instanceof CustomException){
            customException = (CustomException) e;
        }else{
            customException = new CustomException("未知错误");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",customException.getMsg());
        modelAndView.setViewName("error");
        return null;
    }
}
