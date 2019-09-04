package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemNoticePersonHomeDo;
import com.hndl.cn.dao.system.bean.SystemNoticePersonHomeDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemNoticePersonHomeDoMapper {
    long countByExample(SystemNoticePersonHomeDoExample example);

    int deleteByExample(SystemNoticePersonHomeDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemNoticePersonHomeDo record);

    int insertSelective(SystemNoticePersonHomeDo record);

    List<SystemNoticePersonHomeDo> selectByExample(SystemNoticePersonHomeDoExample example);

    SystemNoticePersonHomeDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemNoticePersonHomeDo record, @Param("example") SystemNoticePersonHomeDoExample example);

    int updateByExample(@Param("record") SystemNoticePersonHomeDo record, @Param("example") SystemNoticePersonHomeDoExample example);

    int updateByPrimaryKeySelective(SystemNoticePersonHomeDo record);

    int updateByPrimaryKey(SystemNoticePersonHomeDo record);
}