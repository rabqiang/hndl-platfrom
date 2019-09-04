package com.hndl.cn.mghd.job.business.weibo.service;

import com.hndl.cn.dao.weibo.Statuses;
import com.hndl.cn.dao.weibo.WeiboDo;
import com.hndl.cn.mongodb.manager.content.bean.StarCallContentDo;

import java.util.List;

/**
 * @program: hndl-platform
 * @description: 获取微博数据，之多获取100条
 * @author: 易成贤
 * @create: 2019-05-25 13:31
 * @Created by 湖南达联
 **/
public interface GetWeiboService {
   /* Integer client_id = 644266243;
    String client_secret = "f916ea640fa8dc55f97f85651109e6ed";
    String grant_type = "authorization_code";
    String redirect_uri = "https://api.weibo.com/oauth2/default.html";
*/

    /**
     * 获取token
     * @return 微博token
     */
    String getToken(String userName, String password);

    /**
     * 分析并且获取粉丝会微博数据
     * @param statuses
     * @return 分析后直接可以插入到数据库的数据
     */
    List<StarCallContentDo> analysisWeiboJson(List<Statuses> statuses);
    /**
     * 获取微博数据
     *
     * @param token token
     * @param page  当前页
     * @param count 总记录数
     * @return 从微博api获取微博的数据
     */
    public WeiboDo getWeibo(String token, String page, String count);
    /**
     * 插入微博打call数据
     * @param starCallContentDos
     */
    void  insertWeiboCall(List<StarCallContentDo> starCallContentDos);
}
