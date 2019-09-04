package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.TestTableDo;
import com.hndl.cn.dao.common.bean.TestTableDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestTableDoMapper {
    long countByExample(TestTableDoExample example);

    int deleteByExample(TestTableDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestTableDo record);

    int insertSelective(TestTableDo record);

    List<TestTableDo> selectByExample(TestTableDoExample example);

    TestTableDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TestTableDo record, @Param("example") TestTableDoExample example);

    int updateByExample(@Param("record") TestTableDo record, @Param("example") TestTableDoExample example);

    int updateByPrimaryKeySelective(TestTableDo record);

    int updateByPrimaryKey(TestTableDo record);
}