package com.hndl.cn.mghd.sys.business.task.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/8/27 16:32
 * @Created by 湖南达联
 */
@ApiModel(value = "用户师父基本信息")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MasterUserVo implements Serializable {


    /**
     * 主键
     */
    @ApiModelProperty(value = "快乐号")
    private Long id;

    /**
     * 个人头像小图片地址(网址)max和min默认一样
     */
    @ApiModelProperty(value = "用户头像(小图)")
    private String personImgUrlMin;

    /**
     * 微信或者qq昵称或者最后自己修改后的昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    /**
     * 系统唯一标识id
     */
    @ApiModelProperty(value = "用户UniId")
    private Long sysUniId;


}
