package com.hndl.cn.mongodb.manager.luckdraw.manager;

import com.hndl.cn.mongodb.manager.luckdraw.bean.HelpUserWelfareMappingDo;

import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/7/24 17:18
 * @Created by 湖南达联
 */
public interface HelpUserWelfareMappingManager {

    /**
     * 站外好友给用户增加助力数
     * @param helpUserWelfareMappingDo
     */
    void  addHelpUserWelfareMapping(HelpUserWelfareMappingDo helpUserWelfareMappingDo);

    /**
     * 根据期号和用户ID查询"我"帮助"好友"助力的记录
     * @param welfareNumber
     * @param userUniId
     * @return
     */
    HelpUserWelfareMappingDo queryHelpByUserId(String welfareNumber, Long userUniId);

    /**
     * 根据用户ID查询"我"今天帮助"好友"助力的次数
     * @param userUniId
     * @return
     */
    Long queryHelpCountByUserId(Long userUniId);

    /**
     * 查询为我助力的好友列表
     * @param userUniId "我"的id
     * @param welfareNumber 期号
     * @return
     */
    List<HelpUserWelfareMappingDo> queryHelpMeFriend(Long userUniId, String welfareNumber);

    /**
     * 查询为我助力过的人数
     * @param userUniId
     * @param welfareNumber
     * @return
     */
    Long queryHelpMeFriendCount(Long userUniId, String welfareNumber);

    /**
     * 修改用户昵称
     * @param userUniId     用户uniId
     * @param userNickName  用户昵称
     */
    void updateUserNickNameByUserUniId(Long userUniId,String userNickName);

    /**
     * 修改用户头像
     * @param userUniId
     * @param userImg
     */
    void  updateUserImgByUserUniId( Long userUniId,String userImg);
}
