package com.hndl.cn.mysql.manager.member.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hndl.cn.dao.member.bean.MemberDoudouTradeRecordDo;
import com.hndl.cn.dao.member.bean.MemberDoudouTradeRecordDoExample;
import com.hndl.cn.dao.member.mapper.MemberDoudouTradeRecordDoMapper;
import com.hndl.cn.mysql.manager.member.manager.MemberDoudouTradeRecordManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/7/8 10:18
 * @Created by 湖南达联
 */
@Service
public class MemberDoudouTradeRecordManagerImpl implements MemberDoudouTradeRecordManager {
    @Resource
    private MemberDoudouTradeRecordDoMapper memberDoudouTradeRecordDoMapper;

    @Override
    public PageInfo<MemberDoudouTradeRecordDo> getMasterList(Long userId, Integer pageNo, Integer pageSize) {
        MemberDoudouTradeRecordDoExample example = new MemberDoudouTradeRecordDoExample();
        MemberDoudouTradeRecordDoExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        example.setOrderByClause("create_time DESC");
        PageHelper.startPage(pageNo, pageSize);
        List<MemberDoudouTradeRecordDo> coinBillInfoDos = memberDoudouTradeRecordDoMapper.selectByExample(example);
        PageInfo<MemberDoudouTradeRecordDo> pageInfo = new PageInfo<>(coinBillInfoDos);

        List<MemberDoudouTradeRecordDo> list = pageInfo.getList();
        return null != pageInfo ? pageInfo : null;
    }
}
