package com.hndl.cn.mysql.manager.system.manager;

import com.hndl.cn.dao.system.bean.SystemAppMenuNewDo;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/23 15:57
 * @Created by 湖南达联
 */
public interface SystemAppMenuNewManager {


    /**
     * 查询app首页菜单
     * @return
     */
    List<SystemAppMenuNewDo> findAppHomeSystemAppMenu();



    /**
     * 根据条件查询
     * */
    List<SystemAppMenuNewDo> findByAppMenu(SystemAppMenuNewDo systemAppMenuNewDo,Integer pageStart, Integer pageSize);


    /**
     * 分页查询app首页菜单
     * @return
     */
    List<SystemAppMenuNewDo> findPageAppHomeSystemAppMenu(Integer pageStart,Integer pageSize);



    /**
     * 新增APP首页菜单
     */
    boolean saveAppMenu(SystemAppMenuNewDo systemAppMenuNewDo);


    /**
     * 修改
     * */
    boolean updateAppMenu(SystemAppMenuNewDo systemAppMenuNewDo);



}
