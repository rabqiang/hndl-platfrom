package com.hndl.cn.mghd.sys.business.wechat.service;

import com.hndl.cn.base.result.Result;

/**
 * @author 曹加丽
 * @Description 用户登陆小程序,返回小程序首页信息
 * @Date 2019/5/22 20:35
 * @Created by 湖南达联
 */
public interface WechatHomeService {

    /**
     * 首次查询每天的轮播图 ,查询每天日榜的前50条数据
     * @return
     */
    Result<Object> initfindWechatGeHome();
    

    
}
