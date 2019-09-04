package com.hndl.cn.dao.system.bean;

import java.io.Serializable;

/**
 * t_user_info
 * @author 
 */
public class TUserInfoDo implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 电话
     */
    private String userphone;

    /**
     * 所属省
     */
    private String province;

    /**
     * 所属市
     */
    private String city;

    /**
     * 所属区
     */
    private String area;

    /**
     * 所属楼盘
     */
    private String street;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 微信ID
     */
    private String userweixin;

    /**
     * 用户积分
     */
    private Long userintegral;

    /**
     * 是否冻结（0：否；1：是）
     */
    private Integer isfreeze;

    /**
     * 是否删除（0：否；1：是）
     */
    private Integer isdelete;

    /**
     * 扩展字段
     */
    private String other1;

    /**
     * 扩展字段
     */
    private String other2;

    /**
     * 扩展字段
     */
    private String other3;

    /**
     * 扩展字段
     */
    private String other4;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserweixin() {
        return userweixin;
    }

    public void setUserweixin(String userweixin) {
        this.userweixin = userweixin;
    }

    public Long getUserintegral() {
        return userintegral;
    }

    public void setUserintegral(Long userintegral) {
        this.userintegral = userintegral;
    }

    public Integer getIsfreeze() {
        return isfreeze;
    }

    public void setIsfreeze(Integer isfreeze) {
        this.isfreeze = isfreeze;
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
        TUserInfoDo other = (TUserInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getUserphone() == null ? other.getUserphone() == null : this.getUserphone().equals(other.getUserphone()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getStreet() == null ? other.getStreet() == null : this.getStreet().equals(other.getStreet()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getUserweixin() == null ? other.getUserweixin() == null : this.getUserweixin().equals(other.getUserweixin()))
            && (this.getUserintegral() == null ? other.getUserintegral() == null : this.getUserintegral().equals(other.getUserintegral()))
            && (this.getIsfreeze() == null ? other.getIsfreeze() == null : this.getIsfreeze().equals(other.getIsfreeze()))
            && (this.getIsdelete() == null ? other.getIsdelete() == null : this.getIsdelete().equals(other.getIsdelete()))
            && (this.getOther1() == null ? other.getOther1() == null : this.getOther1().equals(other.getOther1()))
            && (this.getOther2() == null ? other.getOther2() == null : this.getOther2().equals(other.getOther2()))
            && (this.getOther3() == null ? other.getOther3() == null : this.getOther3().equals(other.getOther3()))
            && (this.getOther4() == null ? other.getOther4() == null : this.getOther4().equals(other.getOther4()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getUserphone() == null) ? 0 : getUserphone().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getStreet() == null) ? 0 : getStreet().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getUserweixin() == null) ? 0 : getUserweixin().hashCode());
        result = prime * result + ((getUserintegral() == null) ? 0 : getUserintegral().hashCode());
        result = prime * result + ((getIsfreeze() == null) ? 0 : getIsfreeze().hashCode());
        result = prime * result + ((getIsdelete() == null) ? 0 : getIsdelete().hashCode());
        result = prime * result + ((getOther1() == null) ? 0 : getOther1().hashCode());
        result = prime * result + ((getOther2() == null) ? 0 : getOther2().hashCode());
        result = prime * result + ((getOther3() == null) ? 0 : getOther3().hashCode());
        result = prime * result + ((getOther4() == null) ? 0 : getOther4().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", userphone=").append(userphone);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", area=").append(area);
        sb.append(", street=").append(street);
        sb.append(", address=").append(address);
        sb.append(", userweixin=").append(userweixin);
        sb.append(", userintegral=").append(userintegral);
        sb.append(", isfreeze=").append(isfreeze);
        sb.append(", isdelete=").append(isdelete);
        sb.append(", other1=").append(other1);
        sb.append(", other2=").append(other2);
        sb.append(", other3=").append(other3);
        sb.append(", other4=").append(other4);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}