package com.hndl.cn.mghd.sys.business.guard.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;

/**
 * @program: hndl-platform
 * @description: 守护
 * @author: 易成贤
 * @create: 2019-05-10 14:40
 * @Created by 湖南达联
 **/
public interface GuardService {
    /**
     * 用户守护明星
     * @param commonUserInfoDo 用户对象
     * @param starId 明星id
     * @return 成功
     */
    Result<Object> doGuard(CommonUserInfoDo commonUserInfoDo,Long starId);
}
