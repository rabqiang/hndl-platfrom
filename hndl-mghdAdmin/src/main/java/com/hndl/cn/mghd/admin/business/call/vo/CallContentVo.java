package com.hndl.cn.mghd.admin.business.call.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @program:hndl-platform
 * @description: call内容id
 * @author: 易成贤
 * @create: 2019-06-25 16:46
 * @Created by湖南达联
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "call内容vo" )
public class CallContentVo implements Serializable {

    private String id;


    private Long callId;//call id


    private Long createTime;//创建时间


    private Long userUniId;//创建用户id

    private String userNickName;//用户昵称

    private String userImg;//用户头像


    private Long starId;//明星id

    private String content;//内容

    private List<String> contentImgList;//内容图片
    //点赞数
    private Integer likeCount;
    //评论数
    private Integer commentCount;

    private  Long isRecommen; //是否推荐
    //是不是明星说
    private Integer isStarSaid;

    private Integer isDelete;//是否删除
}
