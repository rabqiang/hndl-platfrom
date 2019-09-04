package com.hndl.cn.dao.welfare.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * welfare_org_info
 * @author 
 */
public class WelfareOrgInfoDo extends WelfareOrgInfoDoKey implements Serializable {
    /**
     * 是否被删除
     */
    private String isDeleted;

    /**
     * 创建人 (谁评论的)
     */
    private String createOperator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后更新人
     */
    private String lastOperator;

    /**
     * 最后更新时间
     */
    private Date lastModifyTime;

    /**
     * 申请类型
     */
    private String typeApply;

    /**
     * 明星id
     */
    private Long starIdApply;

    /**
     * 组织名称/企业名称
     */
    private String nameApply;

    /**
     * 品牌宣传
     */
    private String brandDescApply;

    /**
     * 负责人手机号码
     */
    private String phoneApply;

    /**
     * 参与说明
     */
    private String joinDescApply;

    /**
     * 配捐金额
     */
    private Double moneyApply;

    /**
     * 负责人
     */
    private String orgUser;

    /**
     * 组织的logo
     */
    private String orgLogoUrl;

    /**
     * 累计捐出的金额
     */
    private Double donateMoney;

    /**
     * 审核状态（ing  提交审核中/ok  审核成功/fail  审核失败/expired  已过期）
     */
    private String other1;

    /**
     * 审核之后的理由
     */
    private String other2;

    private String other3;

    private static final long serialVersionUID = 1L;

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateOperator() {
        return createOperator;
    }

    public void setCreateOperator(String createOperator) {
        this.createOperator = createOperator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastOperator() {
        return lastOperator;
    }

    public void setLastOperator(String lastOperator) {
        this.lastOperator = lastOperator;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getTypeApply() {
        return typeApply;
    }

    public void setTypeApply(String typeApply) {
        this.typeApply = typeApply;
    }

    public Long getStarIdApply() {
        return starIdApply;
    }

    public void setStarIdApply(Long starIdApply) {
        this.starIdApply = starIdApply;
    }

    public String getNameApply() {
        return nameApply;
    }

    public void setNameApply(String nameApply) {
        this.nameApply = nameApply;
    }

    public String getBrandDescApply() {
        return brandDescApply;
    }

    public void setBrandDescApply(String brandDescApply) {
        this.brandDescApply = brandDescApply;
    }

    public String getPhoneApply() {
        return phoneApply;
    }

    public void setPhoneApply(String phoneApply) {
        this.phoneApply = phoneApply;
    }

    public String getJoinDescApply() {
        return joinDescApply;
    }

    public void setJoinDescApply(String joinDescApply) {
        this.joinDescApply = joinDescApply;
    }

    public Double getMoneyApply() {
        return moneyApply;
    }

    public void setMoneyApply(Double moneyApply) {
        this.moneyApply = moneyApply;
    }

    public String getOrgUser() {
        return orgUser;
    }

    public void setOrgUser(String orgUser) {
        this.orgUser = orgUser;
    }

    public String getOrgLogoUrl() {
        return orgLogoUrl;
    }

    public void setOrgLogoUrl(String orgLogoUrl) {
        this.orgLogoUrl = orgLogoUrl;
    }

    public Double getDonateMoney() {
        return donateMoney;
    }

    public void setDonateMoney(Double donateMoney) {
        this.donateMoney = donateMoney;
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
        WelfareOrgInfoDo other = (WelfareOrgInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDonateHeart() == null ? other.getDonateHeart() == null : this.getDonateHeart().equals(other.getDonateHeart()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getTypeApply() == null ? other.getTypeApply() == null : this.getTypeApply().equals(other.getTypeApply()))
            && (this.getStarIdApply() == null ? other.getStarIdApply() == null : this.getStarIdApply().equals(other.getStarIdApply()))
            && (this.getNameApply() == null ? other.getNameApply() == null : this.getNameApply().equals(other.getNameApply()))
            && (this.getBrandDescApply() == null ? other.getBrandDescApply() == null : this.getBrandDescApply().equals(other.getBrandDescApply()))
            && (this.getPhoneApply() == null ? other.getPhoneApply() == null : this.getPhoneApply().equals(other.getPhoneApply()))
            && (this.getJoinDescApply() == null ? other.getJoinDescApply() == null : this.getJoinDescApply().equals(other.getJoinDescApply()))
            && (this.getMoneyApply() == null ? other.getMoneyApply() == null : this.getMoneyApply().equals(other.getMoneyApply()))
            && (this.getOrgUser() == null ? other.getOrgUser() == null : this.getOrgUser().equals(other.getOrgUser()))
            && (this.getOrgLogoUrl() == null ? other.getOrgLogoUrl() == null : this.getOrgLogoUrl().equals(other.getOrgLogoUrl()))
            && (this.getDonateMoney() == null ? other.getDonateMoney() == null : this.getDonateMoney().equals(other.getDonateMoney()))
            && (this.getOther1() == null ? other.getOther1() == null : this.getOther1().equals(other.getOther1()))
            && (this.getOther2() == null ? other.getOther2() == null : this.getOther2().equals(other.getOther2()))
            && (this.getOther3() == null ? other.getOther3() == null : this.getOther3().equals(other.getOther3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDonateHeart() == null) ? 0 : getDonateHeart().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getCreateOperator() == null) ? 0 : getCreateOperator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastOperator() == null) ? 0 : getLastOperator().hashCode());
        result = prime * result + ((getLastModifyTime() == null) ? 0 : getLastModifyTime().hashCode());
        result = prime * result + ((getTypeApply() == null) ? 0 : getTypeApply().hashCode());
        result = prime * result + ((getStarIdApply() == null) ? 0 : getStarIdApply().hashCode());
        result = prime * result + ((getNameApply() == null) ? 0 : getNameApply().hashCode());
        result = prime * result + ((getBrandDescApply() == null) ? 0 : getBrandDescApply().hashCode());
        result = prime * result + ((getPhoneApply() == null) ? 0 : getPhoneApply().hashCode());
        result = prime * result + ((getJoinDescApply() == null) ? 0 : getJoinDescApply().hashCode());
        result = prime * result + ((getMoneyApply() == null) ? 0 : getMoneyApply().hashCode());
        result = prime * result + ((getOrgUser() == null) ? 0 : getOrgUser().hashCode());
        result = prime * result + ((getOrgLogoUrl() == null) ? 0 : getOrgLogoUrl().hashCode());
        result = prime * result + ((getDonateMoney() == null) ? 0 : getDonateMoney().hashCode());
        result = prime * result + ((getOther1() == null) ? 0 : getOther1().hashCode());
        result = prime * result + ((getOther2() == null) ? 0 : getOther2().hashCode());
        result = prime * result + ((getOther3() == null) ? 0 : getOther3().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createOperator=").append(createOperator);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastOperator=").append(lastOperator);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", typeApply=").append(typeApply);
        sb.append(", starIdApply=").append(starIdApply);
        sb.append(", nameApply=").append(nameApply);
        sb.append(", brandDescApply=").append(brandDescApply);
        sb.append(", phoneApply=").append(phoneApply);
        sb.append(", joinDescApply=").append(joinDescApply);
        sb.append(", moneyApply=").append(moneyApply);
        sb.append(", orgUser=").append(orgUser);
        sb.append(", orgLogoUrl=").append(orgLogoUrl);
        sb.append(", donateMoney=").append(donateMoney);
        sb.append(", other1=").append(other1);
        sb.append(", other2=").append(other2);
        sb.append(", other3=").append(other3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}