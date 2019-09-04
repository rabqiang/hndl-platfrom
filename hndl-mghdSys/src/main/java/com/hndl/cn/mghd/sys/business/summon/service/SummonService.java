package com.hndl.cn.mghd.sys.business.summon.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;

/**
 * @program: hndl-platform
 * @description: 召唤服务层
 * @author: 易成贤
 * @create: 2019-05-10 14:05
 * @Created by 湖南达联
 **/
public interface SummonService {
    /**
     * 执行守护
     * @param commonUserInfoDo
     * @param starId
     * @return
     */
    Result<Object> doSummon(CommonUserInfoDo commonUserInfoDo, Long starId);
}
