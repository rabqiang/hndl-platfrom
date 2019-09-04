package com.hndl.cn.dao.welfare.mapper;

import com.hndl.cn.dao.welfare.bean.WelfareProjectInfoDo;
import com.hndl.cn.dao.welfare.bean.WelfareProjectInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WelfareProjectInfoDoMapper {
    long countByExample(WelfareProjectInfoDoExample example);

    int deleteByExample(WelfareProjectInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WelfareProjectInfoDo record);

    int insertSelective(WelfareProjectInfoDo record);

    List<WelfareProjectInfoDo> selectByExample(WelfareProjectInfoDoExample example);

    WelfareProjectInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WelfareProjectInfoDo record, @Param("example") WelfareProjectInfoDoExample example);

    int updateByExample(@Param("record") WelfareProjectInfoDo record, @Param("example") WelfareProjectInfoDoExample example);

    int updateByPrimaryKeySelective(WelfareProjectInfoDo record);

    int updateByPrimaryKey(WelfareProjectInfoDo record);
}