package com.hndl.cn.mghd.admin.business.user.service;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.result.Result;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/6/20 20:03
 * @Created by 湖南达联
 */
public interface UserIntegralService {

    /**
     * 查询用户积分信息表
     */

    Result<Object> findUserIntegralById(Long userUniId,String pageNo);


}
