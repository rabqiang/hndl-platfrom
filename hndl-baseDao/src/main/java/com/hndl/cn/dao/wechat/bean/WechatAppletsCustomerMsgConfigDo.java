package com.hndl.cn.dao.wechat.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 曹加丽
 * @Description TODO  wechat_applets_customer_msg_config
 * @Date 2019/8/26 11:31
 * @Created by 湖南达联
 */
public class WechatAppletsCustomerMsgConfigDo implements Serializable {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 客户端消息
     */
    private String clientMsg;
    /**
     * 消息类型
     */
    private Integer clientMsgType;
    /**
     * 返回消息
     */
    private String responseMsg;
    /**
     * 返回消息类型
     */
    private Integer responseMsgType;
    /**
     * 创建人id
     */
    private Long createUserId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后修改人
     */
    private Long updateUserId;
    /**
     * 最后修改时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientMsg() {
        return clientMsg;
    }

    public void setClientMsg(String clientMsg) {
        this.clientMsg = clientMsg;
    }

    public Integer getClientMsgType() {
        return clientMsgType;
    }

    public void setClientMsgType(Integer clientMsgType) {
        this.clientMsgType = clientMsgType;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public Integer getResponseMsgType() {
        return responseMsgType;
    }

    public void setResponseMsgType(Integer responseMsgType) {
        this.responseMsgType = responseMsgType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }
    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null ) return  false;
        if (getClass() != that.getClass()) return false;
        WechatAppletsCustomerMsgConfigDo other = (WechatAppletsCustomerMsgConfigDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getClientMsg() == null ? other.getClientMsg() == null : this.getClientMsg().equals(other.getClientMsg()))
                && (this.getClientMsgType() == null ? other.getClientMsgType() == null : this.getClientMsgType().equals(other.getClientMsgType()))
                && (this.getResponseMsg() == null ? other.getResponseMsg() == null : this.getResponseMsg().equals(other.getResponseMsg()))
                && (this.getResponseMsgType() == null ? other.getResponseMsgType() == null : this.getResponseMsgType().equals(other.getResponseMsgType()))
                && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClientMsg() == null) ? 0 : getClientMsg().hashCode());
        result = prime * result + ((getClientMsgType() == null) ? 0 : getClientMsgType().hashCode());
        result = prime * result + ((getResponseMsg() == null) ? 0 : getResponseMsg().hashCode());
        result = prime * result + ((getResponseMsgType() == null) ? 0 : getResponseMsgType().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clientMsg=").append(clientMsg);
        sb.append(", clientMsgType=").append(clientMsgType);
        sb.append(", responseMsg=").append(responseMsg);
        sb.append(", responseMsgType=").append(responseMsgType);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
