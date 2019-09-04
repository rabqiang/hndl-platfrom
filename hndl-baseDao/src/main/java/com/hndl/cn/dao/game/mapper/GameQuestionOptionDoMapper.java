package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameQuestionOptionDo;
import com.hndl.cn.dao.game.bean.GameQuestionOptionDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameQuestionOptionDoMapper {
    long countByExample(GameQuestionOptionDoExample example);

    int deleteByExample(GameQuestionOptionDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameQuestionOptionDo record);

    int insertSelective(GameQuestionOptionDo record);

    List<GameQuestionOptionDo> selectByExample(GameQuestionOptionDoExample example);

    GameQuestionOptionDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameQuestionOptionDo record, @Param("example") GameQuestionOptionDoExample example);

    int updateByExample(@Param("record") GameQuestionOptionDo record, @Param("example") GameQuestionOptionDoExample example);

    int updateByPrimaryKeySelective(GameQuestionOptionDo record);

    int updateByPrimaryKey(GameQuestionOptionDo record);
}