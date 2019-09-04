package com.hndl.cn.shop.sys.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.exception.BaseException;
import com.hndl.cn.base.exception.ExceptionLog;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.utils.request.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Classname 赵俊凯
 * @Description 统一处理异常拦截
 * @Date 2019/3/13 11:27
 * @Created by 湖南达联
 */
@RestController
@ControllerAdvice
@Slf4j
public class MghdSysControllerAdvice {

    /**
     * 业务异常
     *
     * @param ex
     * @return
     * @Description
     * @author 赵俊凯
     */
    @ExceptionHandler(BaseException.class)
    public Result<Object> handleException(BaseException ex, HttpServletRequest request) {
        if(ex.getErrorCode().equals(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode())){
            ExceptionLog.errorPrintStraceAndPath(log,RequestUtil.getRequestPath(request),ex);
        }else {
            ExceptionLog.error(log, ex);
        }
        return ResultFactory.failure(ex.getErrorCode(), ex.getMsg());
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public Result<Object> classCastExceptionHandler(ClassCastException ex,HttpServletRequest request) {
        ShopSysException weChatSysException = new ShopSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(),ex);
        ExceptionLog.errorPrintStraceAndPath(log, RequestUtil.getErrorMsg(request), weChatSysException);
        return ResultFactory.failure(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(), PublicExceptionCodeEnum.Ex_PARAM_ERROR.getMsg());
    }

    /**
     * 未知异常
     *
     * @param ex
     * @return
     * @Description
     * @author 赵俊凯
     */
    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(Exception ex, HttpServletRequest request) {
        ShopSysException weChatSysException = new ShopSysException(PublicExceptionCodeEnum.EX_UNKNOWN.getCode(),ex);
        ExceptionLog.errorPrintStraceAndPath(log, RequestUtil.getErrorMsg(request), weChatSysException);
        return ResultFactory.failure(PublicExceptionCodeEnum.EX_UNKNOWN.getCode(), PublicExceptionCodeEnum.EX_UNKNOWN.getMsg());
    }

    /**
     * 空指针异常
     *
     * @param ex
     * @return
     * @Description
     * @author 赵俊凯
     */
    @ExceptionHandler(NullPointerException.class)
    public Result<Object> handleException(NullPointerException ex, HttpServletRequest request) {
        ShopSysException weChatSysException = new ShopSysException
                (PublicExceptionCodeEnum.EX_OPERATION_FAIL.getCode(), ex);
        ExceptionLog.errorPrintStraceAndPath(log, RequestUtil.getErrorMsg(request),weChatSysException);
        return ResultFactory.failure(PublicExceptionCodeEnum.EX_OPERATION_FAIL.getCode(), ex.getMessage());
    }

    /**
     * http请求method有误异常
     *
     * @param ex
     * @return
     * @Description
     * @author 赵俊凯
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<Object> handleException(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        ShopSysException weChatSysException = new ShopSysException
                (PublicExceptionCodeEnum.EX_METHOD_ERROR.getCode(), ex);
        ExceptionLog.errorAndPath(log, RequestUtil.getErrorMsg(request), weChatSysException);
        return ResultFactory.failure(PublicExceptionCodeEnum.EX_METHOD_ERROR.getCode(),
                PublicExceptionCodeEnum.EX_METHOD_ERROR.getMsg());

    }

    /**
     * 参数不合法异常
     *
     * @param ex
     * @return
     * @Description
     * @author 赵俊凯
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> handleException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        ShopSysException weChatSysException = new ShopSysException
                (PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(), ex);
        ExceptionLog.errorAndPath(log, RequestUtil.getErrorMsg(request), weChatSysException);

        BindingResult a = ex.getBindingResult();
        List<ObjectError> list = a.getAllErrors();
        String errorMsg = PublicExceptionCodeEnum.Ex_PARAM_ERROR.getMsg();
        if (!CollectionUtils.isEmpty(list)) {
            errorMsg = list.get(0).getDefaultMessage();
        }
        return ResultFactory.failure(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(), errorMsg);
    }

    /**
     * 参数异常
     *
     * @param ex
     * @return
     * @Description
     * @author 赵俊凯
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Result<Object> handleException(IllegalArgumentException ex, HttpServletRequest request) {
        ShopSysException weChatSysException = new ShopSysException
                (PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(), ex);
        ExceptionLog.errorAndPath(log, RequestUtil.getErrorMsg(request), weChatSysException);
        return ResultFactory.failure(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(), PublicExceptionCodeEnum.Ex_PARAM_ERROR.getMsg());
    }

    /**
     * 参数异常
     *
     * @param ex
     * @return
     * @Description
     * @author 赵俊凯
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<Object> missingServletRequestParameterException(MissingServletRequestParameterException ex,
                                                                    HttpServletRequest request) {
        ShopSysException weChatSysException = new ShopSysException
                (PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(), ex);
        ExceptionLog.errorAndPath(log, RequestUtil.getErrorMsg(request), weChatSysException);
        return ResultFactory.failure(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(),
                PublicExceptionCodeEnum.Ex_PARAM_ERROR.getMsg(), ex.getParameterName());
    }

    /**
     * 参数异常
     *
     * @param ex
     * @return
     * @Description
     * @author 赵俊凯
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<Object> httpMessageNotReadableException(UnrecognizedPropertyException ex,
                                                            HttpServletRequest request) {
        ShopSysException weChatSysException = new ShopSysException
                (PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(), ex);
        ExceptionLog.errorAndPath(log, RequestUtil.getErrorMsg(request), weChatSysException);
        return ResultFactory.failure(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(),
                PublicExceptionCodeEnum.Ex_PARAM_ERROR.getMsg(), ex.getPropertyName());
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true) {
            @Override
            public void setAsText(String text) {
                try {
                    super.setAsText(text);
                } catch (Exception ex) {
                    ExceptionLog.error(log, new ShopSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(), ex));
                }
            }
        });
    }





}
