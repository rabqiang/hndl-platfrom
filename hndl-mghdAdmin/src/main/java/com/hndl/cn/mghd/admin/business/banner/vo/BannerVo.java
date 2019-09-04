package com.hndl.cn.mghd.admin.business.banner.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/6/26 14 45
 * @Description:
 * @Author: 资龙茂
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ApiModel(value = "轮播图VO类")
public class BannerVo implements Serializable {

    /** ID */
    @ApiModelProperty("bannerID")
    private Long id;

    /** 轮播图的地址 */
    @Pattern(regexp = "http:/\\/mghd.oss-cn-hangzhou.aliyuncs.com\\/(temp|formal\\/banner)\\/[a-zA-Z]{3}_img\\/+(\\d{4}-\\d{2}-\\d{2})\\/\\d{18}.(jpg|png|gif|JPG|PNG|GIF)")
    @ApiModelProperty("轮播图url")
    private String imgUrl;

    /** 格式：跳转类型;跳转地址（db存：网站/栏目列表/视频播放/直播/商品详情/NULL代表无跳转） */
    @ApiModelProperty("格式：跳转类型;跳转地址")
    private String httpUrl;

    /** 开始日期 */
    @NotNull
    @ApiModelProperty("开始日期")
    private Date startDate;

    /** 结束日期 */
    @NotNull
    @ApiModelProperty("结束日期")
    private Date endDate;

    /** 排序值, 数字越大越靠前 */
    @Min(1)
    @ApiModelProperty("排序值, 数字越大越靠前")
    private Integer orderNum;

    /** 轮播图的描述  */
    @ApiModelProperty("轮播图的描述")
    private String adDesc;

    /** 模块位置 */
    @NotNull
    @ApiModelProperty("模块位置")
    private String model;

    /** 是否有效 (0无效, 1有效) */
    @ApiModelProperty("是否有效 (0无效, 1有效)")
    private Integer isValid;
}
