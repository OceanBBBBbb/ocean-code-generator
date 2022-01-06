package com.ocean.common.utils;

import com.ocean.common.exception.BadRequestException;

import java.util.Optional;

/**
 * 验证工具
 *
 * @author Ocean Bin
 * @date 2019-11-20
 */
public class ValidationUtil {

    /**
     * 验证空
     *
     * @param optional
     */
    public static void isNull(Optional optional, String entity, String parameter, Object value) {
        if (!optional.isPresent()) {
            String msg = entity
                    + " 不存在 "
                    + "{ " + parameter + ":" + value.toString() + " }";
            throw new BadRequestException(msg);
        }
    }

    /**
     * 验证是否为邮箱
     *
     * @param string
     * @return
     */
    public static boolean isEmail(String string) {
        if (string == null) {
            return false;
        }
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return string.matches(regEx1);
    }
}
