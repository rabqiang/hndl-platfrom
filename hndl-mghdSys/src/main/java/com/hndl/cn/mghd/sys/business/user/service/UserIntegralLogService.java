package com.hndl.cn.mghd.sys.business.user.service;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.result.Result;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/5/20 11:18
 * @Created by 湖南达联
 */
public interface UserIntegralLogService {

    /**
     * 查询用户积分明细
     *
     * @param userUinId    用户id
     * @param isValidEnums 积分数据是支出还是收入
     * @param pageNo       页数
     * @param
     */
    Result<Object> findUserIntegralLog(Long userUinId, IsValidEnums isValidEnums, Integer pageNo,String id);
}
