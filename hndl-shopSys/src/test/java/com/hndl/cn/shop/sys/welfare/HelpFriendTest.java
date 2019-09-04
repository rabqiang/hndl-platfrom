package com.hndl.cn.shop.sys.welfare;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.math.NumberEnums;
import com.hndl.cn.base.message.TemplateData;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mongodb.manager.luckdraw.bean.HelpUserWelfareMappingDo;
import com.hndl.cn.mongodb.manager.luckdraw.bean.HelpWelfareDo;
import com.hndl.cn.mongodb.manager.luckdraw.bean.UserWelfareMappingDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.HelpUserWelfareMappingManager;
import com.hndl.cn.mongodb.manager.luckdraw.manager.HelpWelfareManager;
import com.hndl.cn.mongodb.manager.luckdraw.manager.UserWelfareMappingManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.shop.sys.business.help.service.HelpWelfareService;
import com.hndl.cn.shop.sys.business.welfare.vo.WelfarePrizeVo;
import com.hndl.cn.shop.sys.exception.ShopSysException;
import com.hndl.cn.shop.sys.exception.ShopSysExceptionEnums;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import com.hndl.cn.utils.http.HttpClientUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/8/14 10 56
 * @Description:
 * @Author: 资龙茂
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelpFriendTest {

    private static final Logger log = LoggerFactory.getLogger(HelpFriendTest.class);

    @Resource
    private HelpWelfareService helpWelfareService;

    @Resource
    private CommonUserInfoManager commonUserInfoManager;

    @Resource
    private UserWelfareMappingManager userWelfareMappingManager;

    @Resource
    private HelpUserWelfareMappingManager helpUserWelfareMappingManager;

    @Resource
    private HelpWelfareManager helpWelfareManager;

    @Resource
    private RedisService redisService;

    @Value("${wecaht.app.id}")
    private String wechatAppId;

    @Value("${wechat.app.secret}")
    private String wechatAppSecret;

    @Test
    public void findIsJoinUsers() {
        String welfareNumber = "2019082025";
        List<UserWelfareMappingDo> list = userWelfareMappingManager.findUserWelfareByWelfareNumber(welfareNumber, 20);
        list.stream().forEach(System.out::println);
    }

    /**
     * 自动化测试Test
     * 自动上传奖品、抢福利、助力
     * 需要另开一个屏幕查看开奖日志
     */
    @Test
    public void testPlantStart() {
        Random random = new Random();

        // 上传的奖品数, 循环几次就上传几个奖品
        int prizeCount = 4;
        // 开奖所需助力值
        int helpCount = 3000;
        // 开奖结束时间
        Long endTime = 1566307200000L;
        // 抢福利人数
        int userCount = 100;
        // 助力人数
        int helpUserCount = 30;

        // ---------- 上传奖品阶段 start ----------
        for (int i = 1; i <= prizeCount; i++) {
            // 期号
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//获取当前的年月日
            String format = String.format("%02d", helpWelfareManager.countAddCommodity() + 1);
            String welfareNumber = sdf.format(new Date()) + format;
            // 1. 上传奖品
            automaticUploadPrize("江小白七彩内裤",
                    endTime,
                    0,
                    helpCount,
                    2,
                    2,
                    welfareNumber);
            // 2. 查询奖品DO, 安排大部队来抢福利
            HelpWelfareDo helpWelfareDo = helpWelfareManager.findWelfarePrizeByWelfareNumber(welfareNumber);
            for (int j = 974000; j < 974200; j++) {
                // 3. 单个用户参与抢福利
                automaticAskForHelp(Long.valueOf(j), helpWelfareDo.getId(), helpWelfareDo.getPrizeName());
            }
            // 4. 助力完后, 查询出所有助力过的用户
            List<UserWelfareMappingDo> userWelfareMappingDoList = userWelfareMappingManager.findUserWelfareByWelfareNumber(welfareNumber, 10000);
            System.out.println("已经有 " + userWelfareMappingDoList.size() + " 位用户参与了此次抢福利成功~~~");
            for(int hitCount = 0; i < 500; i++) {
                Long userId = random.nextInt(700000) + 130000L;
                // 5. 随机生成好友帮助用户去助力 一百次
                automaticHelpTest(userId, userWelfareMappingDoList.get(random.nextInt(20)).getId(), random.nextInt(5) + 15);
            }
        }
        // ---------- 上传奖品阶段  end ----------

    }

    /**
     * 自动化上传奖品
     * @param prizeName 奖品名
     * @param endTime 抢福利结束时间
     * @param foucaultCount 消耗福卡数
     * @param helpCount 所需助力值
     * @param prizeCount 奖品数量
     * @param sortCount 前多少名才可以获得奖励
     */
    public void automaticUploadPrize(String prizeName,
                                     Long endTime,
                                     Integer foucaultCount,
                                     Integer helpCount,
                                     Integer prizeCount,
                                     Integer sortCount,
                                     String welfareNumber) {
        HelpWelfareDo helpWelfareDo = new HelpWelfareDo();
        // 奖品期号
        helpWelfareDo.setWelfareNumber(welfareNumber);
        // 奖品名称
        helpWelfareDo.setPrizeName(prizeName);
        // 抽奖开始时间
        helpWelfareDo.setStartTime(LocalDateTimeUtil.getNowMinTimeMilli());
        // 抽奖结束时间
        helpWelfareDo.setEndTime(endTime);
        // 消耗福卡数
        helpWelfareDo.setFoucaultCount(foucaultCount);
        // 开奖助力阈值
        helpWelfareDo.setHelpCount(helpCount);
        // 奖品数量
        helpWelfareDo.setPrizeCount(prizeCount);
        //奖品封面图
        helpWelfareDo.setPrizeImg("http://mghd.oss-cn-hangzhou.aliyuncs.com/temp/min_img/2019-08-05/276591869566332928.jpg");
        List<String> prizeImg = new ArrayList<>();
        prizeImg.add("http://mghd.oss-cn-hangzhou.aliyuncs.com/temp/min_img/2019-08-05/276591869566332928.jpg");
        // 奖品详情图
        helpWelfareDo.setDetailsPrizeImg(prizeImg);
        // 奖品描述
        helpWelfareDo.setDescription(helpWelfareDo.getWelfareNumber());
        // 前多少名才可以获得奖励
        helpWelfareDo.setSortCount(sortCount);
        helpWelfareManager.insertHelpWelfare(helpWelfareDo);
        //刷新 redis 缓存
        String key = MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getCacheKey(NumberEnums.ONE.getEnglish());
        //刷新 十条正在开抢的福利商品
        List<WelfarePrizeVo> welfarePrizeVoList = SpringCglibBeanUtils.convertByList(helpWelfareManager.findIsValidWelfarePrize(null), WelfarePrizeVo.class);
        redisService.set(key, welfarePrizeVoList, MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getExpireTime());
        log.info("期号为 " + helpWelfareDo.getWelfareNumber() + " 的奖品【" + helpWelfareDo.getPrizeName()
                + "】上传成功, 所需助力值 " + helpCount + " , 所需福卡 " + foucaultCount + " , 奖品数量 " + prizeCount + " , 前 " + sortCount + " 名才可以中奖");
    }

    /**
     * 自动化 邀请好友助力 / 参与抢福利
     * @param userId 抢福利用户ID
     * @param prizeId 奖品ID
     */
    public void automaticAskForHelp(Long userId, String prizeId, String prizeName) {
        // formId不变
        String formId = "formIdTest";
        // openId不变
        String openId = "openIdTest";
        CommonUserInfoDo commonUserInfoDo = commonUserInfoManager.findUserByUserId(userId);
        helpWelfareService.askForHelp(commonUserInfoDo, prizeId, formId, openId);
        System.out.println("ID为 " + userId + " 的用户参与 " + prizeName + " 的抢福利成功~~~");
    }

    /**
     * 自动化帮助好友助力
     * @param userId 抢福利用户ID
     * @param userWelfareId 抢福利操作ID
     * @param helpCount 增加的助力值
     */
    public void automaticHelpTest(Long userId, String userWelfareId, Integer helpCount) {

        CommonUserInfoDo commonUserInfoDo = commonUserInfoManager.findUserByUserId(userId);
//        CommonUserInfoDo commonUserInfoDo = commonUserInfoManager.findUserByUniId(userUniId);
        if (commonUserInfoDo == null) {
            System.out.println("用户不存在...");
            return;
        }
        // 2. 获取用户邀请助力DO
        UserWelfareMappingDo friendWelfareDo = userWelfareMappingManager.queryUserWelfareById(userWelfareId);
        // 3. 异常情况判断(这里加了个判断,如果是我自己的号,则不判断)
//        if (!userId.equals(867044L)) {
            checkHelpIsValid(commonUserInfoDo, friendWelfareDo);
//        }
        HelpUserWelfareMappingDo helpUserWelfareMappingDo = setValue(commonUserInfoDo, helpCount, friendWelfareDo);
        // 4. 插入帮助好友助力记录
        helpUserWelfareMappingManager.addHelpUserWelfareMapping(helpUserWelfareMappingDo);
        // 5. 更新好友助力值 & 助力人数
        userWelfareMappingManager.addUserWelfareGetHelpCount(friendWelfareDo.getUserUniId(), friendWelfareDo.getWelfareNumber(), friendWelfareDo.getHelpCount() + helpCount, helpCount);
        // 6. 更新福利奖品总助力值
        helpWelfareManager.addHelpUserNowSumCount(friendWelfareDo.getWelfareNumber(), helpCount);
        System.out.println("ID为 " + userId + " 的用户帮助 " + friendWelfareDo.getUserNickName() + " 助力成功~~~" + " 助力值 " + helpCount + " 点");
    }

    @Test
    public void uploadPrize() {
        HelpWelfareDo helpWelfareDo = new HelpWelfareDo();
        // 奖品期号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//获取当前的年月日
        String format = String.format("%02d", helpWelfareManager.countAddCommodity() + 1);
        helpWelfareDo.setWelfareNumber(sdf.format(new Date()) + format);
        // 奖品名称
        helpWelfareDo.setPrizeName("快乐大本营门票");
        // 抽奖开始时间
        helpWelfareDo.setStartTime(LocalDateTimeUtil.getNowMinTimeMilli());
        // 抽奖结束时间
        helpWelfareDo.setEndTime(LocalDateTimeUtil.getNowMaxTimeMilli());
        // 消耗福卡数
        helpWelfareDo.setFoucaultCount(10);
        // 开奖助力阈值
        helpWelfareDo.setHelpCount(100);
        // 奖品数量
        helpWelfareDo.setPrizeCount(1);
        //奖品封面图
        helpWelfareDo.setPrizeImg("http://mghd.oss-cn-hangzhou.aliyuncs.com/temp/min_img/2019-08-05/276591869566332928.jpg");
        List<String> prizeImg = new ArrayList<>();
        prizeImg.add("http://mghd.oss-cn-hangzhou.aliyuncs.com/temp/min_img/2019-08-05/276591869566332928.jpg");
        // 奖品详情图
        helpWelfareDo.setDetailsPrizeImg(prizeImg);
        // 奖品描述
        helpWelfareDo.setDescription("你帮我，我帮你，大家一起抢福利~~");
        // 前多少名才可以获得奖励
        helpWelfareDo.setSortCount(0);
        helpWelfareManager.insertHelpWelfare(helpWelfareDo);
    }

    /**
     * 邀请好友助力 / 参与抢福利
     */
    @Test
    public void askForHelp() {

        // 抢福利用户ID
        Long userId = 100006L;
        // 奖品ID
        String prizeId = "279865420889137152";

        // formId不变
        String formId = "formIdTest";
        // openId不变
        String openId = "openIdTest";
        CommonUserInfoDo commonUserInfoDo = commonUserInfoManager.findUserByUserId(userId);
        helpWelfareService.askForHelp(commonUserInfoDo, prizeId, formId, openId);
    }

    /**
     * 帮助好友助力
     */
    @Test
    public void helpTest() {

        // 抢福利用户ID
        Long userId = 100006L;
        // 抢福利操作ID
        String userWelfareId = "279865420889137152";
        // 助力值
        int helpCount = 20;

        CommonUserInfoDo commonUserInfoDo = commonUserInfoManager.findUserByUserId(userId);
        if (commonUserInfoDo == null) {
            System.out.println("用户不存在...");
            return;
        }
        // 2. 获取用户邀请助力DO
        UserWelfareMappingDo friendWelfareDo = userWelfareMappingManager.queryUserWelfareById(userWelfareId);
        // 3. 异常情况判断(这里加了个判断,如果是我自己的号,则不判断)
        if (!userId.equals(867044L)) {
            checkHelpIsValid(commonUserInfoDo, friendWelfareDo);
        }
        HelpUserWelfareMappingDo helpUserWelfareMappingDo = setValue(commonUserInfoDo, helpCount, friendWelfareDo);
        // 4. 插入帮助好友助力记录
        helpUserWelfareMappingManager.addHelpUserWelfareMapping(helpUserWelfareMappingDo);
        // 5. 更新好友助力值 & 助力人数
        userWelfareMappingManager.addUserWelfareGetHelpCount(friendWelfareDo.getUserUniId(), friendWelfareDo.getWelfareNumber(), friendWelfareDo.getHelpCount() + helpCount, helpCount);
        // 6. 更新福利奖品总助力值
        helpWelfareManager.addHelpUserNowSumCount(friendWelfareDo.getWelfareNumber(), helpCount);
    }

    @Test
    public void sendMessage() {
        sendWechatMessage("e92c3bb2aa1442a4ae5b3f1f81db54e9","ouFc75OHK8QbyPf7gHV-LQ8JjVS0", "2019081933", "周杰伦签名照","2019年8月19日 17:38:19");
    }

    /**
     * 推送小程序消息函数
     * @param formId
     * @param openId
     */
    private void sendWechatMessage(String formId, String openId, String welfareNumber, String prizeName, String successDate) {

        String accessToken = getWeChatAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + accessToken;
        Map<String, TemplateData> map = new HashMap<>();

        TemplateData keyword1 = new TemplateData();
        keyword1.setValue(prizeName);
        map.put("keyword1", keyword1);

        TemplateData keyword2 = new TemplateData();
        keyword2.setValue("已开奖");
        map.put("keyword2", keyword2);

        TemplateData keyword3 = new TemplateData();
        keyword3.setValue(welfareNumber);
        map.put("keyword3", keyword3);

        TemplateData keyword4 = new TemplateData();
        keyword4.setValue(successDate);
        map.put("keyword4", keyword4);

        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("touser", openId);
        sendMap.put("template_id", "tXOYNPBO-jn2G6jk2RYL4_atqsVBhiC8ipdQORD8Kgk");
        sendMap.put("page", "pages/welfare-detail/welfare-detail?welfareNumber=" + welfareNumber);
        sendMap.put("form_id", formId);
        sendMap.put("data", map);
        sendMap.put("emphasis_keyword", "keyword1.DATA");

        sendPost(url, JSONObject.toJSONString(sendMap));
    }

    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("福利开奖成功, 推送消息结果 : " + result);
        return result;
    }

    /**
     * 获取微信access_token
     * @return
     */
    public String getWeChatAccessToken() {
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + wechatAppId +
                "&secret=" + wechatAppSecret;

        String result = HttpClientUtil.doGet(url);

        JSONObject jsonObject = JSONObject.parseObject(result);

        String token = jsonObject.getString("access_token");

        return token;
    }

    /**
     * 检查助力DO是否异常
     * @param commonUserInfoDo "好友"的user对象
     * @param friendWelfareDo "好友"的助力对象
     */
    private void checkHelpIsValid(CommonUserInfoDo commonUserInfoDo, UserWelfareMappingDo friendWelfareDo) {
        // 好友是否已参与过抢福利
        if (friendWelfareDo == null) {
            throw new ShopSysException(ShopSysExceptionEnums.YOUR_FRIEND_NOT_PARTICIPATION.getCode());
        }
        // 是否已帮助此好友助力此奖品
        HelpUserWelfareMappingDo helpUserWelfareMappingDo = helpUserWelfareMappingManager.queryHelpByUserId(friendWelfareDo.getWelfareNumber(), commonUserInfoDo.getSysUniId());
        if (helpUserWelfareMappingDo != null ) {
            throw new ShopSysException(ShopSysExceptionEnums.YOUR_BEEN_INVOLVED.getCode());
        }
        // 今天是否已助力三次
        if (helpUserWelfareMappingManager.queryHelpCountByUserId(commonUserInfoDo.getSysUniId()) >= 3) {
            throw new ShopSysException(ShopSysExceptionEnums.YOUR_HELP_TOO_MUCH.getCode());
        }
    }

    /**
     * 用户参与抢福利对象初始化
     * @param commonUserInfoDo "我"的user对象
     * @param welfarePrize"我"的助力对象
     * @return
     */
    private UserWelfareMappingDo setValue(CommonUserInfoDo commonUserInfoDo, HelpWelfareDo welfarePrize, String formId) {
        UserWelfareMappingDo userWelfareMappingDo = new UserWelfareMappingDo();
        userWelfareMappingDo.setCreateTime(new Date().getTime());
        userWelfareMappingDo.setLastModifyTime(new Date().getTime());
        userWelfareMappingDo.setFromId(formId);
        userWelfareMappingDo.setHelpCount(0);
        userWelfareMappingDo.setIsDelete(IsValidEnums.NO.getValue());
        userWelfareMappingDo.setOpenId(commonUserInfoDo.getWeixinOpenId());
        userWelfareMappingDo.setUserImg(commonUserInfoDo.getPersonImgUrlMin());
        userWelfareMappingDo.setUserNickName(commonUserInfoDo.getNickName());
        userWelfareMappingDo.setUserUniId(commonUserInfoDo.getSysUniId());
        userWelfareMappingDo.setWelfareNumber(welfarePrize.getWelfareNumber());
        userWelfareMappingDo.setId(new Random().nextInt(10000000) + "");
        return userWelfareMappingDo;
    }

    /**
     * 好友帮助用户助力对象初始化
     * @param commonUserInfoDo "好友"的user对象
     * @param helpCount 助力值
     * @param friendWelfareDo "我"的助力对象
     * @return
     */
    private HelpUserWelfareMappingDo setValue(CommonUserInfoDo commonUserInfoDo, Integer helpCount, UserWelfareMappingDo friendWelfareDo) {
        HelpUserWelfareMappingDo helpUserWelfareMappingDo = new HelpUserWelfareMappingDo();
        helpUserWelfareMappingDo.setCreateTime(new Date().getTime());
        helpUserWelfareMappingDo.setHelpCount(helpCount);
        helpUserWelfareMappingDo.setIsDelete(IsValidEnums.NO.getValue());
        helpUserWelfareMappingDo.setUserImg(commonUserInfoDo.getPersonImgUrlMin());
        helpUserWelfareMappingDo.setUserNickName(commonUserInfoDo.getNickName());
        helpUserWelfareMappingDo.setUserUniId(commonUserInfoDo.getSysUniId());
        helpUserWelfareMappingDo.setWelfareNumber(friendWelfareDo.getWelfareNumber());
        helpUserWelfareMappingDo.setHelpUserId(friendWelfareDo.getUserUniId());
        return helpUserWelfareMappingDo;
    }


    /*@Test
    public void nothing() {
        String url="https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + "24_Cpr703Z8iAOQJ8SYGM2vr2ektCAHfS7QoggDoTLN1ZfwiwaAm8o4s5_tvs_8lwN9915PbU2ziHhkKKI0ZLGA4zOLkWQsTnd2_cxoB0L3Og7Wh54_A82QClVZjXYZ23yjGndR-mlnUVgj6LXIPKVbABAUPA";

        JSONObject object = new JSONObject();

        object.put("path", "pages/pratake/pratake");

        String scene = "userWelfareId=111";
        object.put("width", "222");
        object.put("scene", scene);

        String result = HttpClientUtil.doPostJson(url, object.toJSONString());
        System.out.println(result);
    }*/
}
