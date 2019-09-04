package com.hndl.cn.dao.game.mapper;

import com.hndl.cn.dao.game.bean.GameStarPhotoDo;
import com.hndl.cn.dao.game.bean.GameStarPhotoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameStarPhotoDoMapper {
    long countByExample(GameStarPhotoDoExample example);

    int deleteByExample(GameStarPhotoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameStarPhotoDo record);

    int insertSelective(GameStarPhotoDo record);

    List<GameStarPhotoDo> selectByExample(GameStarPhotoDoExample example);

    GameStarPhotoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameStarPhotoDo record, @Param("example") GameStarPhotoDoExample example);

    int updateByExample(@Param("record") GameStarPhotoDo record, @Param("example") GameStarPhotoDoExample example);

    int updateByPrimaryKeySelective(GameStarPhotoDo record);

    int updateByPrimaryKey(GameStarPhotoDo record);
}