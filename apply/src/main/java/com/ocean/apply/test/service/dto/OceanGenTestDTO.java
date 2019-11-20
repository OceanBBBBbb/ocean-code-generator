package com.ocean.apply.test.service.dto;

import lombok.Data;
import java.io.Serializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


/**
* @author ocean-genetator
* @date 2019-11-20
*/
@Data
public class OceanGenTestDTO implements Serializable {

    // 处理精度丢失问题
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    // 前端api文件路径
    private String apiPath;

    // 作者
    private String author;

    // 是否覆盖
    private Boolean cover;

    // 模块名
    private String moduleName;

    // 包路径
    private String pack;

    // 前端文件路径
    private String path;

    // 表前缀
    private String prefix;
}