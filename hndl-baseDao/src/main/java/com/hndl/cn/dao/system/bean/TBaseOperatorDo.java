package com.hndl.cn.dao.system.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * t_base_operator
 * @author 
 */
public class TBaseOperatorDo implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String loginname;

    /**
     * 姓名
     */
    private String username;

    /**
     * 密码
     */
    private String loginpwd;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 角色名
     */
    private String rolename;

    /**
     * 角色ID
     */
    private Integer roleid;

    /**
     * 上级账户ID(父节点ID)
     */
    private Integer fatherid;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 递归序列号
     */
    private String sequences;

    /**
     * 能否发展下级(0：能，1：不能，默认能)
     */
    private String isextend;

    /**
     * 微信ID 唯一
     */
    private String openid;

    /**
     * 是否删除(0：未删除，1：已删除)
     */
    private String isdelete;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getFatherid() {
        return fatherid;
    }

    public void setFatherid(Integer fatherid) {
        this.fatherid = fatherid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getSequences() {
        return sequences;
    }

    public void setSequences(String sequences) {
        this.sequences = sequences;
    }

    public String getIsextend() {
        return isextend;
    }

    public void setIsextend(String isextend) {
        this.isextend = isextend;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
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
        TBaseOperatorDo other = (TBaseOperatorDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoginname() == null ? other.getLoginname() == null : this.getLoginname().equals(other.getLoginname()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getLoginpwd() == null ? other.getLoginpwd() == null : this.getLoginpwd().equals(other.getLoginpwd()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getRolename() == null ? other.getRolename() == null : this.getRolename().equals(other.getRolename()))
            && (this.getRoleid() == null ? other.getRoleid() == null : this.getRoleid().equals(other.getRoleid()))
            && (this.getFatherid() == null ? other.getFatherid() == null : this.getFatherid().equals(other.getFatherid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getSequences() == null ? other.getSequences() == null : this.getSequences().equals(other.getSequences()))
            && (this.getIsextend() == null ? other.getIsextend() == null : this.getIsextend().equals(other.getIsextend()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getIsdelete() == null ? other.getIsdelete() == null : this.getIsdelete().equals(other.getIsdelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginname() == null) ? 0 : getLoginname().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getLoginpwd() == null) ? 0 : getLoginpwd().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getRolename() == null) ? 0 : getRolename().hashCode());
        result = prime * result + ((getRoleid() == null) ? 0 : getRoleid().hashCode());
        result = prime * result + ((getFatherid() == null) ? 0 : getFatherid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getSequences() == null) ? 0 : getSequences().hashCode());
        result = prime * result + ((getIsextend() == null) ? 0 : getIsextend().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getIsdelete() == null) ? 0 : getIsdelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginname=").append(loginname);
        sb.append(", username=").append(username);
        sb.append(", loginpwd=").append(loginpwd);
        sb.append(", phone=").append(phone);
        sb.append(", rolename=").append(rolename);
        sb.append(", roleid=").append(roleid);
        sb.append(", fatherid=").append(fatherid);
        sb.append(", createtime=").append(createtime);
        sb.append(", sequences=").append(sequences);
        sb.append(", isextend=").append(isextend);
        sb.append(", openid=").append(openid);
        sb.append(", isdelete=").append(isdelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}