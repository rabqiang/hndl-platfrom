package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonUserProductDo;
import com.hndl.cn.dao.common.bean.CommonUserProductDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonUserProductDoMapper {
    long countByExample(CommonUserProductDoExample example);

    int deleteByExample(CommonUserProductDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonUserProductDo record);

    int insertSelective(CommonUserProductDo record);

    List<CommonUserProductDo> selectByExample(CommonUserProductDoExample example);

    CommonUserProductDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonUserProductDo record, @Param("example") CommonUserProductDoExample example);

    int updateByExample(@Param("record") CommonUserProductDo record, @Param("example") CommonUserProductDoExample example);

    int updateByPrimaryKeySelective(CommonUserProductDo record);

    int updateByPrimaryKey(CommonUserProductDo record);
}