package com.hndl.cn.mysql.manager.wechat.manager;

import com.hndl.cn.dao.wechat.bean.WechatAppletsCustomerMsgConfigDo;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/8/26 15:44
 * @Created by 湖南达联
 */
public interface WechatAppletsCustomerMsgConfigManager {


    /**
     * 查询消息
     *
     * @param msgType
     * @param content
     * @return
     */
    WechatAppletsCustomerMsgConfigDo findMsgByContent(Integer msgType, String content);

    /**
     * 增加消息
     * @param msgConfigDo
     */
    void inserWechatAppletsCustomerMsgConfig(WechatAppletsCustomerMsgConfigDo msgConfigDo);

    /**
     * 修改消息回复
     *
     * @param msgConfigDo
     */
    void updateWechatAppletesCustomerMsgConfigById(WechatAppletsCustomerMsgConfigDo msgConfigDo);

    /**
     * 删除消息
     *
     * @param id    消息id
     */
    void deleteWechatAppletesCustomerMsgById(Long id);

    /**
     * 查询所有消息
     *
     * @param msgType      用户发送的消息类型
     * @param createUserId 用户id
     * @param pangNo       页数
     * @param pageSize     每页大小
     * @return
     */
    List<WechatAppletsCustomerMsgConfigDo> findWechatAppletesCustomerMsgAll(Integer msgType, Long createUserId, Integer pangNo, Integer pageSize);
}
