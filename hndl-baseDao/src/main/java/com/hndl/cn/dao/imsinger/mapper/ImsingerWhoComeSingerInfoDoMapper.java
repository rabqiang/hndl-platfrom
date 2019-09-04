package com.hndl.cn.dao.imsinger.mapper;

import com.hndl.cn.dao.imsinger.bean.ImsingerWhoComeSingerInfoDo;
import com.hndl.cn.dao.imsinger.bean.ImsingerWhoComeSingerInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImsingerWhoComeSingerInfoDoMapper {
    long countByExample(ImsingerWhoComeSingerInfoDoExample example);

    int deleteByExample(ImsingerWhoComeSingerInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsingerWhoComeSingerInfoDo record);

    int insertSelective(ImsingerWhoComeSingerInfoDo record);

    List<ImsingerWhoComeSingerInfoDo> selectByExample(ImsingerWhoComeSingerInfoDoExample example);

    ImsingerWhoComeSingerInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsingerWhoComeSingerInfoDo record, @Param("example") ImsingerWhoComeSingerInfoDoExample example);

    int updateByExample(@Param("record") ImsingerWhoComeSingerInfoDo record, @Param("example") ImsingerWhoComeSingerInfoDoExample example);

    int updateByPrimaryKeySelective(ImsingerWhoComeSingerInfoDo record);

    int updateByPrimaryKey(ImsingerWhoComeSingerInfoDo record);
}