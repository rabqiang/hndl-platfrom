package com.hndl.cn.dao.newyear.mapper;

import com.hndl.cn.dao.newyear.bean.NewyearWishRecordDo;
import com.hndl.cn.dao.newyear.bean.NewyearWishRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewyearWishRecordDoMapper {
    long countByExample(NewyearWishRecordDoExample example);

    int deleteByExample(NewyearWishRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NewyearWishRecordDo record);

    int insertSelective(NewyearWishRecordDo record);

    List<NewyearWishRecordDo> selectByExample(NewyearWishRecordDoExample example);

    NewyearWishRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NewyearWishRecordDo record, @Param("example") NewyearWishRecordDoExample example);

    int updateByExample(@Param("record") NewyearWishRecordDo record, @Param("example") NewyearWishRecordDoExample example);

    int updateByPrimaryKeySelective(NewyearWishRecordDo record);

    int updateByPrimaryKey(NewyearWishRecordDo record);
}