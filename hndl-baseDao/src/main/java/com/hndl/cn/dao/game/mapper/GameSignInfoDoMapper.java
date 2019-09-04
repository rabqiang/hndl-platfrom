package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameSignInfoDo;
import com.hndl.cn.dao.game.bean.GameSignInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameSignInfoDoMapper {
    long countByExample(GameSignInfoDoExample example);

    int deleteByExample(GameSignInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameSignInfoDo record);

    int insertSelective(GameSignInfoDo record);

    List<GameSignInfoDo> selectByExample(GameSignInfoDoExample example);

    GameSignInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameSignInfoDo record, @Param("example") GameSignInfoDoExample example);

    int updateByExample(@Param("record") GameSignInfoDo record, @Param("example") GameSignInfoDoExample example);

    int updateByPrimaryKeySelective(GameSignInfoDo record);

    int updateByPrimaryKey(GameSignInfoDo record);
}