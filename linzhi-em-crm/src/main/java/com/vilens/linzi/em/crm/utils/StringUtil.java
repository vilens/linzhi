package com.vilens.linzi.em.crm.utils;

import org.apache.commons.lang.StringUtils;

/**
 * Created by vilens on 2017/4/12.
 */
public class StringUtil {
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
