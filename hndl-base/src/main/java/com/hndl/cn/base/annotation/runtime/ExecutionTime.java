package com.hndl.cn.base.annotation.runtime;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ExecutionTime {
    String name() default "";
}
