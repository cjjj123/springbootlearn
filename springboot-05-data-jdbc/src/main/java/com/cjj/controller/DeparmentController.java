package com.cjj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class DeparmentController {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/query")
    public String query(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from department");
        //Map<String, Object> map = maps.get(0);
        return maps.toString();
    }

}
