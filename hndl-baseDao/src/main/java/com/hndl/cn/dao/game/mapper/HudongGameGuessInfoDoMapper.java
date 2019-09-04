package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.HudongGameGuessInfoDo;
import com.hndl.cn.dao.game.bean.HudongGameGuessInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HudongGameGuessInfoDoMapper {
    long countByExample(HudongGameGuessInfoDoExample example);

    int deleteByExample(HudongGameGuessInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HudongGameGuessInfoDo record);

    int insertSelective(HudongGameGuessInfoDo record);

    List<HudongGameGuessInfoDo> selectByExample(HudongGameGuessInfoDoExample example);

    HudongGameGuessInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HudongGameGuessInfoDo record, @Param("example") HudongGameGuessInfoDoExample example);

    int updateByExample(@Param("record") HudongGameGuessInfoDo record, @Param("example") HudongGameGuessInfoDoExample example);

    int updateByPrimaryKeySelective(HudongGameGuessInfoDo record);

    int updateByPrimaryKey(HudongGameGuessInfoDo record);
}