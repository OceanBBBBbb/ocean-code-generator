package com.ocean.apply.app.test.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.io.Serializable;

/**
* @author ocean-genetator
* @date 2019-11-20
*/
@Entity
@Data
@Table(name="ocean_gen_test")
public class OceanGenTest implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    // 前端api文件路径
    @Column(name = "api_path")
    private String apiPath;

    // 作者
    @Column(name = "author")
    private String author;

    // 是否覆盖
    @Column(name = "cover")
    private Boolean cover;

    // 模块名
    @Column(name = "module_name")
    private String moduleName;

    // 包路径
    @Column(name = "pack")
    private String pack;

    // 前端文件路径
    @Column(name = "path")
    private String path;

    // 表前缀
    @Column(name = "prefix")
    private String prefix;

    public void copy(OceanGenTest source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}