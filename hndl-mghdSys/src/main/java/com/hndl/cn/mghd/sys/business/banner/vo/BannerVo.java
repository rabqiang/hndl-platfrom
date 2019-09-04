package com.hndl.cn.mghd.sys.business.banner.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 赵俊凯
 * @Description BannerVo
 * @Date 2019/4/29 17:30
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BannerVo implements Serializable {

    /**
     * 轮播图的地址
     */
    private String imgUrl;

    /**
     * 格式：跳转类型;跳转地址（db存：网站/栏目列表/视频播放/直播/商品详情/NULL代表无跳转）
     */
    private String httpUrl;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 排序值
     */
    private Integer orderNum;

    /**
     * 模块位置（db存：home/shopHome/appStart）互动的轮播图、夺宝的轮播图/app启动页面
     */
    private String model;

    /**
     * 图片的本地的绝对目录，后台存阿里云，这个字段作废
     */
    private String img;

}
