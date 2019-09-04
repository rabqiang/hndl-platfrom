package com.hndl.cn.mysql.manager.video.manager;

import com.hndl.cn.dao.video.bean.ExclusiveVideoDo;

import java.util.List;


/**
 * @program: hndl-platform
 * @description: 独家视频
 * @author: 易成贤
 * @create: 2019-06-18 10:39
 * @Created by 湖南达联
 **/
public interface ExclusiveVideoManager {

    List<ExclusiveVideoDo> findExclusiveVideos(Integer pageNo);
}
