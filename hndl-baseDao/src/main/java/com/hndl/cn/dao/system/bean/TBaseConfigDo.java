package com.hndl.cn.dao.system.bean;

import java.io.Serializable;

/**
 * t_base_config
 * @author 
 */
public class TBaseConfigDo implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 配置项名称
     */
    private String configname;

    /**
     * 配置项取值
     */
    private String configvalue;

    /**
     * 配置项可否修改(Y-可修改，N-不可修改)
     */
    private String allowmodify;

    /**
     * 配置项类型（0-文本类型,1-枚举类型,2-数字类型,3-文本域类型）
     */
    private String configtype;

    /**
     * 对于文本类型，用正则表达式，对于枚举类型则用“值|描述”表示，分号分隔，对于数字类型则用[a-b]表示
     */
    private String validaterule;

    /**
     * 规则描述
     */
    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfigname() {
        return configname;
    }

    public void setConfigname(String configname) {
        this.configname = configname;
    }

    public String getConfigvalue() {
        return configvalue;
    }

    public void setConfigvalue(String configvalue) {
        this.configvalue = configvalue;
    }

    public String getAllowmodify() {
        return allowmodify;
    }

    public void setAllowmodify(String allowmodify) {
        this.allowmodify = allowmodify;
    }

    public String getConfigtype() {
        return configtype;
    }

    public void setConfigtype(String configtype) {
        this.configtype = configtype;
    }

    public String getValidaterule() {
        return validaterule;
    }

    public void setValidaterule(String validaterule) {
        this.validaterule = validaterule;
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
        TBaseConfigDo other = (TBaseConfigDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getConfigname() == null ? other.getConfigname() == null : this.getConfigname().equals(other.getConfigname()))
            && (this.getConfigvalue() == null ? other.getConfigvalue() == null : this.getConfigvalue().equals(other.getConfigvalue()))
            && (this.getAllowmodify() == null ? other.getAllowmodify() == null : this.getAllowmodify().equals(other.getAllowmodify()))
            && (this.getConfigtype() == null ? other.getConfigtype() == null : this.getConfigtype().equals(other.getConfigtype()))
            && (this.getValidaterule() == null ? other.getValidaterule() == null : this.getValidaterule().equals(other.getValidaterule()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getConfigname() == null) ? 0 : getConfigname().hashCode());
        result = prime * result + ((getConfigvalue() == null) ? 0 : getConfigvalue().hashCode());
        result = prime * result + ((getAllowmodify() == null) ? 0 : getAllowmodify().hashCode());
        result = prime * result + ((getConfigtype() == null) ? 0 : getConfigtype().hashCode());
        result = prime * result + ((getValidaterule() == null) ? 0 : getValidaterule().hashCode());
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
        sb.append(", configname=").append(configname);
        sb.append(", configvalue=").append(configvalue);
        sb.append(", allowmodify=").append(allowmodify);
        sb.append(", configtype=").append(configtype);
        sb.append(", validaterule=").append(validaterule);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}