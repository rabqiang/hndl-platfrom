package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonUserInfoDoMapper {
    long countByExample(CommonUserInfoDoExample example);

    int deleteByExample(CommonUserInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonUserInfoDo record);

    int insertSelective(CommonUserInfoDo record);

    List<CommonUserInfoDo> selectByExample(CommonUserInfoDoExample example);

    CommonUserInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonUserInfoDo record, @Param("example") CommonUserInfoDoExample example);

    int updateByExample(@Param("record") CommonUserInfoDo record, @Param("example") CommonUserInfoDoExample example);

    int updateByPrimaryKeySelective(CommonUserInfoDo record);

    int updateByPrimaryKey(CommonUserInfoDo record);

    int increaseCoinByUserUinId(@Param("userUinId") Long userUinId,@Param("coin")Double coin);

    int minusCoinByUserUinId(@Param("userUinId") Long userUinId,@Param("coin")Double coin);


}