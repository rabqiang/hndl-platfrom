package com.hndl.cn.mghd.admin.business.user.service;

import com.hndl.cn.base.result.Result;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/6/20 20:26
 * @Created by 湖南达联
 */
public interface UserEmpiricalService {

    /**
     * 查询用户经验值
     * @param userUniId
     * @return
     */
    Result<Object> findUserEmpiricalById(Long userUniId,String id);

}
