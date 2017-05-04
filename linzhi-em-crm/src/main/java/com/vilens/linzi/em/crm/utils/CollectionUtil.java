package com.vilens.linzi.em.crm.utils;

import java.util.List;

/**
 * Created by vilens on 2017/4/12.
 */
public class CollectionUtil {
    public static boolean isNotEmpty(List<String> list) {
        return (list != null && list.size() != 0);
    }
    public static boolean isEmpty(List<String> list) {
        return list == null || list.size() == 0;
    }

}
