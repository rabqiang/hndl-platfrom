package com.hndl.cn.wechat.sys.business.user.manager;

import com.hndl.cn.dao.common.bean.CommonUserInfoDo;

import java.util.List;

/**
 * @Classname 赵俊凯
 * @Description 用户信息Manager
 * @Date 2019/3/14 15:37
 * @Created by 湖南达联
 */
public interface CommonUserInfoManager {

    /**
     *   通过用户id查询用户信息
     * @param userId
     * @return
     */
     CommonUserInfoDo findUserByUserId(Long userId);


    /**
     *  通过小程序 open ID查询用户
     * @param xcxOpenId
     * @return
     */
     CommonUserInfoDo findUserByXcxOpenId(String xcxOpenId);


    /**
     *  通过微信id查询用户
     * @param weChatUniId
     * @return
     */
     CommonUserInfoDo findUserByWeChatUniId(String weChatUniId);

    /**
     * 添加新用户
     * @param commonUserInfoDo
     */
     void addUserInfo(CommonUserInfoDo commonUserInfoDo);


    /**
     *  修改用户信息
     * @param commonUserInfoDo
     */
     void updateUserInfo(CommonUserInfoDo commonUserInfoDo);


    /**
     * 分页获取用户Do
     * @param pageNo
     * @param pageSize
     * @return
     */
     List<CommonUserInfoDo> findByUserPage(Integer pageNo, Integer pageSize);


    List<CommonUserInfoDo> findByUserPageByUniIdIsNull(Integer pageNo, Integer pageSize);



}
