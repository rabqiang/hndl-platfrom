package com.hndl.cn.mghd.admin.business.call.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.call.vo.CallContentVo;

import java.util.List;

/**
 * @program:hndl-platform
 * @description: call内容管理
 * @author: 易成贤
 * @create: 2019-06-25 10:48
 * @Created by湖南达联
 **/
public interface CallContentService {
    /**
     * 删除call内容
     * @param callId
     * @return
     */
    Result deleteCall(Long callId);

    /**
     * 查询call
     * @param id
     * @param
     * @return
     */
   Result<List<CallContentVo>>  findCall(String id,String parameters,Integer isDelete);

    /**
     * 加入精华call（设置精华打call）<br/>
     * Quintessence(n.精华/典范)
     * @param callId
     * @return
     */
   Result addQuintessence(Long callId);

    /**
     * 移除精华
     * @param callId
     * @return
     */
   Result removeQuintessence(Long callId);

    /**
     * 查询单个call
     * @param callId
     * @return
     */
    Result<CallContentVo> findOneCall(Long callId);
}
