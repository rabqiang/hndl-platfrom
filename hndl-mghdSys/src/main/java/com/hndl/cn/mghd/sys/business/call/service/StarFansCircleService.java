package com.hndl.cn.mghd.sys.business.call.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.call.vo.StarCallContentVo;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * @program: hndl-platform
 * @description: 星粉圈
 * @author: 易成贤
 * @create: 2019-05-08 20:42
 * @Created by 湖南达联
 **/
public interface StarFansCircleService {
    /**
     * 设置是否点赞
     * @param commonUserInfoDo
     * @param starCallContentVos
     * @return
     */
    public List<StarCallContentVo> findLike(CommonUserInfoDo commonUserInfoDo, List<StarCallContentVo> starCallContentVos);

    /**
     * 查询明星的星粉圈
     * @param starId
     * @param id
     * exp: 当前时间，或者翻到最后星粉圈数据的时间
     * @return
     */
    List<StarCallContentVo> findAllStarFansCircle(CommonUserInfoDo commonUserInfoDo,Integer pageNo,Long starId,String id);


    /**
     * 查询app首页内容
     * @param commonUserInfoDo
     * @return
     */
    List<StarCallContentVo> findAppHomeStarFansCircle(CommonUserInfoDo commonUserInfoDo,Integer pageNo);

    /**
     * 打call
     * @param commonUserInfoDo
     * @param starId 明星id
     * @param content 内容
     * @param contentImgList 图片
     * @return 返回成功数据date包含CallId
     */
    Result<Object> addStarFansCircle(CommonUserInfoDo commonUserInfoDo,Long starId,String content,List<String> contentImgList );

    /**
     * 查询爱豆说
     * @param starId
     * @param id
     * @return
     */
    List<StarCallContentVo> findStarSaid(CommonUserInfoDo commonUserInfoDo,Integer pageNo, Long starId, String id);

    /**
     * 查询用户的call
     * @param commonUserInfoDo 用户
     * @param pageNo 当前页
     * @param userUniId 查询用户的id
     * @param id objId
     * @return 返回列表【第一部分是头部显示信息，包括头像信息和昵称等信息】【第二部分是用户的call列表】
     */
    Map<String,Object> findUserCall(CommonUserInfoDo commonUserInfoDo, Integer pageNo, Long userUniId, String id);

    /**
     * 查询单个callId的数据/包括评论
     * @param commonUserInfoDo
     * @param callId
     * @return
     */
    Result<Map<String,Object>> findOneDetailCall(@NotNull CommonUserInfoDo commonUserInfoDo, Long callId, String id);

    /**
     * 删除打call数据
     * @param commonUserInfoDo
     * @param callId
     * @return
     */
    Result<Object> deleteCall(CommonUserInfoDo commonUserInfoDo, Long callId);
}
