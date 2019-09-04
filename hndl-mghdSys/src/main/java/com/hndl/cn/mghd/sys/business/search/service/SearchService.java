package com.hndl.cn.mghd.sys.business.search.service;

import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.search.vo.FansGroupVo;

import java.util.List;
import java.util.Map;

/**
 * @program:hndl-platform
 * @description: 搜索
 * @author: 易成贤
 * @create: 2019-05-27 17:42
 * @Created by湖南达联
 **/
public interface SearchService {

    /**
     * 搜索粉丝会
     * @param commonUserInfoDo
     * @param keyWords 关键字
     * @return 相匹配的粉丝会列表
     */
    List<FansGroupVo> searchFansGroup(CommonUserInfoDo commonUserInfoDo, String keyWords);

    /**
     * 搜索推荐列表
     * @param commonUserInfoDo
     * @return
     */
    Map<String, List<FansGroupVo>> searchRecommend(CommonUserInfoDo commonUserInfoDo);
}
