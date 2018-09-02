package com.study.lxy.aspect;

import java.lang.annotation.*;

/**
 * 描述：
 * <p>
 * <p>
 * harryliu
 * 2018/8/23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface MethodAnno {
}
