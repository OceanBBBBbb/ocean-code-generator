package ${package}.rest;

import ${package}.domain.${className};
import ${package}.service.${className}Service;
import ${package}.service.dto.${className}QueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

/**
* @author ${author}
* @date ${date}
*/
@Api(tags = "${className}管理")
@RestController
@RequestMapping("api")
public class ${className}Controller {

    @Autowired
    private ${className}Service ${changeClassName}Service;

    @ApiOperation(value = "查询${className}")
    @GetMapping(value = "/${changeClassName}")
    public ResponseEntity get${className}s(${className}QueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(${changeClassName}Service.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @ApiOperation(value = "新增${className}")
    @PostMapping(value = "/${changeClassName}")
    public ResponseEntity create(@Validated @RequestBody ${className} resources){
        return new ResponseEntity(${changeClassName}Service.create(resources),HttpStatus.CREATED);
    }

    @ApiOperation(value = "修改${className}")
    @PutMapping(value = "/${changeClassName}")
    public ResponseEntity update(@Validated @RequestBody ${className} resources){
        ${changeClassName}Service.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "删除${className}")
    @DeleteMapping(value = "/${changeClassName}/{${pkChangeColName}}")
    public ResponseEntity delete(@PathVariable ${pkColumnType} ${pkChangeColName}){
        ${changeClassName}Service.delete(${pkChangeColName});
        return new ResponseEntity(HttpStatus.OK);
    }
}