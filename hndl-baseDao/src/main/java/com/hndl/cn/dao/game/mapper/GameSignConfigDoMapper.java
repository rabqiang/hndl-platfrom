package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameSignConfigDo;
import com.hndl.cn.dao.game.bean.GameSignConfigDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameSignConfigDoMapper {
    long countByExample(GameSignConfigDoExample example);

    int deleteByExample(GameSignConfigDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameSignConfigDo record);

    int insertSelective(GameSignConfigDo record);

    List<GameSignConfigDo> selectByExample(GameSignConfigDoExample example);

    GameSignConfigDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameSignConfigDo record, @Param("example") GameSignConfigDoExample example);

    int updateByExample(@Param("record") GameSignConfigDo record, @Param("example") GameSignConfigDoExample example);

    int updateByPrimaryKeySelective(GameSignConfigDo record);

    int updateByPrimaryKey(GameSignConfigDo record);
}