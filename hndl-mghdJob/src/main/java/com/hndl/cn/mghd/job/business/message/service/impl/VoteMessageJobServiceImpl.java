package com.hndl.cn.mghd.job.business.message.service.impl;

import com.hndl.cn.mghd.job.business.message.service.VoteMessageJobService;
import com.hndl.cn.mongodb.manager.message.bean.VoteMessageDo;
import com.hndl.cn.mongodb.manager.message.manager.VoteMessageManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VoteMessageJobServiceImpl implements VoteMessageJobService {

    @Resource
    private VoteMessageManager voteMessageManager;


    @Override
    public void delVoteMessage() {

        VoteMessageDo voteMessage = voteMessageManager.findVoteMessage();

         voteMessageManager.delVoteMessageLtId(voteMessage.getId());

    }
}
