package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonAppHomeGameConfigDo;
import com.hndl.cn.dao.common.bean.CommonAppHomeGameConfigDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonAppHomeGameConfigDoMapper {
    long countByExample(CommonAppHomeGameConfigDoExample example);

    int deleteByExample(CommonAppHomeGameConfigDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonAppHomeGameConfigDo record);

    int insertSelective(CommonAppHomeGameConfigDo record);

    List<CommonAppHomeGameConfigDo> selectByExample(CommonAppHomeGameConfigDoExample example);

    CommonAppHomeGameConfigDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonAppHomeGameConfigDo record, @Param("example") CommonAppHomeGameConfigDoExample example);

    int updateByExample(@Param("record") CommonAppHomeGameConfigDo record, @Param("example") CommonAppHomeGameConfigDoExample example);

    int updateByPrimaryKeySelective(CommonAppHomeGameConfigDo record);

    int updateByPrimaryKey(CommonAppHomeGameConfigDo record);
}