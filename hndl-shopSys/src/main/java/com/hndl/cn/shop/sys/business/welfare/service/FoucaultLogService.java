package com.hndl.cn.shop.sys.business.welfare.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.shop.sys.business.welfare.vo.FoucaultLogVo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/8/1 10 54
 * @Description:
 * @Author: 资龙茂
 */
public interface FoucaultLogService {

    /**
     * 根据用户分页查询福卡增加记录
     * @param commonUserInfoDo
     * @param id
     * @return
     */
    Result<Object> findFoucaultAddInfo(@NotNull CommonUserInfoDo commonUserInfoDo, String id);

    /**
     * 根据用户分页查询福卡消费记录
     * @param commonUserInfoDo
     * @param id
     * @return
     */
    Result<Object> findFoucaultRedInfo(@NotNull CommonUserInfoDo commonUserInfoDo, String id);
}
