package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameQuestionThemeDo;
import com.hndl.cn.dao.game.bean.GameQuestionThemeDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameQuestionThemeDoMapper {
    long countByExample(GameQuestionThemeDoExample example);

    int deleteByExample(GameQuestionThemeDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameQuestionThemeDo record);

    int insertSelective(GameQuestionThemeDo record);

    List<GameQuestionThemeDo> selectByExample(GameQuestionThemeDoExample example);

    GameQuestionThemeDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameQuestionThemeDo record, @Param("example") GameQuestionThemeDoExample example);

    int updateByExample(@Param("record") GameQuestionThemeDo record, @Param("example") GameQuestionThemeDoExample example);

    int updateByPrimaryKeySelective(GameQuestionThemeDo record);

    int updateByPrimaryKey(GameQuestionThemeDo record);
}