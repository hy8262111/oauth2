package com.ganwei.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: houyong
 * @Date: 2019/9/24 11:26
 * @describe
 */
@RestController
public class TestController {

    @RequestMapping(value = "/company/get", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('compansadfy/get22')")
    public JSONObject login(String id) {
        System.out.println("aaa");
        return null;
    }


    /**
     * 该接口放行
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/get", method = RequestMethod.POST)
    public JSONObject login1(String id) {
        System.out.println("bbb");
        return null;
    }
}
