package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameQuestionOperateRecordDo;
import com.hndl.cn.dao.game.bean.GameQuestionOperateRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameQuestionOperateRecordDoMapper {
    long countByExample(GameQuestionOperateRecordDoExample example);

    int deleteByExample(GameQuestionOperateRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameQuestionOperateRecordDo record);

    int insertSelective(GameQuestionOperateRecordDo record);

    List<GameQuestionOperateRecordDo> selectByExample(GameQuestionOperateRecordDoExample example);

    GameQuestionOperateRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameQuestionOperateRecordDo record, @Param("example") GameQuestionOperateRecordDoExample example);

    int updateByExample(@Param("record") GameQuestionOperateRecordDo record, @Param("example") GameQuestionOperateRecordDoExample example);

    int updateByPrimaryKeySelective(GameQuestionOperateRecordDo record);

    int updateByPrimaryKey(GameQuestionOperateRecordDo record);
}