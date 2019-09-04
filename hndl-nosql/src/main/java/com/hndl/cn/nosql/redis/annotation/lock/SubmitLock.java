package com.hndl.cn.nosql.redis.annotation.lock;

import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;

import java.lang.annotation.*;

/**
 * @author 赵俊凯
 * @Description 加入此注解在方法上，可以防止分布式情况下的重复提交，保证每一次提交的原子性
 * @Date 2019/8/1 10:15
 * @Created by 湖南达联
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SubmitLock {


    /**
     * 获取方法上的值做为KEY
     * @return
     */
    String[] keys();


    /**
     * 过期时间
     * @return
     */
    long timeOut() default 60L;


    /**
     * 系统标识
     * @return
     */
    ExceptionSysMarkEnum sysMarkEnum();

 }
