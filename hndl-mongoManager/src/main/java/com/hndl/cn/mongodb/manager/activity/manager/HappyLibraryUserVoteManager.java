package com.hndl.cn.mongodb.manager.activity.manager;

import com.hndl.cn.mongodb.manager.activity.bean.HappyLibraryUserVoteDo;

/**
 * @Classname 赵俊凯
 * @Description 保存快乐图书室投票用户关系
 * @Date 2019/3/31 13:24
 * @Created by 湖南达联
 */
public interface HappyLibraryUserVoteManager {


    /**
     * 增加用户分享
     * @param happyLibraryUserVoteDo
     */
    void insertHappyLibraryUserVote(HappyLibraryUserVoteDo happyLibraryUserVoteDo);


    /**
     * 查询用户今天分享次数
     * @return
     */
    Long countHappyLibraryUserVoteByNowTime(Long userId);
}
