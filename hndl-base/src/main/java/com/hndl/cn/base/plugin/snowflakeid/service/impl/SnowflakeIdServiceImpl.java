package com.hndl.cn.base.plugin.snowflakeid.service.impl;


import com.hndl.cn.base.plugin.snowflakeid.SnowflakeIdFactory;
import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.properties.BasePropertiesUtil;

/**
 * <pre>
 *  
 *
 * 【标题】: 使用Twitter_Snowflake产生全局ID
 * 【描述】: 
 *   注： 每种业务要有自己的ID产生方式,以防止ID重复
 * 【版权】: 润投科技
 * 【作者】: 唐宋  
 * 【时间】: 2017年7月3日 上午10:10:13
 * </pre>
 */
public class SnowflakeIdServiceImpl implements ISnowflakeIdService {


    public static final ISnowflakeIdService INSTANCE = new SnowflakeIdServiceImpl();

    // 普通资讯-全局ID产生对象
    private static volatile SnowflakeIdFactory userSnowflakeId = null;

    private static volatile SnowflakeIdFactory orderSnowflakeId = null;

    private static volatile SnowflakeIdFactory callSnowflakeId = null;

    private static volatile SnowflakeIdFactory commentSnowflakeId = null;

    private static volatile SnowflakeIdFactory fileSnowflakeId = null;

    private static volatile SnowflakeIdFactory userMessageSnowflakeId = null;

    private static volatile SnowflakeIdFactory helpWelfareId = null;

    private SnowflakeIdServiceImpl(){

    }


    @Override
    public long nextUserId() {
        if (userSnowflakeId == null) {
            synchronized (this) {
                if(userSnowflakeId == null){
                    userSnowflakeId = new SnowflakeIdFactory(Long.valueOf(BasePropertiesUtil.getPropertyValue("workerId")),
                            Long.valueOf(BasePropertiesUtil.getPropertyValue("datacenterId")));

                }
            }
        }
        return userSnowflakeId.nextId();
    }



    @Override
    public long nextOrderId(Long dataId) {
        if (orderSnowflakeId == null) {
            synchronized (this) {
                if(orderSnowflakeId == null){
                    orderSnowflakeId = new SnowflakeIdFactory(Long.valueOf(BasePropertiesUtil.getPropertyValue("workerId")),
                            dataId);
                }
            }
        }
        return orderSnowflakeId.nextId();
    }

    @Override
    public long nextCallId() {
        if (callSnowflakeId == null) {
            synchronized (this) {
                if(callSnowflakeId == null){
                    callSnowflakeId = new SnowflakeIdFactory(Long.valueOf(BasePropertiesUtil.getPropertyValue("workerId")),
                            Long.valueOf(BasePropertiesUtil.getPropertyValue("datacenterId")));
                }
            }
        }
        return callSnowflakeId.nextId();
    }

    @Override
    public long nextCommentId() {
        if (commentSnowflakeId == null) {
            synchronized (this) {
                if(commentSnowflakeId == null){
                    commentSnowflakeId = new SnowflakeIdFactory(Long.valueOf(BasePropertiesUtil.getPropertyValue("workerId")),
                            Long.valueOf(BasePropertiesUtil.getPropertyValue("datacenterId")));
                }
            }
        }
        return commentSnowflakeId.nextId();
    }

    @Override
    public long nextFileId() {
        if (fileSnowflakeId == null) {
            synchronized (this) {
                if(fileSnowflakeId == null){
                    fileSnowflakeId = new SnowflakeIdFactory(Long.valueOf(BasePropertiesUtil.getPropertyValue("workerId")),
                            Long.valueOf(BasePropertiesUtil.getPropertyValue("datacenterId")));
                }
            }
        }
        return fileSnowflakeId.nextId();
    }


    @Override
    public  long nextUserMessageId(){
        if (userMessageSnowflakeId==null){
            synchronized (this){
                if (userMessageSnowflakeId==null){
                    userMessageSnowflakeId= new SnowflakeIdFactory(Long.valueOf(BasePropertiesUtil.getPropertyValue("workerId")),
                            Long.valueOf(BasePropertiesUtil.getPropertyValue("datacenterId")));
                }
            }
        }
        return userMessageSnowflakeId.nextId();
    }

    @Override
    public long nextHelpWelfareId() {
        if (helpWelfareId==null){
            synchronized (this){
                if (helpWelfareId==null){
                    helpWelfareId= new SnowflakeIdFactory(Long.valueOf(BasePropertiesUtil.getPropertyValue("workerId")),
                            Long.valueOf(BasePropertiesUtil.getPropertyValue("datacenterId")));
                }
            }
        }
        return helpWelfareId.nextId();
    }


}
