package com.hndl.cn.mghd.sys.business.video.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.video.bean.ExclusiveVideoDo;
import com.hndl.cn.dao.video.bean.WeiboVideoDo;
import com.hndl.cn.mghd.sys.business.video.service.VideoService;
import com.hndl.cn.mghd.sys.business.video.vo.ExclusiveVideoVo;
import com.hndl.cn.mysql.manager.video.manager.ExclusiveVideoManager;
import com.hndl.cn.mysql.manager.video.manager.WeiBoVideoManager;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:hndl-platform
 * @description: 独家视频
 * @author: 易成贤
 * @create: 2019-06-10 17:43
 * @Created by湖南达联
 **/
@Service
@Slf4j
public class VideoServiceImpl implements VideoService {

    /**
     * 获取指定微博的数据
     */
    private static final String weiBoUrl= "https://m.weibo.cn/statuses/show?id=";

    @Resource
    ExclusiveVideoManager exclusiveVideoManager;

    @Resource
    WeiBoVideoManager weiBoVideoManager;

    /**
     * 查询独家视频
     *
     * @return
     */
    @Override
    public Result<List<ExclusiveVideoVo>> ExclusiveVideo(Integer pageNo) {
        List<ExclusiveVideoDo> exclusiveVideoDos = exclusiveVideoManager.findExclusiveVideos(pageNo);
        List<ExclusiveVideoVo> exclusiveVideoVos = SpringCglibBeanUtils.convertByList(exclusiveVideoDos, ExclusiveVideoVo.class);
        return ResultFactory.success(exclusiveVideoVos);
    }

    /**
     * 查询微博视频
     *
     * @param pageNo
     */
    @Override
    public Result<Map<String,Object>> findWeiBoVideo(Integer pageNo) {
        List<WeiboVideoDo> weiBoVideo = weiBoVideoManager.findWeiBoVideo(pageNo, IsValidEnums.NO);
        List<ExclusiveVideoVo> weiBoVos =  new ArrayList<>();
        weiBoVideo.forEach(v ->
            weiBoVos.add(ExclusiveVideoVo.builder().title(v.getTitle()).description(v.getContent()).txVid(v.getShowId()).videoImg(v.getVideoImg()).build())
        );
        Map<String,Object> map =  new HashMap(2);
        map.put("weiBoVideo",weiBoVos);
        map.put("requstUrl",weiBoUrl);
        return ResultFactory.success(map);
    }


}
