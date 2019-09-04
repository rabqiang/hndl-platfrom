package com.hndl.cn.dao.imsinger.mapper;

import com.hndl.cn.dao.imsinger.bean.ImsingerSignRuleDo;
import com.hndl.cn.dao.imsinger.bean.ImsingerSignRuleDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImsingerSignRuleDoMapper {
    long countByExample(ImsingerSignRuleDoExample example);

    int deleteByExample(ImsingerSignRuleDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsingerSignRuleDo record);

    int insertSelective(ImsingerSignRuleDo record);

    List<ImsingerSignRuleDo> selectByExample(ImsingerSignRuleDoExample example);

    ImsingerSignRuleDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsingerSignRuleDo record, @Param("example") ImsingerSignRuleDoExample example);

    int updateByExample(@Param("record") ImsingerSignRuleDo record, @Param("example") ImsingerSignRuleDoExample example);

    int updateByPrimaryKeySelective(ImsingerSignRuleDo record);

    int updateByPrimaryKey(ImsingerSignRuleDo record);
}