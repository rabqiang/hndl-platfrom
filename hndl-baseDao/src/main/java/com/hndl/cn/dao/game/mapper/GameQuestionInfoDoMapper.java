package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameQuestionInfoDo;
import com.hndl.cn.dao.game.bean.GameQuestionInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameQuestionInfoDoMapper {
    long countByExample(GameQuestionInfoDoExample example);

    int deleteByExample(GameQuestionInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameQuestionInfoDo record);

    int insertSelective(GameQuestionInfoDo record);

    List<GameQuestionInfoDo> selectByExample(GameQuestionInfoDoExample example);

    GameQuestionInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameQuestionInfoDo record, @Param("example") GameQuestionInfoDoExample example);

    int updateByExample(@Param("record") GameQuestionInfoDo record, @Param("example") GameQuestionInfoDoExample example);

    int updateByPrimaryKeySelective(GameQuestionInfoDo record);

    int updateByPrimaryKey(GameQuestionInfoDo record);
}