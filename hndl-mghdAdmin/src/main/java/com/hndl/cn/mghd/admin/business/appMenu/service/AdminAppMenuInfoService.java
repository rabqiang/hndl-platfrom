package com.hndl.cn.mghd.admin.business.appMenu.service;


import com.hndl.cn.mghd.admin.business.appMenu.vo.SystemAppMenuNewVo;

import java.util.List;

/**
 * @author 尹争鸣
 * @Description 首页头部菜单管理
 * @Date 2019年6月19日11:51:52
 * @Created by 湖南达联
 * */
public interface AdminAppMenuInfoService {


    /**
     * 分页查询（列表展示）
     * */
    List<SystemAppMenuNewVo> findPageAppMenu(Integer pageStart);


    /**
    * 根据条件查询
    * */
    List<SystemAppMenuNewVo> findByAppMenu(SystemAppMenuNewVo systemAppMenuNewVo,Integer pageStart);

    /**
     * 新增
     */
    boolean saveAppMenu(SystemAppMenuNewVo systemAppMenuNewVo);



    /**
     * 修改
     * */
    boolean updateAppMenu(SystemAppMenuNewVo systemAppMenuNewVo);


    /**
     * 删除
     * */
    boolean removeAppMenu(Long id);

}
