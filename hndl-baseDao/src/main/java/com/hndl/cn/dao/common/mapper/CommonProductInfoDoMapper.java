package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonProductInfoDo;
import com.hndl.cn.dao.common.bean.CommonProductInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonProductInfoDoMapper {
    long countByExample(CommonProductInfoDoExample example);

    int deleteByExample(CommonProductInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonProductInfoDo record);

    int insertSelective(CommonProductInfoDo record);

    List<CommonProductInfoDo> selectByExample(CommonProductInfoDoExample example);

    CommonProductInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonProductInfoDo record, @Param("example") CommonProductInfoDoExample example);

    int updateByExample(@Param("record") CommonProductInfoDo record, @Param("example") CommonProductInfoDoExample example);

    int updateByPrimaryKeySelective(CommonProductInfoDo record);

    int updateByPrimaryKey(CommonProductInfoDo record);
}