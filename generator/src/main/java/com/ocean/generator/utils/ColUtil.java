package com.ocean.generator.utils;

import org.apache.commons.configuration.*;

/**
 * sql字段转java
 *
 * @author Ocean Bin
 * @date 2019-01-03
 */
public class ColUtil {

    /**
     * 转换mysql数据类型为java数据类型
     *
     * @param type
     * @return
     */
    public static String cloToJava(String type) {
        Configuration config = getConfig();
        return config.getString(type, "unknowType");
    }

    /**
     * 获取配置信息
     */
    public static PropertiesConfiguration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
