package com.hndl.cn.chat.sys;


import com.hndl.cn.base.result.Result;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobRequestRoomParam;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobRequestUserParam;
import com.hndl.cn.chat.sys.business.maesmob.service.EaseMobChatRoomService;
import com.hndl.cn.chat.sys.business.maesmob.service.EaseMobTokenService;
import com.hndl.cn.chat.sys.business.room.service.SysChatRoomService;
import com.hndl.cn.chat.sys.business.room.service.SysSendMessageService;
import com.hndl.cn.chat.sys.business.room.service.SysUserInfoService;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.dao.game.mapper.GameStarVoteDoMapper;
import com.hndl.cn.dao.game.mapper.GameStarVoteExpressDoMapper;
import com.hndl.cn.dao.star.mapper.StarWeiboRelationDoMapper;
import com.hndl.cn.mongodb.manager.easemob.bean.EaseMobUserInfoDo;
import com.hndl.cn.mongodb.manager.easemob.manager.EaseMobUserInfoManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HndlChatSysApplicationTests {




    @Resource
    private SysChatRoomService sysChatRoomService;

    @Resource
    private EaseMobTokenService easeMobTokenService;

    @Resource
    private EaseMobChatRoomService easeMobChatRoomService;

    @Resource
    private SysUserInfoService sysUserInfoService;

    @Resource
    private SysSendMessageService sysSendMessageService;

    @Resource
    private EaseMobUserInfoManager easeMobUserInfoManager;

    @Test
    public void testMongo() {
        EaseMobUserInfoDo easeMobUserInfoDo = EaseMobUserInfoDo.builder().isValid(1).modifyTime(System.currentTimeMillis())
                .createTime(System.currentTimeMillis()).sysUniUserId(111L).easeMobNickname("111")
                .easeMobUuid(UUID.randomUUID().toString()).easeMobUserType("enums").build();
        easeMobUserInfoManager.insertEaseMobUserInfo(easeMobUserInfoDo);
    }

    @Test
    public void tokenTest() {
        String token = easeMobTokenService.getEaseMobToken();
        System.out.println(token);
    }


    @Test
    public void contextLoads() {

        EaesMobRequestUserParam param = EaesMobRequestUserParam.builder().username("12345678111").password("abcde111faaa")
                .nickname("汪海").build();
//        String json  = JSONObject.toJSONString(param);
//        System.out.println(json);
//        EaseMobUserInfoDo msg = easeMobIMUserService.createNewIMUserSingle(json);
//        System.out.println(msg);
    }

    @Test
    public void roomTest() {
        EaesMobRequestRoomParam eaesMobRequestRoomParam =
                EaesMobRequestRoomParam.builder().name("测试聊天室").owner("12345678").description("这是一个测试").build();

        easeMobChatRoomService.createChatRoom(eaesMobRequestRoomParam);

    }

    @Test
    public void roomDetailTest() {
        EaesMobRequestRoomParam eaesMobRequestRoomParam = EaesMobRequestRoomParam.builder()
                .name("测试聊天室").owner("12345678").description("这是一个测试").build();

        easeMobChatRoomService.getChatRoomDetail("77427592200195");

    }

    @Test
    public void addSingleUserToChatRoom() {
        easeMobChatRoomService.addSingleUserToChatRoom("77427592200195", "wanghai123");
    }

    @Test
    public void testSysUserService() {
        CommonUserInfoDo commonUserInfoDo = new CommonUserInfoDo();
        commonUserInfoDo.setSysUniId(226629310402973696L);
        commonUserInfoDo.setNickName("年少有你、青春有我");
        Result<Object> objectResult = sysUserInfoService.insertEaseMobUser(commonUserInfoDo);
        System.out.println(objectResult.getCode() + objectResult.getMessage());
        System.out.println(objectResult.getData().toString());
    }

    @Test
    public void testSysRoomService() {
        CommonUserInfoDo commonUserInfoDo = new CommonUserInfoDo();
        commonUserInfoDo.setSysUniId(226629310402973696L);
        commonUserInfoDo.setNickName("年少有你、青春有我");
        commonUserInfoDo.setId(10182L);
        Result<Object> objectResult = sysChatRoomService.addFansGroupChatRoomOrUserToRoom(commonUserInfoDo, 1L);
        System.out.println(objectResult.getCode() + objectResult.getMessage());
        System.out.println(objectResult.getData().toString());
    }

    @Test
    public void testSysMsgService() {

        while (true) {
            Result<Object> objectResult = sysSendMessageService.sendTxtMessage(
                    226631727722975232L, "我是来测试", "77450973347841");
            System.out.println(objectResult.getCode() + objectResult.getMessage());
            try {
                Thread.sleep(20000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //测试刷入数据
    @Resource
    StarFansGroupManager starFansGroupManager;
    @Resource
    GameStarVoteDoMapper gameStarVoteDoMapper;


    @Resource
    GameStarVoteExpressDoMapper gameStarVoteExpressDoMapper;
   @Resource
   StarWeiboRelationDoMapper starWeiboRelationDoMapper;





       /* //用户获取指定粉丝会投票的人数
        GameStarRecordDoExample example = new GameStarRecordDoExample();
        example.createCriteria().andIsDeletedEqualTo("n").andIdEqualTo(gameStarVoteDo.getId());
        long count = gameStarRecordDoMapper.countByExample(example);*/



    @Resource
    private RedisService redisService;

    @Test
    public void testRedisLock() {
        String key = "redis_lock_key";
        boolean flag = redisService.setNX(key, "111", 100L);
        System.out.println("redis_lock_key   " + flag);
        if (flag) {
//           boolean isDel = redisService.delNX(key);
//           System.out.println("isDelNX  " + isDel);
            boolean exists = redisService.exists(key);
            System.out.println("redis lock exists " + exists);
        }

    }
//

}
