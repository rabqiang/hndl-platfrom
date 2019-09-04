package com.hndl.cn.mghd.admin.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.exception.BaseException;
import com.hndl.cn.base.exception.ExceptionLog;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.utils.request.RequestUtil;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.ConcurrentAccessException;
import org.apache.shiro.authc.DisabledAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.servlet.NoHandlerFoundException;

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
public class MghdAdminControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(MghdAdminControllerAdvice.class);

    /**
     * 业务异常
     *
     * @param ex
     * @return
     * @Description
     * @author 赵俊凯
     */
    @ExceptionHandler(ShiroException.class)
    public Result<Object> handleException(ShiroException ex, HttpServletRequest request) {
        if (ex instanceof ConcurrentAccessException) {
            return ResultFactory.failure(PublicExceptionCodeEnum.EX_EXCESSIVE_ATTEMPTS.getCode(), PublicExceptionCodeEnum.EX_EXCESSIVE_ATTEMPTS.getMsg());
        }
        if (ex instanceof DisabledAccountException) {
            return ResultFactory.failure(PublicExceptionCodeEnum.EX_USER_LOCKED.getCode(), PublicExceptionCodeEnum.EX_USER_LOCKED.getMsg());
        }
        return ResultFactory.failure(PublicExceptionCodeEnum.EX_LOGIN_USER_PWD_ERROR.getCode(), PublicExceptionCodeEnum.EX_LOGIN_USER_PWD_ERROR.getMsg());
    }


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
        ExceptionLog.error(log, ex);
        return ResultFactory.failure(ex.getErrorCode(), ex.getMsg());
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<Object> handleException(NoHandlerFoundException ex, HttpServletRequest request) {
        MghdAdminException mghdAdminException = new MghdAdminException(PublicExceptionCodeEnum.EX_NOT_MAPPING_ERROR.getCode(), ex);
        ExceptionLog.errorAndPath(log, RequestUtil.getErrorMsg(request), mghdAdminException);
        return ResultFactory.failure(PublicExceptionCodeEnum.EX_NOT_MAPPING_ERROR.getCode(), PublicExceptionCodeEnum.EX_NOT_MAPPING_ERROR.getMsg());
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
        MghdAdminException mghdAdminException = new MghdAdminException(PublicExceptionCodeEnum.EX_UNKNOWN.getCode(), ex);
        ExceptionLog.errorPrintStraceAndPath(log, RequestUtil.getErrorMsg(request), mghdAdminException);
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
        MghdAdminException mghdAdminException = new MghdAdminException(PublicExceptionCodeEnum.EX_OPERATION_FAIL.getCode(), ex);
        ExceptionLog.errorPrintStraceAndPath(log,RequestUtil.getRequestPath(request),mghdAdminException);
        return ResultFactory.failure(PublicExceptionCodeEnum.EX_OPERATION_FAIL.getCode(), PublicExceptionCodeEnum.EX_OPERATION_FAIL.getCode());
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
        MghdAdminException mghdAdminException = new MghdAdminException(PublicExceptionCodeEnum.EX_METHOD_ERROR.getCode(), ex);
        ExceptionLog.errorAndPath(log, RequestUtil.getErrorMsg(request), mghdAdminException);
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
        MghdAdminException mghdAdminException = new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(), ex);
        ex.printStackTrace();
        ExceptionLog.errorAndPath(log, RequestUtil.getErrorMsg(request), mghdAdminException);
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
        ex.printStackTrace();
        MghdAdminException mghdAdminException = new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(), ex);
        ExceptionLog.errorAndPath(log, RequestUtil.getErrorMsg(request), mghdAdminException);
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
        ex.printStackTrace();
        MghdAdminException mghdAdminException = new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(), ex);
        ExceptionLog.errorAndPath(log, RequestUtil.getErrorMsg(request), mghdAdminException);
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
        ex.printStackTrace();
        MghdAdminException mghdAdminException = new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(), ex);
        ExceptionLog.errorAndPath(log, RequestUtil.getErrorMsg(request), mghdAdminException);
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
                    ExceptionLog.error(log, new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode(), ex));
                }
            }
        });
    }


}
