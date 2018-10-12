package com.xuzw.controller;

import com.xuzw.dao.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/jsp")
public class alipayJspController {

    @Autowired
    private TestMapper testMapper;

    @RequestMapping("/index")
    public String test(){
        return "index";
    }

    @RequestMapping("/testMapper")
    public String testMapper(){
        Map<String, Object> map = testMapper.testSelect();
        System.out.println("================"+map);
        return map.toString();
    }

    @RequestMapping("/wappay/pay")
    public String pay(HttpServletRequest request) {
        System.out.println("=====/wappay/pay====");
        return "/wappay/pay";
    }


}
