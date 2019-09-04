package com.hndl.cn.dao.system.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * t_order_send
 * @author 
 */
public class TOrderSendDo implements Serializable {
    private String id;

    /**
     * 订单编号
     */
    private String orderid;

    /**
     * 送货日期
     */
    private Date senddate;

    /**
     * 商品编号
     */
    private String goodscode;

    /**
     * 商品数量
     */
    private Long number;

    /**
     * 收货人（用户ID）
     */
    private Long userid;

    /**
     * 备注信息
     */
    private String description;

    /**
     * 是否完成（0：否；1：是）
     */
    private Integer isfinish;

    /**
     * 完成时间
     */
    private Date finishdate;

    /**
     * 是否删除（0：否；1：是）
     */
    private Integer isdelete;

    private String other1;

    private String other2;

    private String other3;

    private String other4;

    private String other5;

    private String other6;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    public String getGoodscode() {
        return goodscode;
    }

    public void setGoodscode(String goodscode) {
        this.goodscode = goodscode;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsfinish() {
        return isfinish;
    }

    public void setIsfinish(Integer isfinish) {
        this.isfinish = isfinish;
    }

    public Date getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3;
    }

    public String getOther4() {
        return other4;
    }

    public void setOther4(String other4) {
        this.other4 = other4;
    }

    public String getOther5() {
        return other5;
    }

    public void setOther5(String other5) {
        this.other5 = other5;
    }

    public String getOther6() {
        return other6;
    }

    public void setOther6(String other6) {
        this.other6 = other6;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TOrderSendDo other = (TOrderSendDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()))
            && (this.getSenddate() == null ? other.getSenddate() == null : this.getSenddate().equals(other.getSenddate()))
            && (this.getGoodscode() == null ? other.getGoodscode() == null : this.getGoodscode().equals(other.getGoodscode()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getIsfinish() == null ? other.getIsfinish() == null : this.getIsfinish().equals(other.getIsfinish()))
            && (this.getFinishdate() == null ? other.getFinishdate() == null : this.getFinishdate().equals(other.getFinishdate()))
            && (this.getIsdelete() == null ? other.getIsdelete() == null : this.getIsdelete().equals(other.getIsdelete()))
            && (this.getOther1() == null ? other.getOther1() == null : this.getOther1().equals(other.getOther1()))
            && (this.getOther2() == null ? other.getOther2() == null : this.getOther2().equals(other.getOther2()))
            && (this.getOther3() == null ? other.getOther3() == null : this.getOther3().equals(other.getOther3()))
            && (this.getOther4() == null ? other.getOther4() == null : this.getOther4().equals(other.getOther4()))
            && (this.getOther5() == null ? other.getOther5() == null : this.getOther5().equals(other.getOther5()))
            && (this.getOther6() == null ? other.getOther6() == null : this.getOther6().equals(other.getOther6()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        result = prime * result + ((getSenddate() == null) ? 0 : getSenddate().hashCode());
        result = prime * result + ((getGoodscode() == null) ? 0 : getGoodscode().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getIsfinish() == null) ? 0 : getIsfinish().hashCode());
        result = prime * result + ((getFinishdate() == null) ? 0 : getFinishdate().hashCode());
        result = prime * result + ((getIsdelete() == null) ? 0 : getIsdelete().hashCode());
        result = prime * result + ((getOther1() == null) ? 0 : getOther1().hashCode());
        result = prime * result + ((getOther2() == null) ? 0 : getOther2().hashCode());
        result = prime * result + ((getOther3() == null) ? 0 : getOther3().hashCode());
        result = prime * result + ((getOther4() == null) ? 0 : getOther4().hashCode());
        result = prime * result + ((getOther5() == null) ? 0 : getOther5().hashCode());
        result = prime * result + ((getOther6() == null) ? 0 : getOther6().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderid=").append(orderid);
        sb.append(", senddate=").append(senddate);
        sb.append(", goodscode=").append(goodscode);
        sb.append(", number=").append(number);
        sb.append(", userid=").append(userid);
        sb.append(", description=").append(description);
        sb.append(", isfinish=").append(isfinish);
        sb.append(", finishdate=").append(finishdate);
        sb.append(", isdelete=").append(isdelete);
        sb.append(", other1=").append(other1);
        sb.append(", other2=").append(other2);
        sb.append(", other3=").append(other3);
        sb.append(", other4=").append(other4);
        sb.append(", other5=").append(other5);
        sb.append(", other6=").append(other6);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}