package com.hndl.cn.base.annotation.hystrix;

/**
 * @Classname 赵俊凯
 * @Description 熔断服务的注解
 * @Date 2019/4/11 11:46
 * @Created by 湖南达联
 */
public @interface HystrixCommand {

    /**
     * 当错误次数达到阈值或者执行超时，直接执行下面代码
     * 如果不填fallbackMethod则执行默认熔断方法
     * 如果填写fallbackMethod则熔断方法必须在配置注解的同一个类里面，否则抛出MethodNotFoundException
     * [熔断方法传参]
     * 1. 不传参则直接执行fallbackMethod熔断方法
     * 2. 传参则必须和配置注解方法传参类型保持一致, 否则会执行错误
     * 参考：HttpHystrixAspect.java
     * @return
     */
    String fallbackMethod() default "";


    /**
     * 分组的名称
     * @return
     */
    String groupName() default "";
}
