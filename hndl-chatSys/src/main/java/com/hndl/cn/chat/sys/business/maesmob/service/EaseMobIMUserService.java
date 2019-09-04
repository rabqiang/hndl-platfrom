package com.hndl.cn.chat.sys.business.maesmob.service;

import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobRequestUserParam;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobUserInfoResponseParam;

/**
 * @Classname 赵俊凯
 * @Description 环信用户service
 * @Date 2019/3/21 14:02
 * @Created by 湖南达联
 */
public interface EaseMobIMUserService {


    /**
     * 注册IM用户[单个] <br>
     * POST
     *
     *            <code>{"username":"${用户名}","password":"${密码}", "nickname":"${昵称值}"}</code>
     * @return
     */
    EaesMobUserInfoResponseParam createNewIMUserSingle(EaesMobRequestUserParam eaesMobRequestUserParam);


}
