package com.hndl.cn.dao.imsinger.mapper;

import com.hndl.cn.dao.imsinger.bean.ImsingerWhoLeaveInfoDo;
import com.hndl.cn.dao.imsinger.bean.ImsingerWhoLeaveInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImsingerWhoLeaveInfoDoMapper {
    long countByExample(ImsingerWhoLeaveInfoDoExample example);

    int deleteByExample(ImsingerWhoLeaveInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsingerWhoLeaveInfoDo record);

    int insertSelective(ImsingerWhoLeaveInfoDo record);

    List<ImsingerWhoLeaveInfoDo> selectByExample(ImsingerWhoLeaveInfoDoExample example);

    ImsingerWhoLeaveInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsingerWhoLeaveInfoDo record, @Param("example") ImsingerWhoLeaveInfoDoExample example);

    int updateByExample(@Param("record") ImsingerWhoLeaveInfoDo record, @Param("example") ImsingerWhoLeaveInfoDoExample example);

    int updateByPrimaryKeySelective(ImsingerWhoLeaveInfoDo record);

    int updateByPrimaryKey(ImsingerWhoLeaveInfoDo record);
}