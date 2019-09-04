package com.hndl.cn.mghd.admin.business.menu.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/7/5 14 35
 * @Description:
 * @Author: 资龙茂
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMenuVo implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片
     */
    private String imgUrl;

    /**
     * 跳转类型：h5、itemDetail、shopHome、recharge、null
     */
    private String toType;

    /**
     * 跳转地址
     */
    private String toUrl;

    /**
     * 是否针对苹果客户端隐藏此菜单(y/n)
     */
    private String isIosHide;

    /**
     * 排序值：排序规则（数字越大越靠前）
     */
    private Integer orderNumber;

}
