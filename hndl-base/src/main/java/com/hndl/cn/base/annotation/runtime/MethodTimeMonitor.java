package com.hndl.cn.base.annotation.runtime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 思路：
 * 1，先定义一个切面  apsect
 * 2，定义切点 pointcut ，描述哪些join point（方法的连接点）需要被执行，这里是通过注解的方式才被执行，可以其它的描述方式定义你的切点范围
 * 3，定义执行方法前后要执行的相关操作 around 。 Object  obj = joinPoint.proceed();; 表示函数执行，前后用开始时间和结束时间围住，
 * 4，最后打印 执行自定义名字（自己起个名字，便于线上快速批量打印你想看的数据），执行方法名字和执行的时间
 *
 */
@Aspect
@Component
public class MethodTimeMonitor {
    private final Logger logger = LoggerFactory.getLogger(MethodTimeMonitor.class);


    @Pointcut(value = "@annotation(com.hndl.cn.base.annotation.runtime.ExecutionTime)")
        public void ExecutionTimeLog() {
    }
    //环绕通知实现方式
    @Around("ExecutionTimeLog()")
    public Object doAround(ProceedingJoinPoint joinPoint, ExecutionTime executionTime) throws Throwable {
        //可以尝试使用  long nanoTime = System.nanoTime();获取纳秒时间

        long starTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        }finally {
            logger.info("execute-time-name : [{}], execution-time : [{}], class-method : [{}]", executionTime.name(), (System.currentTimeMillis()- starTime),
                    joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
        }
    }
}