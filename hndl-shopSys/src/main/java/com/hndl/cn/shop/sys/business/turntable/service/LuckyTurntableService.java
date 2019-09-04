package com.hndl.cn.shop.sys.business.turntable.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.shop.sys.business.turntable.vo.LuckyTurntableVo;

import java.util.Map;

/**
 *
 */
public interface LuckyTurntableService {
    /**
     * 抽奖
     * @param commonUserInfoDo
     * @return
     */
    Result<LuckyTurntableVo> prizeDraw(CommonUserInfoDo commonUserInfoDo ,Integer version);

    /**
     * 查询奖品列表
     * @return
     */
    Result<Map<String,Object>> findPrize(CommonUserInfoDo commonUserInfoDo);

    /**
     * 查询用户中将信息
     * @param commonUserInfoDo
     * @return
     */
    Result<Map<String,Object>> findUserDraw(CommonUserInfoDo commonUserInfoDo,String id);

    /**
     * 视频上报接口
     * @param commonUserInfoDo
     * @return
     */
    Result<Map<String, Object>> reportVideo(CommonUserInfoDo commonUserInfoDo);

    /**
     * 查询用户福卡相关
     * @param commonUserInfoDo
     * @return
     */
    Result<Map<String, Object>> findUserFoucault(CommonUserInfoDo commonUserInfoDo);
}
