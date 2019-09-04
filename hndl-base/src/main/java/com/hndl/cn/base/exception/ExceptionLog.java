package com.hndl.cn.base.exception;


import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 *
 * 【标题】: 日志工具类
 * 【描述】: 日志工具类，用来定义日志格式
 * 【版权】: 湖南达联
 * 【作者】: 赵俊凯
 * 【时间】: 2017-12-29 16:15
 * </pre>
 */
public class ExceptionLog {


    private static final Logger log = LoggerFactory.getLogger(ExceptionLog.class);

    /**
     * 输出error日志，不打印堆栈
     * @param logger
     * @param e
     */
    public static void error(Logger logger, BaseException e){
        if(logger == null || e == null){
            return;
        }
        logger.error(buildExMsg(e));
    }

    /**
     * 输出error日志，不打印堆栈
     * @param logger
     * @param e
     */
    public static void errorAndPath(Logger logger, String errorPath,BaseException e){
        if(logger == null || e == null){
            return;
        }
        logger.error(buildExMsg(e)+ "[errorPath] = " + errorPath);
    }



    /**
     * 输出错误日志并打印堆栈
     * @param logger
     * @param e
     */
    public static void errorPrintStrace(Logger logger, BaseException e){
        if(logger == null || e == null){
            return;
        }
        logger.error(buildExMsg(e) + "[ex] = " , e.getSourceT());
    }

    /**
     * 输出错误日志并打印堆栈
     * @param logger
     * @param e
     */
    public static void errorPrintStraceAndPath(Logger logger,String path, BaseException e){
        if(logger == null || e == null){
            return;
        }
        logger.error(buildExMsg(e) +"[errorPath] = " + path + " | [ex] = ", e.getSourceT());
    }


    /**
     * 输出info日志，不打印堆栈
     * @param logger
     * @param e
     */
    public static void info(Logger logger, BaseException e){
        if(logger == null || e == null){
            return;
        }
        logger.error(buildExMsg(e));
    }



    /**
     * 输出info日志并打印堆栈
     * @param logger
     * @param e
     */
    public static void infoPrintStrace(Logger logger, BaseException e){
        if(logger == null || e == null){
            return;
        }
        logger.error(buildExMsg(e) + "[ex] = " +e.getSourceT());
    }


    private static String  buildExMsg(BaseException e){
           return e.toString();
    }


    public static void main(String[] args) {
        ExceptionLog.errorPrintStraceAndPath(log,null,new BaseException("1","1", ExceptionSysMarkEnum.ACTIVITY_SYS));
    }

}
