package com.hndl.cn.mysql.manager.video.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.video.bean.ExclusiveVideoDo;
import com.hndl.cn.dao.video.bean.ExclusiveVideoDoExample;
import com.hndl.cn.dao.video.mapper.ExclusiveVideoMapper;
import com.hndl.cn.mysql.manager.video.manager.ExclusiveVideoManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @program:hndl-platform
 * @description:
 * @author: 易成贤
 * @create: 2019-06-10 17:30 @Created by湖南达联
 */
@Service
public class ExclusiveVideoManagerImpl implements ExclusiveVideoManager {
  @Resource
  ExclusiveVideoMapper exclusiveVideoMapper;
  /**
   * 查询独家视频（Exclusive:独家的）
   *
   * @return 返回独家视频列表
   */
  @Override
  public List<ExclusiveVideoDo> findExclusiveVideos(Integer pageNo) {
      ExclusiveVideoDoExample example = new ExclusiveVideoDoExample();
      //查询没有被删除的独家视频
      example.createCriteria().andIsDeletedEqualTo(IsValidEnums.NO.getValue());
      PageHelper.startPage(pageNo, BaseConstants.DEFAULT_LIMIT,"order_num DESC,create_time DESC");
      List<ExclusiveVideoDo> exclusiveVideoDos = exclusiveVideoMapper.selectByExample(example);
      return new PageInfo<>(exclusiveVideoDos).getList();
  }
}
