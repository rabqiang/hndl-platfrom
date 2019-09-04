package com.hndl.cn.dao.president.mapper;

import com.hndl.cn.dao.president.bean.PresidentFinalAddDoudouDo;
import com.hndl.cn.dao.president.bean.PresidentFinalAddDoudouDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PresidentFinalAddDoudouDoMapper {
    long countByExample(PresidentFinalAddDoudouDoExample example);

    int deleteByExample(PresidentFinalAddDoudouDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PresidentFinalAddDoudouDo record);

    int insertSelective(PresidentFinalAddDoudouDo record);

    List<PresidentFinalAddDoudouDo> selectByExample(PresidentFinalAddDoudouDoExample example);

    PresidentFinalAddDoudouDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PresidentFinalAddDoudouDo record, @Param("example") PresidentFinalAddDoudouDoExample example);

    int updateByExample(@Param("record") PresidentFinalAddDoudouDo record, @Param("example") PresidentFinalAddDoudouDoExample example);

    int updateByPrimaryKeySelective(PresidentFinalAddDoudouDo record);

    int updateByPrimaryKey(PresidentFinalAddDoudouDo record);
}