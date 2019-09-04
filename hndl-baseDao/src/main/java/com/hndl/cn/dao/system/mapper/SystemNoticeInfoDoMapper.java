package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemNoticeInfoDo;
import com.hndl.cn.dao.system.bean.SystemNoticeInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemNoticeInfoDoMapper {
    long countByExample(SystemNoticeInfoDoExample example);

    int deleteByExample(SystemNoticeInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemNoticeInfoDo record);

    int insertSelective(SystemNoticeInfoDo record);

    List<SystemNoticeInfoDo> selectByExample(SystemNoticeInfoDoExample example);

    SystemNoticeInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemNoticeInfoDo record, @Param("example") SystemNoticeInfoDoExample example);

    int updateByExample(@Param("record") SystemNoticeInfoDo record, @Param("example") SystemNoticeInfoDoExample example);

    int updateByPrimaryKeySelective(SystemNoticeInfoDo record);

    int updateByPrimaryKey(SystemNoticeInfoDo record);
}