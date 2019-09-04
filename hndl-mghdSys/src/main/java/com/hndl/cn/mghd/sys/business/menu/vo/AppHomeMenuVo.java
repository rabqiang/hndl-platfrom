package com.hndl.cn.mghd.sys.business.menu.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/23 16:15
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppHomeMenuVo implements Serializable {

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


}
