package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameStarRecordDo;
import com.hndl.cn.dao.game.bean.GameStarRecordDoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameStarRecordDoMapper {
    long countByExample(GameStarRecordDoExample example);

    int deleteByExample(GameStarRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameStarRecordDo record);

    int insertSelective(GameStarRecordDo record);

    List<GameStarRecordDo> selectByExample(GameStarRecordDoExample example);

    GameStarRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameStarRecordDo record, @Param("example") GameStarRecordDoExample example);

    int updateByExample(@Param("record") GameStarRecordDo record, @Param("example") GameStarRecordDoExample example);

    int updateByPrimaryKeySelective(GameStarRecordDo record);

    int updateByPrimaryKey(GameStarRecordDo record);

    //查询未弹幕的记录
    int selectIsBarrageCount(Long starId);
    //修改已弹幕的记录
    int updateIsBarrage(Long starId);
}