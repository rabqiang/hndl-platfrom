package com.hndl.cn.mghd.sys.business.call.vo;

import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @program: hndl-platform
 * @description: 打call
 * @author: 易成贤
 * @create: 2019-05-09 14:06
 * @Created by 湖南达联
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "call数据", description = "返回数据为打call相关需要的数据")
public class StarCallContentVo implements Serializable {
    /**
     * objId，主要返回给前端用户查询分页用户数据
     */
    @ApiModelProperty(value = "ObjId")
    private String id;

    @ApiModelProperty(value = "callId")
    private Long callId;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "创建用户id")
    private Long userUniId;

    @ApiModelProperty(value = "用户昵称")
    private String userNickName;

    @ApiModelProperty(value = "用户头像url")
    private String userImg;

    @ApiModelProperty(value = "明星id")
    private Long starId;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "图片")
    private List<String> contentImgList;

    @ApiModelProperty(value = "点赞数量")
    private Integer likeCount;

    @ApiModelProperty(value = "评论数量")
    private Integer commentCount;

    @ApiModelProperty(value = "用户是否点赞")
    private Integer isLike;

    @ApiModelProperty(value = "返回明星详细/主要用于首页展示")
    private StarFansGroupVo starFansGroupVo;

    @ApiModelProperty(value = "是不是爱豆说")
    private Integer isStarSaid;

}
