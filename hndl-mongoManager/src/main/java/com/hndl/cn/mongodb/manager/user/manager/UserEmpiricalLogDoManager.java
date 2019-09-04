package com.hndl.cn.mongodb.manager.user.manager;

import com.hndl.cn.mongodb.manager.user.bean.UserEmpiricalLogDo;

import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/4/19 14:43
 * @Created by 湖南达联
 */
public interface UserEmpiricalLogDoManager {



    /**
     * 获取新增用户经验纪录。
     * @param  userEmpiricalLogDo
     */
    void UserEmpiricalLogDoAddEmpiricalCount(UserEmpiricalLogDo userEmpiricalLogDo);


    /**
     * 查询用户经验日志
     * @param userUinId      用户id
     * @param id      _id
     * @param pageSize       每页几条数据
     */

    List<UserEmpiricalLogDo> findUserEmpiricalLogDo(Long userUinId,String id,Integer pageSize);


}
