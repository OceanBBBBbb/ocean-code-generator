package com.ocean.generator.service;


import com.ocean.generator.domain.GenConfig;
import com.ocean.generator.domain.vo.ColumnInfo;

import java.util.List;

/**
 * @author Ocean Bin
 * @date 2019-11-20
 */
public interface GeneratorService {

    /**
     * 查询数据库元数据
     *
     * @param name
     * @param startEnd
     * @return
     */
    Object getTables(String name, int[] startEnd);

    /**
     * 得到数据表的元数据
     *
     * @param name
     * @return
     */
    Object getColumns(String name);

    /**
     * 生成代码
     *
     * @param columnInfos
     * @param genConfig
     * @param tableName
     */
    void generator(List<ColumnInfo> columnInfos, GenConfig genConfig, String tableName);
}
