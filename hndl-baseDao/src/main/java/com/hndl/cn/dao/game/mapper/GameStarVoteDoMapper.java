package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameStarVoteDo;
import com.hndl.cn.dao.game.bean.GameStarVoteDoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameStarVoteDoMapper {
    long countByExample(GameStarVoteDoExample example);

    int deleteByExample(GameStarVoteDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameStarVoteDo record);

    int insertSelective(GameStarVoteDo record);

    List<GameStarVoteDo> selectByExample(GameStarVoteDoExample example);

    GameStarVoteDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameStarVoteDo record, @Param("example") GameStarVoteDoExample example);

    int updateByExample(@Param("record") GameStarVoteDo record, @Param("example") GameStarVoteDoExample example);

    int updateByPrimaryKeySelective(GameStarVoteDo record);

    int updateByPrimaryKey(GameStarVoteDo record);


    void insertAndGetId(GameStarVoteDo record);
}