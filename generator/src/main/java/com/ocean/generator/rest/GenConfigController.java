package com.ocean.generator.rest;

import com.ocean.generator.domain.GenConfig;
import com.ocean.generator.service.GenConfigService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ocean Bin
 * @date 2019-01-14
 */
@RestController
@RequestMapping("/api")
@Api("生成器配置接口")
public class GenConfigController {

    private final GenConfigService genConfigService;

    public GenConfigController(GenConfigService genConfigService) {
        this.genConfigService = genConfigService;
    }

    /**
     * 查询生成器配置
     * @return
     */
    @GetMapping(value = "/genConfig")
    public ResponseEntity get(){
        return new ResponseEntity(genConfigService.find(), HttpStatus.OK);
    }

    @PutMapping(value = "/genConfig")
    public ResponseEntity emailConfig(@Validated @RequestBody GenConfig genConfig){
        return new ResponseEntity(genConfigService.update(genConfig),HttpStatus.OK);
    }
}
