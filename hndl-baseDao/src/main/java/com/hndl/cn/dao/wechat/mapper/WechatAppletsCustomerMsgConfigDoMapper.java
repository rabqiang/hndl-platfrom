package com.hndl.cn.dao.wechat.mapper;

import com.hndl.cn.dao.wechat.bean.WechatAppletsCustomerMsgConfigDo;
import com.hndl.cn.dao.wechat.bean.WechatAppletsCustomerMsgConfigDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface WechatAppletsCustomerMsgConfigDoMapper {
    long countByExample(WechatAppletsCustomerMsgConfigDoExample example);

    int deleteByExample(WechatAppletsCustomerMsgConfigDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WechatAppletsCustomerMsgConfigDo record);

    int insertSelective(WechatAppletsCustomerMsgConfigDo record);

    List<WechatAppletsCustomerMsgConfigDo> selectByExample(WechatAppletsCustomerMsgConfigDoExample example);

    WechatAppletsCustomerMsgConfigDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WechatAppletsCustomerMsgConfigDo record, @Param("example") WechatAppletsCustomerMsgConfigDoExample example);

    int updateByExample(@Param("record") WechatAppletsCustomerMsgConfigDo record, @Param("example") WechatAppletsCustomerMsgConfigDoExample example);

    int updateByPrimaryKeySelective(WechatAppletsCustomerMsgConfigDo record);

    int updateByPrimaryKey(WechatAppletsCustomerMsgConfigDo record);
}