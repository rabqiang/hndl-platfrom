package com.hndl.cn.dao.newyear.mapper;

import com.hndl.cn.dao.newyear.bean.NewyearTopsongRecordDo;
import com.hndl.cn.dao.newyear.bean.NewyearTopsongRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewyearTopsongRecordDoMapper {
    long countByExample(NewyearTopsongRecordDoExample example);

    int deleteByExample(NewyearTopsongRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NewyearTopsongRecordDo record);

    int insertSelective(NewyearTopsongRecordDo record);

    List<NewyearTopsongRecordDo> selectByExample(NewyearTopsongRecordDoExample example);

    NewyearTopsongRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NewyearTopsongRecordDo record, @Param("example") NewyearTopsongRecordDoExample example);

    int updateByExample(@Param("record") NewyearTopsongRecordDo record, @Param("example") NewyearTopsongRecordDoExample example);

    int updateByPrimaryKeySelective(NewyearTopsongRecordDo record);

    int updateByPrimaryKey(NewyearTopsongRecordDo record);
}