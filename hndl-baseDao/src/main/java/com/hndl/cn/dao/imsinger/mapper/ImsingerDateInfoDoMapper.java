package com.hndl.cn.dao.imsinger.mapper;

import com.hndl.cn.dao.imsinger.bean.ImsingerDateInfoDo;
import com.hndl.cn.dao.imsinger.bean.ImsingerDateInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImsingerDateInfoDoMapper {
    long countByExample(ImsingerDateInfoDoExample example);

    int deleteByExample(ImsingerDateInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsingerDateInfoDo record);

    int insertSelective(ImsingerDateInfoDo record);

    List<ImsingerDateInfoDo> selectByExample(ImsingerDateInfoDoExample example);

    ImsingerDateInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsingerDateInfoDo record, @Param("example") ImsingerDateInfoDoExample example);

    int updateByExample(@Param("record") ImsingerDateInfoDo record, @Param("example") ImsingerDateInfoDoExample example);

    int updateByPrimaryKeySelective(ImsingerDateInfoDo record);

    int updateByPrimaryKey(ImsingerDateInfoDo record);
}