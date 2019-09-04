package com.hndl.cn.dao.system.bean;

import java.io.Serializable;

/**
 * t_base_data
 * @author 
 */
public class TBaseDataDo implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 数据编号
     */
    private String datacode;

    /**
     * 数据名称
     */
    private String dataname;

    /**
     * 数据类型（定义见框架中的configdata.js）
     */
    private String datatypes;

    /**
     * 描述
     */
    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatacode() {
        return datacode;
    }

    public void setDatacode(String datacode) {
        this.datacode = datacode;
    }

    public String getDataname() {
        return dataname;
    }

    public void setDataname(String dataname) {
        this.dataname = dataname;
    }

    public String getDatatypes() {
        return datatypes;
    }

    public void setDatatypes(String datatypes) {
        this.datatypes = datatypes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        TBaseDataDo other = (TBaseDataDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDatacode() == null ? other.getDatacode() == null : this.getDatacode().equals(other.getDatacode()))
            && (this.getDataname() == null ? other.getDataname() == null : this.getDataname().equals(other.getDataname()))
            && (this.getDatatypes() == null ? other.getDatatypes() == null : this.getDatatypes().equals(other.getDatatypes()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDatacode() == null) ? 0 : getDatacode().hashCode());
        result = prime * result + ((getDataname() == null) ? 0 : getDataname().hashCode());
        result = prime * result + ((getDatatypes() == null) ? 0 : getDatatypes().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", datacode=").append(datacode);
        sb.append(", dataname=").append(dataname);
        sb.append(", datatypes=").append(datatypes);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}