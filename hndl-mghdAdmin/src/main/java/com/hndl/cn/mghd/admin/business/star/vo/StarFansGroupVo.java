package com.hndl.cn.mghd.admin.business.star.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:hndl-platform
 * @description: 后台粉丝会vo
 * @author: 易成贤
 * @create: 2019-06-19 15:16
 * @Created by湖南达联
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "后台粉丝会vo")
public class StarFansGroupVo implements Serializable {

    @ApiModelProperty("数据ObjId")
    private String id;

    @ApiModelProperty("创建时间")
    private Long createTime;

    @ApiModelProperty("最后更新人id")
    private String lastAdminUserId;

    @ApiModelProperty("是否删除")
    private Integer isDelete;

    @ApiModelProperty("修改时间")
    private Long updateTime;

    @ApiModelProperty("粉丝会id")
    private Long starId;

    @ApiModelProperty("明星名字")
    private String starName;

    @ApiModelProperty("明星头像url")
    private String starImg;

    @ApiModelProperty("总投票数")
    private Long voteCount;

    @ApiModelProperty("投票总用户数")
    private Integer voteUserCount;

    @ApiModelProperty("明星描述")
    private String starDescription;

    @ApiModelProperty("明星类型")
    private String starType;

    @ApiModelProperty("明星性别F/M")
    private Character sex;

    @ApiModelProperty("粉丝名称")
    private String fansName;

    @ApiModelProperty("对应的用户id")
    private Long mappingUserId;

    @ApiModelProperty("微博id")
    private String weiboId;

    @ApiModelProperty("总守护数")
    private Long guardCount;

    @ApiModelProperty("加入粉丝会总人数")
    private Integer userCount;

    @ApiModelProperty("推荐值")
    private Long recommend;


}
