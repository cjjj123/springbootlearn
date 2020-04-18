package com.cjj.controller;

import com.cjj.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login")
    //@PostMapping("/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map){
        logger.info(username);
        logger.info(password);
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            return "Dashboard";
        }
        map.put("msg", "登陆失败");
        return "login";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if("aaa".equals(user)){
            throw new MyException();
        }
        return "hello";

    }

}
