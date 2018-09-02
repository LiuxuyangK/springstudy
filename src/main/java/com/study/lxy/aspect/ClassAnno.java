package com.study.lxy.aspect;

import java.lang.annotation.*;

/**
 * 描述：
 * <p>
 * <p>
 * harryliu
 * 2018/8/22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface ClassAnno {
    boolean needLog() default true;
}
