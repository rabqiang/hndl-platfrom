package com.hndl.cn.mysql.manager.common.manager;

import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;

import java.util.Date;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/22 10:50
 * @Created by 湖南达联
 */
public interface CommonUserInfoManager {

    /**
     * 获取用户信息
     *
     * @param uniId
     * @return
     */
    CommonUserInfoDo findUserByUniId(Long uniId);


    /**
     * 给用户加快乐币
     *
     * @param userUinId
     * @param coin
     * @return
     */
    boolean increaseCoinByUserUinId(Long userUinId, Double coin);


    /**
     * 给用户扣快乐币
     *
     * @param userUinId
     * @param coin
     * @return
     */
    boolean minusCoinByUserUinId(Long userUinId, Double coin);


    /**
     * 通过用户id查询用户信息
     *
     * @param userId
     * @return
     */
    CommonUserInfoDo findUserByUserId(Long userId);


    /**
     * 通过小程序 open ID查询用户
     *
     * @param xcxOpenId
     * @return
     */
    CommonUserInfoDo findUserByXcxOpenId(String xcxOpenId);


    /**
     * 通过微信id查询用户
     *
     * @param weChatUniId
     * @return
     */
    CommonUserInfoDo findUserByWeChatUniId(String weChatUniId,IsValidEnums isValidEnums);

    /**
     * 通过手机查询用户
     *
     * @param mobile
     * @return
     */
    CommonUserInfoDo findUserByMobile(String mobile, IsValidEnums isValidEnums);


    /**
     * 通过微博id查询用户
     *
     * @param weiBoOpenId
     * @return
     */
    CommonUserInfoDo findUserByWeiBoOpenId(String weiBoOpenId,IsValidEnums isValidEnums);


    /**
     * 通过昵称 查询用户
     *
     * @param
     * @return
     */
    CommonUserInfoDo findUserByNickName(String nickName);

    /**
     * QQ open id 查询用户
     *
     * @param qqOpenId
     * @return
     */
    CommonUserInfoDo findUserByQqOpenId(String qqOpenId,IsValidEnums isValidEnums);

    /**
     * 添加新用户
     *
     * @param commonUserInfoDo
     */
    boolean addUserInfo(CommonUserInfoDo commonUserInfoDo);

    /**
     * 修改用户信息
     *
     * @param commonUserInfoDo
     */
    void updateUserInfo(CommonUserInfoDo commonUserInfoDo);

    void updateUserInfoById(CommonUserInfoDo commonUserInfoDo);

    /**
     * 根据用户的师父id查询师父用户
     *
     * @param lastUserId
     * @return
     */
    CommonUserInfoDo getMaster(Long lastUserId);

    /**
     * 后台用户管理
     * 查询用户加分页 (每页1000)
     *
     * @param pageNO
     * @return
     */
    List<CommonUserInfoDo> getUserAll(CommonUserInfoDo commonUserInfoDo, Long pageNo, Integer pageSize);

    List<Long> getAllUserId(Long pageNo, Integer pageSize);

    /**
     * 获取徒弟数
     *
     * @param userId
     * @return
     */
    List<CommonUserInfoDo> countApprentice(Long userId);

    /**
     * 查询有师父的用户
     */
    List<CommonUserInfoDo> getUserMaster();

    /**
     * 查询用户手机号
     *
     * @param UserUniId
     * @return
     */
    PageInfo<CommonUserInfoDo> findUserGetNumberById(Long UserUniId, Integer pageNo, Integer pageSize);

    /**
     * 查询有多少用户
     */
    Long getUserSum(CommonUserInfoDo commonUserInfoDo);


    /**
     * 分页查询师徒
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<CommonUserInfoDo> getUserMasterByPage(Integer pageNo,Integer pageSize);

    /**
     * 查询昵称是否存在
     * @param nickName 昵称
     * @return 是否存在
     */
    boolean existNickName(String nickName);

    /**
     * 根据时间查询新注册的用户
     * @param startDate
     * @param endDate
     * @return
     */
    Long countNewUserByDate(Date startDate, Date endDate);

}
