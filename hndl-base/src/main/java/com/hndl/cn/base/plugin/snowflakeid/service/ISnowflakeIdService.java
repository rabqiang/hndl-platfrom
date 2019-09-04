package com.hndl.cn.base.plugin.snowflakeid.service;

/**
 * <pre>
 *  
 *
 * 【标题】: 使用Twitter_Snowflake产生全局ID
 * 【描述】: 
 * 【版权】: 润投科技
 * 【作者】: 赵俊凯
 * 【时间】: 2017年7月3日 上午10:00:21
 * </pre>
 */
public interface ISnowflakeIdService {

    /**
     * 下一个全局ID-普通资讯 1:文章类型资讯
     * @return
     */
    long nextUserId();


    /**
     * 下一个全局ID-普通资讯 1:订单id
     * @return
     */
    long nextOrderId(Long dataId);

    /**
     * 下一个Callid
     * @return
     */
    long nextCallId();


    /**
     * 下一个评论id
     * @return
     */
    long nextCommentId();


    /**
     * 下一个文件
     * @return
     */
    long nextFileId();


    /**
     * 下一个用户消息ID
     * @return
     */
    long nextUserMessageId();

    /**
     * 下一个用户助力ID
     * @return
     */
    long nextHelpWelfareId();



}
