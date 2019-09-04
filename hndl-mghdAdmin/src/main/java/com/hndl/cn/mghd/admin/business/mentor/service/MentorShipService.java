package com.hndl.cn.mghd.admin.business.mentor.service;

import com.hndl.cn.base.result.Result;

/**
 * @author 曹加丽
 * @Description TODO 后台师徒系统
 * @Date 2019/6/19 16:59
 * @Created by 湖南达联
 */
public interface MentorShipService {

    /**
     * 查询师徒
     *
     * @param userId 用户id
     * @param  id 页数
     * @return
     */
    Result<Object> findUserMentorAll(Long userId, String id);

}
