package com.hndl.cn.mghd.sys.business.user.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/4/23 15:12
 * @Created by 湖南达联
 */
public interface UserStatisticsService {



    /**
     * 初始化所有人的爱心值
     */
    Result<Object> initUserGettingCount();


    /**
     * 查询app上我的个人信息
     * 用户积分、爱心值、快乐号、用户等级、用户的昵称,头像,快乐币
     * @param userUinId 用户id
     * @return
     */
    Result<Object> findUserStatisticsByUserUinId(Long userUinId);

    /**
     * 修改用户头像
     */
    Result<Object> updateUserPersonImgUrl(CommonUserInfoDo commonUserInfoDo, String PersonImgUrl);

    /**
     * 修改用户昵称
     */
    Result<Object> updateUserNickName(CommonUserInfoDo commonUserInfoDo,String nickName);

    /**
     * 修改用户手机号
     */

    Result<Object> updateUserPhoneNum(CommonUserInfoDo commonUserInfoDo,String phoneNum);


    /**
     * 修改用户个性签名
     */
    Result<Object> updateUserPersonalAutograph(CommonUserInfoDo commonUserInfoDo,String personalAutograph);

    /**
     * 修改个人首页 背景图片
     */

    Result<Object>  updateUserHomepageImg(CommonUserInfoDo commonUserInfoDo, String homepageImg);

    /**
     * 根据快乐号带token登陆,获取用户信息
     * @param commonUserInfoDo  登陆的用户
     * @param id                需要获取信息的id
     * @return
     */

    Result<Object> findIdGetUser(CommonUserInfoDo commonUserInfoDo,Long id);

}
