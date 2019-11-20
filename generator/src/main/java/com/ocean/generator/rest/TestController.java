package com.ocean.generator.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: binhy
 * @create: 2019/11/20
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/get")
    public String test(){
        return "success";
    }
}
