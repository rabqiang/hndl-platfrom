package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonLiveItemInfoDo;
import com.hndl.cn.dao.common.bean.CommonLiveItemInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonLiveItemInfoDoMapper {
    long countByExample(CommonLiveItemInfoDoExample example);

    int deleteByExample(CommonLiveItemInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonLiveItemInfoDo record);

    int insertSelective(CommonLiveItemInfoDo record);

    List<CommonLiveItemInfoDo> selectByExample(CommonLiveItemInfoDoExample example);

    CommonLiveItemInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonLiveItemInfoDo record, @Param("example") CommonLiveItemInfoDoExample example);

    int updateByExample(@Param("record") CommonLiveItemInfoDo record, @Param("example") CommonLiveItemInfoDoExample example);

    int updateByPrimaryKeySelective(CommonLiveItemInfoDo record);

    int updateByPrimaryKey(CommonLiveItemInfoDo record);
}