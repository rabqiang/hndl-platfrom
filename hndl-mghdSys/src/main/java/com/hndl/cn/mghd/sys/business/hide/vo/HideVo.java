package com.hndl.cn.mghd.sys.business.hide.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:hndl-platform
 * @description: 隐藏相关接口
 * @author: 易成贤
 * @create: 2019-06-12 15:08
 * @Created by湖南达联
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HideVo implements Serializable {
    /**
     * 隐藏类型类型
     */
    private Integer type;
    /**
     * 是否隐藏
     */
    private Integer isHide;
}
