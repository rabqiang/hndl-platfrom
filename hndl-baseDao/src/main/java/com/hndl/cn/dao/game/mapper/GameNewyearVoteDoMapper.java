package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameNewyearVoteDo;
import com.hndl.cn.dao.game.bean.GameNewyearVoteDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameNewyearVoteDoMapper {
    long countByExample(GameNewyearVoteDoExample example);

    int deleteByExample(GameNewyearVoteDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameNewyearVoteDo record);

    int insertSelective(GameNewyearVoteDo record);

    List<GameNewyearVoteDo> selectByExample(GameNewyearVoteDoExample example);

    GameNewyearVoteDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameNewyearVoteDo record, @Param("example") GameNewyearVoteDoExample example);

    int updateByExample(@Param("record") GameNewyearVoteDo record, @Param("example") GameNewyearVoteDoExample example);

    int updateByPrimaryKeySelective(GameNewyearVoteDo record);

    int updateByPrimaryKey(GameNewyearVoteDo record);
}