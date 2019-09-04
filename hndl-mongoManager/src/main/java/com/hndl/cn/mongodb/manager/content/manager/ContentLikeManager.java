package com.hndl.cn.mongodb.manager.content.manager;


import java.util.Collection;
import java.util.Map;

/**
 * @author 赵俊凯
 * @Description 点赞相关
 * @Date 2019/5/7 11:02
 * @Created by 湖南达联
 */
public interface ContentLikeManager {


    /**
     * 创建点赞关系
     * @param userUniId
     * @param targetId
     */
    void  insertLike(Long userUniId,Long targetId);



    /**
     * 是否点过赞
     * @param userUniId
     * @param targetId
     * @return
     */
    boolean isLike(Long userUniId,Long targetId);




    /**
     * 批量查询是否点过赞,注意判断是否为空
     * @param idList
     * @return 会把点过赞的map映射关系返回
     */
    Map<Long,Integer> findBatchIsLike(Long userUniId,Collection<Long> idList);

    /**
     * 删除点赞数据
     * @param targetId
     */
    void deleteLike(Long targetId);

}
