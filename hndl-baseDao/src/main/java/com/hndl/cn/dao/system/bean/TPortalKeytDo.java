package com.hndl.cn.dao.system.bean;

import java.io.Serializable;

/**
 * t_portal_keyt
 * @author 
 */
public class TPortalKeytDo implements Serializable {
    private Integer id;

    private String ip;

    private String appid;

    private String channelid;

    private String nodetype;

    private String sysdate;

    private String retkey;

    private String retmsg;

    private String retcode;

    private String sys;

    private String version;

    private String status;

    private String htmlkey;

    private String sysversion;

    private String imei;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getNodetype() {
        return nodetype;
    }

    public void setNodetype(String nodetype) {
        this.nodetype = nodetype;
    }

    public String getSysdate() {
        return sysdate;
    }

    public void setSysdate(String sysdate) {
        this.sysdate = sysdate;
    }

    public String getRetkey() {
        return retkey;
    }

    public void setRetkey(String retkey) {
        this.retkey = retkey;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getSys() {
        return sys;
    }

    public void setSys(String sys) {
        this.sys = sys;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHtmlkey() {
        return htmlkey;
    }

    public void setHtmlkey(String htmlkey) {
        this.htmlkey = htmlkey;
    }

    public String getSysversion() {
        return sysversion;
    }

    public void setSysversion(String sysversion) {
        this.sysversion = sysversion;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
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
        TPortalKeytDo other = (TPortalKeytDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()))
            && (this.getChannelid() == null ? other.getChannelid() == null : this.getChannelid().equals(other.getChannelid()))
            && (this.getNodetype() == null ? other.getNodetype() == null : this.getNodetype().equals(other.getNodetype()))
            && (this.getSysdate() == null ? other.getSysdate() == null : this.getSysdate().equals(other.getSysdate()))
            && (this.getRetkey() == null ? other.getRetkey() == null : this.getRetkey().equals(other.getRetkey()))
            && (this.getRetmsg() == null ? other.getRetmsg() == null : this.getRetmsg().equals(other.getRetmsg()))
            && (this.getRetcode() == null ? other.getRetcode() == null : this.getRetcode().equals(other.getRetcode()))
            && (this.getSys() == null ? other.getSys() == null : this.getSys().equals(other.getSys()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getHtmlkey() == null ? other.getHtmlkey() == null : this.getHtmlkey().equals(other.getHtmlkey()))
            && (this.getSysversion() == null ? other.getSysversion() == null : this.getSysversion().equals(other.getSysversion()))
            && (this.getImei() == null ? other.getImei() == null : this.getImei().equals(other.getImei()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getAppid() == null) ? 0 : getAppid().hashCode());
        result = prime * result + ((getChannelid() == null) ? 0 : getChannelid().hashCode());
        result = prime * result + ((getNodetype() == null) ? 0 : getNodetype().hashCode());
        result = prime * result + ((getSysdate() == null) ? 0 : getSysdate().hashCode());
        result = prime * result + ((getRetkey() == null) ? 0 : getRetkey().hashCode());
        result = prime * result + ((getRetmsg() == null) ? 0 : getRetmsg().hashCode());
        result = prime * result + ((getRetcode() == null) ? 0 : getRetcode().hashCode());
        result = prime * result + ((getSys() == null) ? 0 : getSys().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getHtmlkey() == null) ? 0 : getHtmlkey().hashCode());
        result = prime * result + ((getSysversion() == null) ? 0 : getSysversion().hashCode());
        result = prime * result + ((getImei() == null) ? 0 : getImei().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ip=").append(ip);
        sb.append(", appid=").append(appid);
        sb.append(", channelid=").append(channelid);
        sb.append(", nodetype=").append(nodetype);
        sb.append(", sysdate=").append(sysdate);
        sb.append(", retkey=").append(retkey);
        sb.append(", retmsg=").append(retmsg);
        sb.append(", retcode=").append(retcode);
        sb.append(", sys=").append(sys);
        sb.append(", version=").append(version);
        sb.append(", status=").append(status);
        sb.append(", htmlkey=").append(htmlkey);
        sb.append(", sysversion=").append(sysversion);
        sb.append(", imei=").append(imei);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}