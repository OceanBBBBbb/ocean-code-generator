package com.ocean.apply.ctl;

import com.ocean.generator.domain.GenConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: binhy
 * @create: 2019/11/20
 **/
@RestController
@RequestMapping("/apply")
public class TestApplController {

    @GetMapping("/test")
    public String test(){

        GenConfig genConfig = new GenConfig();
        genConfig.setId(1111L);
        return "success in apply";
    }
}
