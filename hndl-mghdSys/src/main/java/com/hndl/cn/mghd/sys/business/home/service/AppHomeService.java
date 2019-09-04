package com.hndl.cn.mghd.sys.business.home.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.call.vo.StarCallContentVo;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description  app首页
 * @Date 2019/5/16 11:16
 * @Created by 湖南达联
 */
public interface AppHomeService {

    /**
     * 初始化app首页相关数据
     * @return
     */
    Result<Object> initAppHomeData(String version,String source,CommonUserInfoDo commonUserInfoDo);

    /**
     * 首页下拉接口
     * @param commonUserInfoDo
     * @param pageNo
     * @return
     */
    Result<List<StarCallContentVo>> findAppHomeStarFansCircle(CommonUserInfoDo commonUserInfoDo, Integer pageNo);
}
