package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameQuestionThemeRelationDo;
import com.hndl.cn.dao.game.bean.GameQuestionThemeRelationDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameQuestionThemeRelationDoMapper {
    long countByExample(GameQuestionThemeRelationDoExample example);

    int deleteByExample(GameQuestionThemeRelationDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameQuestionThemeRelationDo record);

    int insertSelective(GameQuestionThemeRelationDo record);

    List<GameQuestionThemeRelationDo> selectByExample(GameQuestionThemeRelationDoExample example);

    GameQuestionThemeRelationDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameQuestionThemeRelationDo record, @Param("example") GameQuestionThemeRelationDoExample example);

    int updateByExample(@Param("record") GameQuestionThemeRelationDo record, @Param("example") GameQuestionThemeRelationDoExample example);

    int updateByPrimaryKeySelective(GameQuestionThemeRelationDo record);

    int updateByPrimaryKey(GameQuestionThemeRelationDo record);
}