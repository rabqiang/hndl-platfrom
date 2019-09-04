package com.hndl.cn.mghd.sys.business.menu.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/18 21:58
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMenuVo implements Serializable {

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

}
