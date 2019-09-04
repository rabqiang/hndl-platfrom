package com.hndl.cn.mysql.manager.video.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.video.bean.WeiboVideoDo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 微博视频
 * @author: 易成贤
 * @create: 2019/8/22 10:42
 * @Created by湖南达联
 **/
public interface WeiBoVideoManager {

    /**
     * 查询微博视频
     * @param pageNo 页码
     * @param isDelete 是否删除
     * @return
     */
   List<WeiboVideoDo> findWeiBoVideo(@NotNull Integer pageNo, @NotNull IsValidEnums isDelete);

    /**
     * 插入一条微博视频
     * @param weiboVideoDo
     * @return
     */
   int insertWeiBoVideo(@NotNull WeiboVideoDo weiboVideoDo);
}
