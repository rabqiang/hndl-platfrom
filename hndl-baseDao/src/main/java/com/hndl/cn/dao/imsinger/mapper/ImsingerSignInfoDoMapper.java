package com.hndl.cn.dao.imsinger.mapper;

import com.hndl.cn.dao.imsinger.bean.ImsingerSignInfoDo;
import com.hndl.cn.dao.imsinger.bean.ImsingerSignInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImsingerSignInfoDoMapper {
    long countByExample(ImsingerSignInfoDoExample example);

    int deleteByExample(ImsingerSignInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsingerSignInfoDo record);

    int insertSelective(ImsingerSignInfoDo record);

    List<ImsingerSignInfoDo> selectByExample(ImsingerSignInfoDoExample example);

    ImsingerSignInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsingerSignInfoDo record, @Param("example") ImsingerSignInfoDoExample example);

    int updateByExample(@Param("record") ImsingerSignInfoDo record, @Param("example") ImsingerSignInfoDoExample example);

    int updateByPrimaryKeySelective(ImsingerSignInfoDo record);

    int updateByPrimaryKey(ImsingerSignInfoDo record);
}