package com.hndl.cn.mghd.sys.business.like.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;

/**
 * @program: hndl-platform
 * @description: 点赞
 * @author: 易成贤
 * @create: 2019-05-09 11:01
 * @Created by 湖南达联
 **/
public interface LikeService {

    /**
     * 点赞
     * @param commonUserInfoDo
     * @param targetId 点赞的对象
     * @return
     */
    Result<Object> addLike(CommonUserInfoDo commonUserInfoDo,Long starId,Long targetId,Long userUniId);


}
