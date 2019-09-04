package com.hndl.cn.chat.sys.business.room.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;

/**
 * @Classname 赵俊凯
 * @Description 环信用户service
 * @Date 2019/3/21 21:13
 * @Created by 湖南达联
 */
public interface SysUserInfoService {


    /**
     *  插入环信用户，返回用户信息
     * @param commonUserInfoDo
     * @return
     */
    Result<Object> insertEaseMobUser(CommonUserInfoDo commonUserInfoDo);





}
