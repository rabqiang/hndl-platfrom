package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameNewyearAnswerDo;
import com.hndl.cn.dao.game.bean.GameNewyearAnswerDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameNewyearAnswerDoMapper {
    long countByExample(GameNewyearAnswerDoExample example);

    int deleteByExample(GameNewyearAnswerDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameNewyearAnswerDo record);

    int insertSelective(GameNewyearAnswerDo record);

    List<GameNewyearAnswerDo> selectByExample(GameNewyearAnswerDoExample example);

    GameNewyearAnswerDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameNewyearAnswerDo record, @Param("example") GameNewyearAnswerDoExample example);

    int updateByExample(@Param("record") GameNewyearAnswerDo record, @Param("example") GameNewyearAnswerDoExample example);

    int updateByPrimaryKeySelective(GameNewyearAnswerDo record);

    int updateByPrimaryKey(GameNewyearAnswerDo record);
}