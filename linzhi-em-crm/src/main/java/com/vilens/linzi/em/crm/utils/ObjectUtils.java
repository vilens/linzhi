package com.vilens.linzi.em.crm.utils;

/**
 * Created by vilens on 2017/6/4.
 */
public class ObjectUtils {
    public static boolean allIsNotNull(Object... args) {
        Object[] var1 = args;
        int var2 = args.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Object o = var1[var3];
            if(o == null) {
                return false;
            }
        }

        return true;
    }
}
