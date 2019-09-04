package com.hndl.cn.dao.newyear.mapper;

import com.hndl.cn.dao.newyear.bean.NewyearSongPlayDo;
import com.hndl.cn.dao.newyear.bean.NewyearSongPlayDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewyearSongPlayDoMapper {
    long countByExample(NewyearSongPlayDoExample example);

    int deleteByExample(NewyearSongPlayDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NewyearSongPlayDo record);

    int insertSelective(NewyearSongPlayDo record);

    List<NewyearSongPlayDo> selectByExample(NewyearSongPlayDoExample example);

    NewyearSongPlayDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NewyearSongPlayDo record, @Param("example") NewyearSongPlayDoExample example);

    int updateByExample(@Param("record") NewyearSongPlayDo record, @Param("example") NewyearSongPlayDoExample example);

    int updateByPrimaryKeySelective(NewyearSongPlayDo record);

    int updateByPrimaryKey(NewyearSongPlayDo record);
}