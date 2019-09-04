package com.hndl.cn.dao.prize.mapper;

import com.hndl.cn.dao.prize.bean.LuckyTurntableInfoDo;
import com.hndl.cn.dao.prize.bean.LuckyTurntableInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LuckyTurntableInfoMapper {
    long countByExample(LuckyTurntableInfoDoExample example);

    int deleteByExample(LuckyTurntableInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LuckyTurntableInfoDo record);

    int insertSelective(LuckyTurntableInfoDo record);

    List<LuckyTurntableInfoDo> selectByExample(LuckyTurntableInfoDoExample example);

    LuckyTurntableInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LuckyTurntableInfoDo record, @Param("example") LuckyTurntableInfoDoExample example);

    int updateByExample(@Param("record") LuckyTurntableInfoDo record, @Param("example") LuckyTurntableInfoDoExample example);

    int updateByPrimaryKeySelective(LuckyTurntableInfoDo record);

    int updateByPrimaryKey(LuckyTurntableInfoDo record);
}