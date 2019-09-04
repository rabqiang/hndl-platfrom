package com.hndl.cn.mongodb.manager.content.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.mongodb.manager.content.bean.StarCallContentDo;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

/**
 * @program: hndl-platform
 * @description: 星粉圈操作
 * @author: 易成贤
 * @create: 2019-05-08 20:32
 * @Created by 湖南达联
 **/
public interface StarCallContentManger {
    /**
     * 查询爱豆下面打call
     *
     * @param starId 粉丝会id
     * @param id     ObjId
     * @param limit  分页条数
     * @return 返回call内容列表
     */
    List<StarCallContentDo> findStarCallContent(Long starId, String id, Integer limit);



    /**
     * 添加打call
     *
     * @param callId         callId，由service生成
     * @param userUniId      用户唯一标识
     * @param userNickName   用户昵称
     * @param userImg        用户头像【url】
     * @param starId         粉丝会id
     * @param content        内容
     * @param contentImgList 图片列表【包含的是图片url】
     */
    void addCall(Long callId, Long userUniId, String userNickName, String userImg, Long starId, String content, List<String> contentImgList);


    /**
     * 查爱豆说
     *
     * @param starId    粉丝会id
     * @param
     * @param id        objId
     * @param limit     分页条数
     * @return 返回爱豆call内容列表
     */
    List<StarCallContentDo> findStarSaidContent(Long starId,  String id, Integer limit);


    /**
     *
     *  查询爱豆说 根据用户关注的粉丝会相关
     * @param starIdList 明星列表
     * @param isValidEnums 是否爱豆说 1是0否
     * @param id   ObjId
     * @param limit 分页条数
     * @return 返回call内容
     */
    List<StarCallContentDo> findStarListSaidContent(Collection<Long> starIdList, IsValidEnums isValidEnums, String id, Integer limit);

    /**
     * 根据用户的id查询相应的打call数据
     *
     * @param userUniIdList
     * @param id
     * @param limit
     * @return
     */
    List<StarCallContentDo> findUserListCallContent(Collection<Long> userUniIdList, String id, Integer limit);



    /***
     * 查询用户用户的call
     * @param userUniId 用户唯一标识
     * @param id objId
     * @param limit 分页记录条数
     * @return 用户的call列表
     */
    List<StarCallContentDo> findUserCallContent(Long userUniId, String id, Integer limit);

    /**
     * 是否打call数据
     *
     * @param targetId
     * @return
     */
    boolean isCall(Long targetId);

    /**
     * 批量插入
     *
     * @param starCallContentDos
     */
    void inserBatch(List<StarCallContentDo> starCallContentDos);

    void inserOne(StarCallContentDo starCallContentDo);

    /**
     * 查询指定call数据
     *
     * @param
     * @param callId
     * @return
     */
    StarCallContentDo findCallContent(Long callId);

    /**
     * 逻辑删除打call数据
     *
     * @param callId
     */
    void deleteCall(Long callId);

    /**
     * 原子递增指定call的评论数
     *
     * @param callId
     */
    void incCommentCount(Long callId,IsValidEnums isValidEnums);

    /**
     * 原子递增点赞数
     *
     * @param callId
     */
    void incLikeCount(@NotNull Long callId);

    /**
     * 更新用户头像
     *
     * @param userUniId 用户唯一标识
     * @param newImg    新的图片地址
     */
    void updateUserImgByUniId(@NotNull Long userUniId,@NotNull String newImg);

    /**
     * 修改用户昵称
     * @param userUniId 用户唯一标识
     * @param newNickName 新的昵称
     */
    void  updateUserNickNameByUniId(@NotNull Long userUniId, @NotNull String newNickName);

    /**
     * 查询所有call数据
     * @param starId 明星id【可不传】
     * @param userUniId 用户id【可不传】
     * @param limit 分页条数
     * @param
     * @return
     */
    List<StarCallContentDo> findAllCall(String id,Collection starId,Long userUniId,IsValidEnums isDelete, @NotNull Integer limit);

    /**
     * 按照时间段查询call数量
     * @param starIdOrUniId
     * @param startTime
     * @param endTime
     * @return
     */
    Long countByTime(Long starIdOrUniId,Long startTime,Long endTime);

    /**
     * 更新是否推荐值
     *
     * @param id
     */
    void updateIsRecommen(String id,Long value);

    /**
     * 根据粉丝会更新粉丝会的call删除状态
     * @param starId
     * @param isDelete
     */
    void updateIsDeleteByStarId(Long starId,IsValidEnums isDelete);

    /**
     * 查询推荐内容
     * @return
     */
    List<StarCallContentDo> findRecommenByUser(Integer limit);

    /**
     * 查询用户当天第一条打call
     * @param userUniId
     * @return
     */
    StarCallContentDo findFristCallByDay(Long userUniId);
}
