package com.hndl.cn.mongodb.manager.activity.manager;

import com.hndl.cn.mongodb.manager.activity.bean.HappyLibraryShareVoteDo;

import java.util.List;

/**
 * @Classname 赵俊凯
 * @Description 快乐图书室活动类
 * @Date 2019/3/31 13:25
 * @Created by 湖南达联
 */
public interface HappyLibraryShareVoteManager {

    void insertHappyLibraryShareVote(HappyLibraryShareVoteDo happyLibraryShareVoteDo);


    HappyLibraryShareVoteDo findHappyLibraryShareVoteByVersionDesc();


    List<HappyLibraryShareVoteDo> findHappyLibraryShareVoteByVoteCountDesc(Integer version);

    HappyLibraryShareVoteDo findHappyLibraryShareVoteByGroupId(Long groupId);


    void increaseVoteCount(Integer version,Long groupId,Long voteCount);

    void updateGroupNameAndFaceImg(HappyLibraryShareVoteDo happyLibraryShareVoteDo);

}
