package com.space.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 清除字符串前后的空格
 */
@Target(value = { ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Trimmed {

    enum TrimmerType {
        SIMPLE, ALL_WHITESPACES, EXCEPT_LINE_BREAK;
    }

    TrimmerType value() default TrimmerType.ALL_WHITESPACES;

}