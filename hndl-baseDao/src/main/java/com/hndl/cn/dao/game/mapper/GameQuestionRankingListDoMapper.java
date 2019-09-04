package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameQuestionRankingListDo;
import com.hndl.cn.dao.game.bean.GameQuestionRankingListDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameQuestionRankingListDoMapper {
    long countByExample(GameQuestionRankingListDoExample example);

    int deleteByExample(GameQuestionRankingListDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameQuestionRankingListDo record);

    int insertSelective(GameQuestionRankingListDo record);

    List<GameQuestionRankingListDo> selectByExample(GameQuestionRankingListDoExample example);

    GameQuestionRankingListDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameQuestionRankingListDo record, @Param("example") GameQuestionRankingListDoExample example);

    int updateByExample(@Param("record") GameQuestionRankingListDo record, @Param("example") GameQuestionRankingListDoExample example);

    int updateByPrimaryKeySelective(GameQuestionRankingListDo record);

    int updateByPrimaryKey(GameQuestionRankingListDo record);
}