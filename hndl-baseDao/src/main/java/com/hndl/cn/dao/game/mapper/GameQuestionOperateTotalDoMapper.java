package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameQuestionOperateTotalDo;
import com.hndl.cn.dao.game.bean.GameQuestionOperateTotalDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameQuestionOperateTotalDoMapper {
    long countByExample(GameQuestionOperateTotalDoExample example);

    int deleteByExample(GameQuestionOperateTotalDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameQuestionOperateTotalDo record);

    int insertSelective(GameQuestionOperateTotalDo record);

    List<GameQuestionOperateTotalDo> selectByExample(GameQuestionOperateTotalDoExample example);

    GameQuestionOperateTotalDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameQuestionOperateTotalDo record, @Param("example") GameQuestionOperateTotalDoExample example);

    int updateByExample(@Param("record") GameQuestionOperateTotalDo record, @Param("example") GameQuestionOperateTotalDoExample example);

    int updateByPrimaryKeySelective(GameQuestionOperateTotalDo record);

    int updateByPrimaryKey(GameQuestionOperateTotalDo record);
}