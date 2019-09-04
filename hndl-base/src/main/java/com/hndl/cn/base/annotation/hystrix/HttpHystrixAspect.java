package com.hndl.cn.base.annotation.hystrix;

import com.hndl.cn.base.hystrix.HttpHystrix;
import com.netflix.hystrix.HystrixRequestLog;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @Classname 赵俊凯
 * @Description 熔断切面AOP
 * @Date 2019/4/11 11:48
 * @Created by 湖南达联
 */

@Component
@Aspect
public class HttpHystrixAspect {


    private Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 对HTTP请求进行AOP操作
     */
    @Around("@annotation(hystrixCommand)")
    public Object aroundHttpRequest(ProceedingJoinPoint pjp,HystrixCommand hystrixCommand) throws Exception, Throwable{
        Object result = null;
        // 执行类名
        String targetName = pjp.getTarget().getClass().getSimpleName();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        // 执行方法名
        String methodName = signature.getMethod().getName();

        // 初始化熔断器上下文
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            result = new HttpHystrix(pjp, targetName, methodName, hystrixCommand).execute();
        } finally {
            logger.info("Request => " + HystrixRequestLog.getCurrentRequest().getExecutedCommandsAsString());
            context.shutdown();
        }
        return result;
    }

}
