package com.hndl.cn.mghd.sys.business.comment.service;


import com.hndl.cn.base.enums.comment.CommentType;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.comment.vo.ReUserCommentVo;
import com.hndl.cn.mghd.sys.business.comment.vo.UserCommentVo;

import java.util.List;


/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年5月8日 11:17:53
 * @Created by 湖南达联
 */
public interface UserCommentService {


    /**
     * 添加评论
     *
     * @return
     */
    Result<Object> insertUserComment(CommonUserInfoDo commonUserInfoDo, UserCommentVo userCommentVo);


    /**
     * 查询评论
     *
     * @param targetId
     * @param commentType
     * @param objId
     * @return
     */
    List<ReUserCommentVo> findPageUserCommentByTargetId(Long targetId, CommentType commentType, String objId);

    /**
     * 删除评论
     * @param commonUserInfoDo 当前登陆的用户
     * @param id mongo ObjId
     * @return 返回删除成功或者异常信息
     */
    Result<Object> deleteComment(CommonUserInfoDo commonUserInfoDo,String id);
}
