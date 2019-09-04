package com.hndl.cn.mghd.admin.business.appMenu.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 尹争鸣
 * @Description 首页菜单VO
 * @Date 2019年6月20日10:24:24
 * @Created by 湖南达联
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemAppMenuNewVo implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 菜单基础类型（home  首页/  daily 日常福利/ library 应援活动/ star 明星福利）
     */
    private String menuType;

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 菜单类型（h5、itemDetail、shopHome、null）
     */
    private String type;

    /**
     * h5:跳转地址 或者 商品的id
     */
    private String url;

    /**
     * 排序值
     */
    private Integer orderNumber;

    /**
     * 是否默认被选择（y/n）
     */
    private String isSelect;

    /**
     * 图片地址(可选）
     */
    private String imgUrl;

    /**
     * 苹果是否隐藏此菜单 （n  不隐藏/y  隐藏）
     */
    private String other1;

    /**
     * 安卓是否隐藏此菜单 （n  不隐藏/y  隐藏）
     */
    private String other2;

    /**
     * 苹果是否隐藏
     * */
    private String other3;
}
