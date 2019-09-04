package com.hndl.cn.dao.mq.mapper;

import com.hndl.cn.dao.mq.bean.MqMessageInfo;
import com.hndl.cn.dao.mq.bean.MqMessageInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MqMessageInfoDAO {
    long countByExample(MqMessageInfoExample example);

    int deleteByExample(MqMessageInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MqMessageInfo record);

    int insertSelective(MqMessageInfo record);

    List<MqMessageInfo> selectByExample(MqMessageInfoExample example);

    MqMessageInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MqMessageInfo record, @Param("example") MqMessageInfoExample example);

    int updateByExample(@Param("record") MqMessageInfo record, @Param("example") MqMessageInfoExample example);

    int updateByPrimaryKeySelective(MqMessageInfo record);

    int updateByPrimaryKey(MqMessageInfo record);
}