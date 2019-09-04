package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameChineseEggDo;
import com.hndl.cn.dao.game.bean.GameChineseEggDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameChineseEggDoMapper {
    long countByExample(GameChineseEggDoExample example);

    int deleteByExample(GameChineseEggDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameChineseEggDo record);

    int insertSelective(GameChineseEggDo record);

    List<GameChineseEggDo> selectByExample(GameChineseEggDoExample example);

    GameChineseEggDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameChineseEggDo record, @Param("example") GameChineseEggDoExample example);

    int updateByExample(@Param("record") GameChineseEggDo record, @Param("example") GameChineseEggDoExample example);

    int updateByPrimaryKeySelective(GameChineseEggDo record);

    int updateByPrimaryKey(GameChineseEggDo record);
}