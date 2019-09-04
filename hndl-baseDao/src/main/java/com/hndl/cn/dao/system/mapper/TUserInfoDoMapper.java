package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TUserInfoDo;
import com.hndl.cn.dao.system.bean.TUserInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserInfoDoMapper {
    long countByExample(TUserInfoDoExample example);

    int deleteByExample(TUserInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TUserInfoDo record);

    int insertSelective(TUserInfoDo record);

    List<TUserInfoDo> selectByExample(TUserInfoDoExample example);

    TUserInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TUserInfoDo record, @Param("example") TUserInfoDoExample example);

    int updateByExample(@Param("record") TUserInfoDo record, @Param("example") TUserInfoDoExample example);

    int updateByPrimaryKeySelective(TUserInfoDo record);

    int updateByPrimaryKey(TUserInfoDo record);
}