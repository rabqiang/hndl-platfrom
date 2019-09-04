package com.hndl.cn.mghd.admin;

import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.auth.role.service.AdminPermissionService;
import com.hndl.cn.mghd.admin.auth.role.service.AdminRoleInfoService;
import com.hndl.cn.mghd.admin.auth.role.vo.AddRoleVo;
import com.hndl.cn.mghd.admin.auth.user.service.AdminUserInfoService;
import com.hndl.cn.mghd.admin.auth.user.vo.AddUserInfoVo;
import com.hndl.cn.mghd.admin.business.star.service.StarActiveDataService;
import com.hndl.cn.mghd.admin.business.star.service.StarFansGroupService;
import com.hndl.cn.mghd.admin.business.star.vo.ReceiveStarFansGroupVo;
import com.hndl.cn.mongodb.manager.content.manager.StarCallContentManger;
import com.hndl.cn.mongodb.manager.pay.manager.ApppleCallExceptionLogManager;
import com.hndl.cn.mongodb.manager.star.manager.StarDayRankManager;
import com.hndl.cn.mysql.manager.star.manager.GameStarVoteManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MghdAdminApplicationTests {

    @Resource
    private RedisService redisService;

    @Resource
    private AdminPermissionService adminPermissionService;

    @Resource
    private AdminUserInfoService adminUserInfoService;

    @Resource
    private AdminRoleInfoService adminRoleInfoService;
    @Resource
    private StarCallContentManger starCallContentManger;
    @Resource
    StarFansGroupService starFansGroupService;
    @Resource
    StarDayRankManager starDayRankManager;

    @Resource
    StarActiveDataService starActiveDataService;

    @Resource
    GameStarVoteManager gameStarVoteManager;
    @Resource
    ApppleCallExceptionLogManager apppleCallExceptionLogManager;

    @Test
    public void contextLoads() {
     /*   System.out.println(starActiveDataService.findStarActiveInfoByName("卜凡", 1557763200000L, 1558022400000L));
*/
     String s= "1";
apppleCallExceptionLogManager.insertApppleCallLog(229668384051220480L,277724596847960064L,s);
    }

    @Test
public void gamestar(){
        System.out.println(gameStarVoteManager.getNewStarId());
    }
    @Test
    public void test(){
        String starImg = "http://mghd.oss-cn-hangzhou.aliyuncs.com/temp/min_img/2019-07-26/273021827335520256.jpg";
         AdminUserInfoDo vo = new AdminUserInfoDo();
        vo.setEmail("1234567@qq.com");
        vo.setNickName("产品经理");
        vo.setLoginName("root");
        vo.setMobile("17798988888");
        vo.setId(1L);
        ReceiveStarFansGroupVo build = ReceiveStarFansGroupVo.builder()
                .starName("肖凯中")
                .starImg(starImg)
                .voteCount(0L)
                .voteUserCount(0)
                .starDescription("英雄不问出处 走遍崎岖山路")
                .starType("创造营2019学员")
                .sex("M")
                .fansName("沙麻酱")
                .weiboId("2104498640")
                .build();
        starFansGroupService.insertStarFansGroup(vo,build);
        //starFansGroupService.upsertStarFansGroup(vo,)
    }

    @Test
    public void testAddUserInfo(){
        AddUserInfoVo vo = new AddUserInfoVo();
        vo.setEmail("1234567@qq.com");
        vo.setNickName("产品经理");
        vo.setLoginName("root");
        vo.setMobile("17798988888");
        adminUserInfoService.addAdminUserInfo(vo,1L);
    }

    @Test
    public void testAddRoleInfo(){
        AddRoleVo roleVo = new AddRoleVo();
        roleVo.setRoleName("管理员");
        roleVo.setDescription("他是系统管理员");
        roleVo.setRoleWeight(99);
        adminRoleInfoService.addRole(roleVo,1L);
    }

    @Test
    public void test22(){
        System.out.println(starCallContentManger.countByTime(1L, System.currentTimeMillis(), System.currentTimeMillis()));
    }

    private ISnowflakeIdService iSnowflakeIdService;

    @Test
    public void testId(){

        Set<Long> set = new HashSet<>(1000000);

        for(int i = 0 ; i < 1000000 ; i ++){
            long l = iSnowflakeIdService.nextUserId();
            set.add(l);
        }
        System.out.println("set size  = " + set.size());
    }
}
