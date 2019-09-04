package com.hndl.cn.dao.welfare.mapper;

import com.hndl.cn.dao.welfare.bean.WelfareColumnInfoDo;
import com.hndl.cn.dao.welfare.bean.WelfareColumnInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WelfareColumnInfoDoMapper {
    long countByExample(WelfareColumnInfoDoExample example);

    int deleteByExample(WelfareColumnInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WelfareColumnInfoDo record);

    int insertSelective(WelfareColumnInfoDo record);

    List<WelfareColumnInfoDo> selectByExample(WelfareColumnInfoDoExample example);

    WelfareColumnInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WelfareColumnInfoDo record, @Param("example") WelfareColumnInfoDoExample example);

    int updateByExample(@Param("record") WelfareColumnInfoDo record, @Param("example") WelfareColumnInfoDoExample example);

    int updateByPrimaryKeySelective(WelfareColumnInfoDo record);

    int updateByPrimaryKey(WelfareColumnInfoDo record);
}