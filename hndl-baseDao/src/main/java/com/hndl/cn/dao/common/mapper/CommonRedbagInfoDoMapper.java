package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonRedbagInfoDo;
import com.hndl.cn.dao.common.bean.CommonRedbagInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonRedbagInfoDoMapper {
    long countByExample(CommonRedbagInfoDoExample example);

    int deleteByExample(CommonRedbagInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonRedbagInfoDo record);

    int insertSelective(CommonRedbagInfoDo record);

    List<CommonRedbagInfoDo> selectByExample(CommonRedbagInfoDoExample example);

    CommonRedbagInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonRedbagInfoDo record, @Param("example") CommonRedbagInfoDoExample example);

    int updateByExample(@Param("record") CommonRedbagInfoDo record, @Param("example") CommonRedbagInfoDoExample example);

    int updateByPrimaryKeySelective(CommonRedbagInfoDo record);

    int updateByPrimaryKey(CommonRedbagInfoDo record);
}