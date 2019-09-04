package com.hndl.cn.base.result;


import com.hndl.cn.base.enums.PublicExceptionCodeEnum;

/**
 * <pre>
 *  
 *
 * 【标题】: 返回结果工厂类
 * 【描述】: 
 * 【版权】: 湖南达联
 * 【作者】: 赵俊凯
 * 【时间】: 2017年6月21日 下午2:47:14
 * </pre>
 */
public class ResultFactory {

    /**
     * 成功结果
     * 
     * @Description
     * @author 赵俊凯
     * @param <T>
     * @return
     */
    public static <T> Result<T> success() {
        return new Result<T>(PublicExceptionCodeEnum.SUCCESS.getCode(), PublicExceptionCodeEnum.SUCCESS.getMsg());
    }

    /**
     * 成功结果
     * 
     * @Description
     * @author 赵俊凯
     * @param <T>
     * @param data
     *            返回数据
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(PublicExceptionCodeEnum.SUCCESS.getCode(), PublicExceptionCodeEnum.SUCCESS.getMsg(),
                data);
    }

    /**
     * 成功结果
     * 
     * @Description
     * @author 赵俊凯
     * @param <T>
     * @param data
     *            返回数据
     * @param total
     *            数据条数
     * @return
     */
    public static <T> Result<T> success(T data, Long total) {
        return new Result<T>(PublicExceptionCodeEnum.SUCCESS.getCode(), PublicExceptionCodeEnum.SUCCESS.getMsg(),
                data, total);
    }

    /**
     * 失败结果
     * 
     * @Description
     * @author 赵俊凯
     * @param <T>
     * @param code
     *            返回代码
     * @param message
     *            返回信息
     * @return
     */
    public static <T> Result<T> failure(String code, String message) {
        return new Result<T>(code, message);
    }

    public static <T> Result<T> failure() {
        return new Result<T>(PublicExceptionCodeEnum.EX_OPERATION_FAIL.getCode(),
                PublicExceptionCodeEnum.EX_OPERATION_FAIL.getMsg());
    }

    /**
     * 失败结果
     * 
     * @Description
     * @author 赵俊凯
     * @param <T>
     * @param code
     *            返回代码
     * @param message
     *            返回信息
     * @param data
     *            返回数据
     * @return
     */
    public static <T> Result<T> failure(String code, String message, T data) {
        return new Result<T>(code, message, data);
    }

}
