package com.hndl.cn.dao.system.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * t_order_info
 * @author 
 */
public class TOrderInfoDo implements Serializable {
    /**
     * 订单编号
     */
    private String orderid;

    /**
     * 订单类型（0：单次配送/1：多次配送）
     */
    private Integer ordertype;

    /**
     * 下单日期
     */
    private Date orderdate;

    /**
     * 订单金额
     */
    private Double totalmoney;

    /**
     * 实收金额
     */
    private Double realmoney;

    /**
     * 收货人（用户ID）
     */
    private Long userid;

    /**
     * 备注信息
     */
    private String description;

    /**
     * 支付方式（0：货到付款、1：预支付）
     */
    private Integer paytype;

    /**
     * 付款状态（0：未支付/1：已支付）
     */
    private Integer paystate;

    /**
     * 发货状态（0：待发货、1：发货中、2：已发货、3：已冻结）
     */
    private Integer sendstate;

    /**
     * 创建人
     */
    private Integer creatorid;

    /**
     * 创建时间
     */
    private Date createdate;

    /**
     * 更新时间
     */
    private Date updatedate;

    /**
     * 结束时间
     */
    private Date enddate;

    /**
     * 是否删除（0：否；1：是）
     */
    private Integer isdelete;

    /**
     * 分仓
     */
    private String other1;

    /**
     * 是否冻结
     */
    private String other2;

    /**
     * 记录数
     */
    private String other3;

    /**
     * 商品总数
     */
    private String other4;

    private String other5;

    private String other6;

    private static final long serialVersionUID = 1L;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Double getRealmoney() {
        return realmoney;
    }

    public void setRealmoney(Double realmoney) {
        this.realmoney = realmoney;
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

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public Integer getPaystate() {
        return paystate;
    }

    public void setPaystate(Integer paystate) {
        this.paystate = paystate;
    }

    public Integer getSendstate() {
        return sendstate;
    }

    public void setSendstate(Integer sendstate) {
        this.sendstate = sendstate;
    }

    public Integer getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(Integer creatorid) {
        this.creatorid = creatorid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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
        TOrderInfoDo other = (TOrderInfoDo) that;
        return (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()))
            && (this.getOrdertype() == null ? other.getOrdertype() == null : this.getOrdertype().equals(other.getOrdertype()))
            && (this.getOrderdate() == null ? other.getOrderdate() == null : this.getOrderdate().equals(other.getOrderdate()))
            && (this.getTotalmoney() == null ? other.getTotalmoney() == null : this.getTotalmoney().equals(other.getTotalmoney()))
            && (this.getRealmoney() == null ? other.getRealmoney() == null : this.getRealmoney().equals(other.getRealmoney()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getPaytype() == null ? other.getPaytype() == null : this.getPaytype().equals(other.getPaytype()))
            && (this.getPaystate() == null ? other.getPaystate() == null : this.getPaystate().equals(other.getPaystate()))
            && (this.getSendstate() == null ? other.getSendstate() == null : this.getSendstate().equals(other.getSendstate()))
            && (this.getCreatorid() == null ? other.getCreatorid() == null : this.getCreatorid().equals(other.getCreatorid()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getUpdatedate() == null ? other.getUpdatedate() == null : this.getUpdatedate().equals(other.getUpdatedate()))
            && (this.getEnddate() == null ? other.getEnddate() == null : this.getEnddate().equals(other.getEnddate()))
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
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        result = prime * result + ((getOrdertype() == null) ? 0 : getOrdertype().hashCode());
        result = prime * result + ((getOrderdate() == null) ? 0 : getOrderdate().hashCode());
        result = prime * result + ((getTotalmoney() == null) ? 0 : getTotalmoney().hashCode());
        result = prime * result + ((getRealmoney() == null) ? 0 : getRealmoney().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getPaytype() == null) ? 0 : getPaytype().hashCode());
        result = prime * result + ((getPaystate() == null) ? 0 : getPaystate().hashCode());
        result = prime * result + ((getSendstate() == null) ? 0 : getSendstate().hashCode());
        result = prime * result + ((getCreatorid() == null) ? 0 : getCreatorid().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getUpdatedate() == null) ? 0 : getUpdatedate().hashCode());
        result = prime * result + ((getEnddate() == null) ? 0 : getEnddate().hashCode());
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
        sb.append(", orderid=").append(orderid);
        sb.append(", ordertype=").append(ordertype);
        sb.append(", orderdate=").append(orderdate);
        sb.append(", totalmoney=").append(totalmoney);
        sb.append(", realmoney=").append(realmoney);
        sb.append(", userid=").append(userid);
        sb.append(", description=").append(description);
        sb.append(", paytype=").append(paytype);
        sb.append(", paystate=").append(paystate);
        sb.append(", sendstate=").append(sendstate);
        sb.append(", creatorid=").append(creatorid);
        sb.append(", createdate=").append(createdate);
        sb.append(", updatedate=").append(updatedate);
        sb.append(", enddate=").append(enddate);
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