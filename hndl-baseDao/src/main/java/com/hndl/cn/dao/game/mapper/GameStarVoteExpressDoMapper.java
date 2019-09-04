package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameStarVoteExpressDo;
import com.hndl.cn.dao.game.bean.GameStarVoteExpressDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameStarVoteExpressDoMapper {
    long countByExample(GameStarVoteExpressDoExample example);

    int deleteByExample(GameStarVoteExpressDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameStarVoteExpressDo record);

    int insertSelective(GameStarVoteExpressDo record);

    List<GameStarVoteExpressDo> selectByExample(GameStarVoteExpressDoExample example);

    GameStarVoteExpressDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameStarVoteExpressDo record, @Param("example") GameStarVoteExpressDoExample example);

    int updateByExample(@Param("record") GameStarVoteExpressDo record, @Param("example") GameStarVoteExpressDoExample example);

    int updateByPrimaryKeySelective(GameStarVoteExpressDo record);

    int updateByPrimaryKey(GameStarVoteExpressDo record);
}