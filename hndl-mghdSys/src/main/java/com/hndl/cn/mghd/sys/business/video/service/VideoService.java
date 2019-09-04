package com.hndl.cn.mghd.sys.business.video.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.sys.business.video.vo.ExclusiveVideoVo;

import java.util.List;
import java.util.Map;

/**
 * @program: hndl-platform
 * @description: 独家视频
 * @author: 易成贤
 * @create: 2019-06-10 17:42
 * @Created by 湖南达联
 **/
public interface VideoService {


    /**
     * 查询独家视频
     * @return
     */
    Result<List<ExclusiveVideoVo>> ExclusiveVideo(Integer PageNo);

    /**
     * 查询微博视频
     */
    Result<Map<String,Object>> findWeiBoVideo(Integer pageNo);
}
