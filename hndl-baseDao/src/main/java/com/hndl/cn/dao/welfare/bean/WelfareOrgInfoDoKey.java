package com.hndl.cn.dao.welfare.bean;

import java.io.Serializable;

/**
 * welfare_org_info
 * @author 
 */
public class WelfareOrgInfoDoKey implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 累计筹集爱心数
     */
    private Long donateHeart;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDonateHeart() {
        return donateHeart;
    }

    public void setDonateHeart(Long donateHeart) {
        this.donateHeart = donateHeart;
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
        WelfareOrgInfoDoKey other = (WelfareOrgInfoDoKey) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDonateHeart() == null ? other.getDonateHeart() == null : this.getDonateHeart().equals(other.getDonateHeart()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDonateHeart() == null) ? 0 : getDonateHeart().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", donateHeart=").append(donateHeart);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}