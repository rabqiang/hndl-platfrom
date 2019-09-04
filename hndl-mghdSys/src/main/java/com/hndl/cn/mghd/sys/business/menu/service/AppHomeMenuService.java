package com.hndl.cn.mghd.sys.business.menu.service;

import com.hndl.cn.mghd.sys.business.menu.vo.AppHomeMenuVo;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/23 16:15
 * @Created by 湖南达联
 */
public interface AppHomeMenuService {


    /**
     * 获取首页菜单
     * @param source
     * @param version
     * @return
     */
    List<AppHomeMenuVo> findAppHomeMenu(String source,String version);
}
