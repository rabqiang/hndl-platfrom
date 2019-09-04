package com.hndl.cn.mongodb.manager.luckdraw.manager;

import com.hndl.cn.mongodb.manager.luckdraw.bean.UserWelfareMappingDo;

import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/7/24 16:19
 * @Created by 湖南达联
 */
public interface UserWelfareMappingManager {
    /**
     * 增加用户参与助力记录
     * @param userWelfareMappingDo
     */
    void addUserWelfareMapping(UserWelfareMappingDo userWelfareMappingDo);

    /**
     * 增加个人某福利助力值
     * @param userUniId      用户id
     * @param welfareNumber 商品期号
     * @param helpCount      增加的助力数
     */
    void addUserWelfareGetHelpCount(Long userUniId, String welfareNumber, Integer helpCount, Integer LastHelpCount);

    /**
     * 查询参与此福利的用户信息
     * 根据助力值的从高到低排序
     * @param welfareNumber  商品期号
     * @param limit          分页大小
     * @return
     */
    List<UserWelfareMappingDo> findUserWelfareByWelfareNumber(String welfareNumber,Integer limit);

    /**
     * 根据期号和用户ID查询用户助力信息
     * @param welfareNumber
     * @param userUniId
     * @return
     */
    UserWelfareMappingDo queryHelpCountByUserId(String welfareNumber, Long userUniId);

    /**
     * 根据助力ID查询用户助力信息
     * @param userWelfareId
     * @return
     */
    UserWelfareMappingDo queryUserWelfareById(String userWelfareId);

    /**
     * 根据期号按照最后修改时间倒序查询参与抢福利的十个用户
     * @param welfareNumber
     * @return
     */
    List<UserWelfareMappingDo> findIsJoinUserInfo(String welfareNumber);

    /**
     * 根据期号统计已参与抢福利的人数
     * @param welfareNumber 奖品期号
     * @return
     */
    Long countIsPartakePersonCount(String welfareNumber);

    /**
     * 满足开奖条件的用户信息,并且不能包含指定用户
     * @param welfareNumber     奖品期号
     * @param lastTime        最后修改时间
     * @param userUniIdList   指定中奖人信息
     * @param limit             页数
     * @return
     */
     List<UserWelfareMappingDo> findUserWelfare(String welfareNumber,List<Long> userUniIdList, Integer limit);

    /**
     * 修改用户信息
     * @param userUniId   用户UniId
     * @param userNickName 用户昵称
     */
    void updateUserNameByUserId(Long userUniId,String  userNickName);

    void updateUserImgByUserId(Long userUniId,String  userImg);
}
