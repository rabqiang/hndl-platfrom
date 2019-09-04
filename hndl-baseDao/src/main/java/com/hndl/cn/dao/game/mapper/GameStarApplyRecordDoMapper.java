package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameStarApplyRecordDo;
import com.hndl.cn.dao.game.bean.GameStarApplyRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameStarApplyRecordDoMapper {
    long countByExample(GameStarApplyRecordDoExample example);

    int deleteByExample(GameStarApplyRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameStarApplyRecordDo record);

    int insertSelective(GameStarApplyRecordDo record);

    List<GameStarApplyRecordDo> selectByExample(GameStarApplyRecordDoExample example);

    GameStarApplyRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameStarApplyRecordDo record, @Param("example") GameStarApplyRecordDoExample example);

    int updateByExample(@Param("record") GameStarApplyRecordDo record, @Param("example") GameStarApplyRecordDoExample example);

    int updateByPrimaryKeySelective(GameStarApplyRecordDo record);

    int updateByPrimaryKey(GameStarApplyRecordDo record);
}