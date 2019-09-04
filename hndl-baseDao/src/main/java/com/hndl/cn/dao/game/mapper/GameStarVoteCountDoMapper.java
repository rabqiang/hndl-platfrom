package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameStarVoteCountDo;
import com.hndl.cn.dao.game.bean.GameStarVoteCountDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameStarVoteCountDoMapper {
    long countByExample(GameStarVoteCountDoExample example);

    int deleteByExample(GameStarVoteCountDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameStarVoteCountDo record);

    int insertSelective(GameStarVoteCountDo record);

    List<GameStarVoteCountDo> selectByExample(GameStarVoteCountDoExample example);

    GameStarVoteCountDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameStarVoteCountDo record, @Param("example") GameStarVoteCountDoExample example);

    int updateByExample(@Param("record") GameStarVoteCountDo record, @Param("example") GameStarVoteCountDoExample example);

    int updateByPrimaryKeySelective(GameStarVoteCountDo record);

    int updateByPrimaryKey(GameStarVoteCountDo record);
}