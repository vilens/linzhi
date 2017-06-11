package com.vilens.linzi.em.crm.utils;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.Map;

/**
 * Created by vilens on 2017/6/1.
 */
public class MapUtil extends org.apache.commons.collections.MapUtils{
    public static <K, V> Date getDate(Map<K, V> map, Object key) {
        if(map != null) {
            Object answer = map.get(key);
            if(answer != null) {
                return TimeUtil.trueTime(answer);
            }
        }

        return null;
    }

    public static Map<String, String> split(String source, Map<String, String> def) {
        return split(source, def, ",", "=");
    }

    public static Map<String, String> split(String source, Map<String, String> def, String s1, String s2) {
        Map result = def;

        try {
            String temp = StringUtils.trim(source);
            if(s1.equals(StringUtils.right(temp, 1))) {
                temp = StringUtils.left(temp, StringUtils.length(temp) - 1);
            }

            result = Splitter.on(s1).trimResults().withKeyValueSeparator(s2).split(temp);
        } catch (Exception var6) {
            ;
        }

        return result;
    }

    public static Map<String, String> split(String source) {
        Map<String, String> map = Maps.newHashMap();
        return split(source, map, ";", ":");
    }
}
