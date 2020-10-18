package com.space.common.annotation;

import com.space.common.enums.OperationTypeEnum;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecordOperation {

    /** 操作描述 */
    String desc() default "";

    /** 业务类型,业务大类 */
    String bizType() default "";

    /** 操作类型*/
    OperationTypeEnum oprType();
}
