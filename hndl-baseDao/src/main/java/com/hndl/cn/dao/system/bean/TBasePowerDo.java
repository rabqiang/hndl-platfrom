package com.hndl.cn.dao.system.bean;

import java.io.Serializable;

/**
 * t_base_power
 * @author 
 */
public class TBasePowerDo implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 权限编号
     */
    private String powerid;

    /**
     * 权限名称
     */
    private String powername;

    /**
     * 父权限编号
     */
    private String fatherid;

    /**
     * 权限URl
     */
    private String powerurl;

    /**
     * 权限类型（1：菜单权限；2：按钮权限）
     */
    private String powertype;

    /**
     * 排序号
     */
    private Integer sequences;

    /**
     * extjs的路径
     */
    private String extviewurl;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPowerid() {
        return powerid;
    }

    public void setPowerid(String powerid) {
        this.powerid = powerid;
    }

    public String getPowername() {
        return powername;
    }

    public void setPowername(String powername) {
        this.powername = powername;
    }

    public String getFatherid() {
        return fatherid;
    }

    public void setFatherid(String fatherid) {
        this.fatherid = fatherid;
    }

    public String getPowerurl() {
        return powerurl;
    }

    public void setPowerurl(String powerurl) {
        this.powerurl = powerurl;
    }

    public String getPowertype() {
        return powertype;
    }

    public void setPowertype(String powertype) {
        this.powertype = powertype;
    }

    public Integer getSequences() {
        return sequences;
    }

    public void setSequences(Integer sequences) {
        this.sequences = sequences;
    }

    public String getExtviewurl() {
        return extviewurl;
    }

    public void setExtviewurl(String extviewurl) {
        this.extviewurl = extviewurl;
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
        TBasePowerDo other = (TBasePowerDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPowerid() == null ? other.getPowerid() == null : this.getPowerid().equals(other.getPowerid()))
            && (this.getPowername() == null ? other.getPowername() == null : this.getPowername().equals(other.getPowername()))
            && (this.getFatherid() == null ? other.getFatherid() == null : this.getFatherid().equals(other.getFatherid()))
            && (this.getPowerurl() == null ? other.getPowerurl() == null : this.getPowerurl().equals(other.getPowerurl()))
            && (this.getPowertype() == null ? other.getPowertype() == null : this.getPowertype().equals(other.getPowertype()))
            && (this.getSequences() == null ? other.getSequences() == null : this.getSequences().equals(other.getSequences()))
            && (this.getExtviewurl() == null ? other.getExtviewurl() == null : this.getExtviewurl().equals(other.getExtviewurl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPowerid() == null) ? 0 : getPowerid().hashCode());
        result = prime * result + ((getPowername() == null) ? 0 : getPowername().hashCode());
        result = prime * result + ((getFatherid() == null) ? 0 : getFatherid().hashCode());
        result = prime * result + ((getPowerurl() == null) ? 0 : getPowerurl().hashCode());
        result = prime * result + ((getPowertype() == null) ? 0 : getPowertype().hashCode());
        result = prime * result + ((getSequences() == null) ? 0 : getSequences().hashCode());
        result = prime * result + ((getExtviewurl() == null) ? 0 : getExtviewurl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", powerid=").append(powerid);
        sb.append(", powername=").append(powername);
        sb.append(", fatherid=").append(fatherid);
        sb.append(", powerurl=").append(powerurl);
        sb.append(", powertype=").append(powertype);
        sb.append(", sequences=").append(sequences);
        sb.append(", extviewurl=").append(extviewurl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}