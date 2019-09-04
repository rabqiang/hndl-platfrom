package com.hndl.cn.mysql.manager.star.manager;

import com.hndl.cn.dao.star.bean.StarActivityInfoDo;

import java.util.List;

public interface StarActivityInfoManager {


    List<StarActivityInfoDo> findActivity(String typeKey,Long pageStart,Integer pageSize);
}
