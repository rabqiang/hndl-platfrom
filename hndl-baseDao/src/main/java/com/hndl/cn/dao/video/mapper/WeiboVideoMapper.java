package com.hndl.cn.dao.video.mapper;

import com.hndl.cn.dao.video.bean.WeiboVideoDo;
import com.hndl.cn.dao.video.bean.WeiboVideoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeiboVideoMapper {
    long countByExample(WeiboVideoDoExample example);

    int deleteByExample(WeiboVideoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WeiboVideoDo record);

    int insertSelective(WeiboVideoDo record);

    List<WeiboVideoDo> selectByExample(WeiboVideoDoExample example);

    WeiboVideoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WeiboVideoDo record, @Param("example") WeiboVideoDoExample example);

    int updateByExample(@Param("record") WeiboVideoDo record, @Param("example") WeiboVideoDoExample example);

    int updateByPrimaryKeySelective(WeiboVideoDo record);

    int updateByPrimaryKey(WeiboVideoDo record);
}