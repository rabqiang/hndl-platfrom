package com.hndl.cn.base.annotation.auth;

import java.lang.annotation.*;

/**
 * @Classname 赵俊凯
 * @Description 用于验证用户是否登录注解
 * @Date 2019/3/14 12:00
 * @Created by 湖南达联
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthPassport {

    boolean validate() default true;
}
