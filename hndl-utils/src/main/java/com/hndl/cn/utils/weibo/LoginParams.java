package com.hndl.cn.utils.weibo;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/25 18:03
 * @Created by 湖南达联
 */
public class LoginParams implements Serializable {

    private static final long serialVersionUID = -5775728968372860382L;
    private String pcid;
    private String servertime;
    private String nonce;
    private String rsakv;
    private String imgUrl;
    private String sp;
    private String code;
    private boolean isLogin = true;

    public String getPcid() {
        return pcid;
    }

    public void setPcid(String pcid) {
        this.pcid = pcid;
    }

    public String getServertime() {
        return servertime;
    }

    public void setServertime(String servertime) {
        this.servertime = servertime;
    }

    public String getNonce() {
        return nonce;
    }
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getRsakv() {
        return rsakv;
    }

    public void setRsakv(String rsakv) {
        this.rsakv = rsakv;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    @Override
    public String toString() {
        return "LoginParams [pcid=" + pcid + ", servertime=" + servertime
                + ", nonce=" + nonce + ", rsakv=" + rsakv + ", imgUrl="
                + imgUrl + ", sp=" + sp + ", code=" + code + ", isLogin="
                + isLogin + "]";
    }

}
