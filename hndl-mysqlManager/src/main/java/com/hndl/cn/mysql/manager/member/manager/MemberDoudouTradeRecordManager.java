package com.hndl.cn.mysql.manager.member.manager;

import com.github.pagehelper.PageInfo;
import com.hndl.cn.dao.member.bean.MemberDoudouTradeRecordDo;

import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/7/8 10:18
 * @Created by 湖南达联
 */
public interface MemberDoudouTradeRecordManager {

    /**
     * 查询用户记录为领取
     * @param userId
     * @return
     */
    PageInfo<MemberDoudouTradeRecordDo> getMasterList(Long userId, Integer pageNo,Integer pageSize);
}
