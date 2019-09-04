package com.hndl.cn.dao.newyear.mapper;

import com.hndl.cn.dao.newyear.bean.NewyearTopsongInfoDo;
import com.hndl.cn.dao.newyear.bean.NewyearTopsongInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewyearTopsongInfoDoMapper {
    long countByExample(NewyearTopsongInfoDoExample example);

    int deleteByExample(NewyearTopsongInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NewyearTopsongInfoDo record);

    int insertSelective(NewyearTopsongInfoDo record);

    List<NewyearTopsongInfoDo> selectByExample(NewyearTopsongInfoDoExample example);

    NewyearTopsongInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NewyearTopsongInfoDo record, @Param("example") NewyearTopsongInfoDoExample example);

    int updateByExample(@Param("record") NewyearTopsongInfoDo record, @Param("example") NewyearTopsongInfoDoExample example);

    int updateByPrimaryKeySelective(NewyearTopsongInfoDo record);

    int updateByPrimaryKey(NewyearTopsongInfoDo record);
}