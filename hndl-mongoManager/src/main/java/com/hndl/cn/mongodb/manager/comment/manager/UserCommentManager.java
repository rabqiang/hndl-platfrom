package com.hndl.cn.mongodb.manager.comment.manager;

import com.hndl.cn.base.enums.comment.CommentType;
import com.hndl.cn.mongodb.manager.comment.bean.UserCommentDo;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description 用户评论
 * @Date 2019/5/6 15:34
 * @Created by 湖南达联
 */
public interface UserCommentManager {

    /**
     * 新增评论
     */
    void insertComment(UserCommentDo commentDo);

    /**
     * 新增评论
     */
    void insertCommentAll(List<UserCommentDo> commentDo);


    /**
     * 根据userUniId修改头像和名字
     * */
    void updateImgAndNameByUniId(Long userUniId,String userImg,String userNickName);


    /**
     * 分页查询评论 瀑布流
     * @param targetId
     * @param commentType
     * @param objId
     * @return
     */
    List<UserCommentDo> findPageCommentByTargetId(Long targetId, CommentType commentType, String objId);


  /**
   * 根据callId删除所有评论
   * */
    void  delCommentByCallId(Long callId);

    int  countCommentByCallId(Long callId);

    /**
     * 通过评论id查询评论do
     * @param id id
     * @return 返回评论数据
     */
    UserCommentDo findCommentByUniIdAndId(Long UniId,String id);

    UserCommentDo findCommentByCommentId(String id);

    /**
     * 通过id删除评论数据
     *
     * @param id
     */
    void delCommentById(String  id);
}
