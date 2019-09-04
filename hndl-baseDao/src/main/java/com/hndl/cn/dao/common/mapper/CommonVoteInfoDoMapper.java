package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonVoteInfoDo;
import com.hndl.cn.dao.common.bean.CommonVoteInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonVoteInfoDoMapper {
    long countByExample(CommonVoteInfoDoExample example);

    int deleteByExample(CommonVoteInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonVoteInfoDo record);

    int insertSelective(CommonVoteInfoDo record);

    List<CommonVoteInfoDo> selectByExample(CommonVoteInfoDoExample example);

    CommonVoteInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonVoteInfoDo record, @Param("example") CommonVoteInfoDoExample example);

    int updateByExample(@Param("record") CommonVoteInfoDo record, @Param("example") CommonVoteInfoDoExample example);

    int updateByPrimaryKeySelective(CommonVoteInfoDo record);

    int updateByPrimaryKey(CommonVoteInfoDo record);
}