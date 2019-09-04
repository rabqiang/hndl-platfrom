package com.hndl.cn.mghd.sys.business.star.service;


import com.hndl.cn.mghd.sys.business.star.vo.StarActivityVo;

import java.util.List;

/**
 * @description: 活动相关
 * @author: 尹争鸣
 * @create: 2019年6月5日19:38:34
 * @Created by 湖南达联
 **/
public interface StarActivityInfoService {

   List<StarActivityVo> findActivity(String typeKey ,Long pageNo);
}
