package com.hndl.cn.mysql.manager.video.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.video.bean.WeiboVideoDo;
import com.hndl.cn.dao.video.bean.WeiboVideoDoExample;
import com.hndl.cn.dao.video.mapper.WeiboVideoMapper;
import com.hndl.cn.mysql.manager.video.manager.WeiBoVideoManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 微博视频
 * @author: 易成贤
 * @create: 2019/8/22 10:43
 * @Created by湖南达联
 **/
@Service
public class WeiBoVideoManagerImpl implements WeiBoVideoManager {

    @Resource
    WeiboVideoMapper weiboVideoMapper;
    /**
     * 查询微博视频
     *
     * @param pageNo   页码
     * @param isDelete 是否删除
     * @return
     */
    @Override
    public List<WeiboVideoDo> findWeiBoVideo(@NotNull Integer pageNo, @NotNull IsValidEnums isDelete) {
        WeiboVideoDoExample weiboVideoDoExample = new WeiboVideoDoExample();
        weiboVideoDoExample.createCriteria().andIsDeleteEqualTo(isDelete.getValue());
        PageHelper.startPage(pageNo, BaseConstants.DEFAULT_LIMIT,"order_num DESC,create_time DESC");
        List<WeiboVideoDo> weiboVideoDos = weiboVideoMapper.selectByExample(weiboVideoDoExample);
        PageInfo<WeiboVideoDo> videoDoPageInfo = new PageInfo<>(weiboVideoDos);
        return videoDoPageInfo.getList();
    }

    /**
     * 插入一条微博视频
     *
     * @param weiboVideoDo
     * @return
     */
    @Override
    public int insertWeiBoVideo(@NotNull WeiboVideoDo weiboVideoDo) {
       return weiboVideoMapper.insert(weiboVideoDo);
    }

}
