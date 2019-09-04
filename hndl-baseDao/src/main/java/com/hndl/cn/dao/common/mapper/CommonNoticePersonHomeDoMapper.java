package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonNoticePersonHomeDo;
import com.hndl.cn.dao.common.bean.CommonNoticePersonHomeDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonNoticePersonHomeDoMapper {
    long countByExample(CommonNoticePersonHomeDoExample example);

    int deleteByExample(CommonNoticePersonHomeDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonNoticePersonHomeDo record);

    int insertSelective(CommonNoticePersonHomeDo record);

    List<CommonNoticePersonHomeDo> selectByExample(CommonNoticePersonHomeDoExample example);

    CommonNoticePersonHomeDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonNoticePersonHomeDo record, @Param("example") CommonNoticePersonHomeDoExample example);

    int updateByExample(@Param("record") CommonNoticePersonHomeDo record, @Param("example") CommonNoticePersonHomeDoExample example);

    int updateByPrimaryKeySelective(CommonNoticePersonHomeDo record);

    int updateByPrimaryKey(CommonNoticePersonHomeDo record);
}