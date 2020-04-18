package com.cjj.controller;


import com.cjj.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理
 */
@ControllerAdvice
public class MyExceptionHandler {



    /*@ResponseBody
    @ExceptionHandler(MyException.class)
    public Map<String ,Object> handlerException(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("code", "2998");
        map.put("msg", e.getMessage());
        return map;
    }*/


    @ExceptionHandler(MyException.class)
    public String handlerException(Exception e,HttpServletRequest httpServletRequest){
        Map<String, Object> map = new HashMap<>();
        httpServletRequest.setAttribute("javax.servlet.error.status_code", 520);
        map.put("code", "3019");
        map.put("message", "二度异常");
        httpServletRequest.setAttribute("ext", map);
        return "forward:/error";
    }
}
