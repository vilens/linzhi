package com.vilens.linzi.em.crm.security;

import java.lang.annotation.*;
/**
 * Created by vilens on 2017/4/13.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreSecurity {
}
