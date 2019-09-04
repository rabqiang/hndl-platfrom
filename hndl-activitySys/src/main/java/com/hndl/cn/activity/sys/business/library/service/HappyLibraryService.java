package com.hndl.cn.activity.sys.business.library.service;

import com.hndl.cn.base.result.Result;

/**
 * @Classname 赵俊凯
 * @Description 快乐图书室service
 * @Date 2019/3/31 16:07
 * @Created by 湖南达联
 */
public interface HappyLibraryService {


    /**
     * 查询当前快乐图示室战队的信息
     * @return
     */
    Result<Object> findHappyLibraryByVersion(Long userId);


    /**
     * 添加分享次数
     * @param version
     * @return
     */
    Result<Object> increaseVoteCount(Integer version,Long groupId,Long userId,Long voteCount);



    /**
     * 添加分享次数 后台使用
     * @param version
     * @return
     */
    Result<Object> increaseVoteCountByKey(Integer version,Long groupId,Long voteCount);



    void happyLibraryRefreshCache();



}
