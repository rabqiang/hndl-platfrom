package com.hndl.cn.activity.sys;

import com.hndl.cn.mongodb.manager.activity.bean.HappyLibraryShareVoteDo;
import com.hndl.cn.mongodb.manager.activity.manager.HappyLibraryShareVoteManager;
import com.hndl.cn.utils.date.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HndlActivitySysApplicationTests {

    @Resource
    private HappyLibraryShareVoteManager happyLibraryShareVoteManager;

    @Test
    public void contextLoads() {

        Long startTime = System.currentTimeMillis();

        Long endTime  = DateUtil.addDays(new Date(),3).getTime();

        Integer version = 1;

        HappyLibraryShareVoteDo happyLibraryShareVoteDo = new HappyLibraryShareVoteDo();
        happyLibraryShareVoteDo.setVersion(version);
        happyLibraryShareVoteDo.setStartTime(startTime);
        happyLibraryShareVoteDo.setEndTime(endTime);
        happyLibraryShareVoteDo.setGroupId(229668411842678785L);
        happyLibraryShareVoteDo.setGroupName("Mr.洋");
        happyLibraryShareVoteDo.setStarName("迪丽热巴");
        happyLibraryShareVoteDo.setStarId(1L);

        happyLibraryShareVoteManager.insertHappyLibraryShareVote(happyLibraryShareVoteDo);

        happyLibraryShareVoteDo.setId(null);
        happyLibraryShareVoteDo.setGroupId(229053475626078208L);
        happyLibraryShareVoteDo.setGroupName("我想和你去优衣库");
        happyLibraryShareVoteDo.setStarName("彭于晏");
        happyLibraryShareVoteDo.setStarId(26L);

        happyLibraryShareVoteManager.insertHappyLibraryShareVote(happyLibraryShareVoteDo);

        happyLibraryShareVoteDo.setId(null);
        happyLibraryShareVoteDo.setGroupId(229053494227816448L);
        happyLibraryShareVoteDo.setGroupName("粥稀稀");
        happyLibraryShareVoteDo.setStarName("黄子韬");
        happyLibraryShareVoteDo.setStarId(40L);

        happyLibraryShareVoteManager.insertHappyLibraryShareVote(happyLibraryShareVoteDo);

        happyLibraryShareVoteDo.setId(null);
        happyLibraryShareVoteDo.setGroupId(229053531829751808L);
        happyLibraryShareVoteDo.setGroupName("蜗牛");
        happyLibraryShareVoteDo.setStarName("蔡徐坤");
        happyLibraryShareVoteDo.setStarId(52L);

        happyLibraryShareVoteManager.insertHappyLibraryShareVote(happyLibraryShareVoteDo);

        happyLibraryShareVoteDo.setId(null);
        happyLibraryShareVoteDo.setGroupId(229053567573610496L);
        happyLibraryShareVoteDo.setGroupName("寒霜降时石亦寒");
        happyLibraryShareVoteDo.setStarName("宋茜");
        happyLibraryShareVoteDo.setStarId(39L);

        happyLibraryShareVoteManager.insertHappyLibraryShareVote(happyLibraryShareVoteDo);
    }

}
