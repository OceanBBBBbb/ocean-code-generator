package com.ocean.apply.app.test.rest;

import com.ocean.apply.app.test.domain.OceanGenTest;
import com.ocean.apply.app.test.service.OceanGenTestService;
import com.ocean.apply.app.test.service.dto.OceanGenTestQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

/**
 * @author ocean-genetator
 * @date 2019-11-20
 */
@Api(tags = "OceanGenTest管理")
@RestController
@RequestMapping("api")
public class OceanGenTestController {

    @Autowired
    private OceanGenTestService oceanGenTestService;

    @ApiOperation(value = "查询OceanGenTest")
    @GetMapping(value = "/oceanGenTest")
    public ResponseEntity getOceanGenTests(OceanGenTestQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity(oceanGenTestService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @ApiOperation(value = "新增OceanGenTest")
    @PostMapping(value = "/oceanGenTest")
    public ResponseEntity create(@Validated @RequestBody OceanGenTest resources) {
        return new ResponseEntity(oceanGenTestService.create(resources), HttpStatus.CREATED);
    }

    @ApiOperation(value = "修改OceanGenTest")
    @PutMapping(value = "/oceanGenTest")
    public ResponseEntity update(@Validated @RequestBody OceanGenTest resources) {
        oceanGenTestService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "删除OceanGenTest")
    @DeleteMapping(value = "/oceanGenTest/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        oceanGenTestService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}