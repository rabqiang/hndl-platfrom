package com.hndl.cn.mghd.job.business.welfaremall.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.message.TemplateData;
import com.hndl.cn.mghd.job.business.welfaremall.service.MessageService;
import com.hndl.cn.mghd.job.exception.MghdJobSysException;
import com.hndl.cn.mghd.job.exception.MghdJobSysExceptionEnums;
import com.hndl.cn.mongodb.manager.luckdraw.bean.HelpWelfareDo;
import com.hndl.cn.mongodb.manager.luckdraw.bean.UserWelfareMappingDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.HelpWelfareManager;
import com.hndl.cn.mongodb.manager.luckdraw.manager.UserWelfareMappingManager;
import com.hndl.cn.utils.date.DateUtil;
import com.hndl.cn.utils.wechat.WechatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/8/16 21 49
 * @Description:
 * @Author: 资龙茂
 */
@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Resource
    private HelpWelfareManager helpWelfareManager;

    @Resource
    private UserWelfareMappingManager userWelfareMappingManager;

    @Value("${wecaht.app.id}")
    private String wechatAppId;

    @Value("${wechat.app.secret}")
    private String wechatAppSecret;

    @Value("${wechat.template.id}")
    private String template_id;

    @Override
    public void welfarePrizeLottery(@NotNull String welfareNumber) {
        HelpWelfareDo helpWelfareDo = helpWelfareManager.findWelfarePrizeByWelfareNumber(welfareNumber);
        // 1. 判断奖品是否为空
        if (helpWelfareDo == null) {
            log.error(" ------ 期号为 " + welfareNumber + "的奖品消息推送失败, 请检查期号 & 奖品是否正常 ------");
            throw new MghdJobSysException(MghdJobSysExceptionEnums.SEND_WECHAT_MESSAGE_FAIL.getCode());
        }
        List<UserWelfareMappingDo> userWelfareMappingDoList = userWelfareMappingManager.findUserWelfareByWelfareNumber(welfareNumber, null);
        // 2. 循环遍历参与过抢福利的用户
        for (UserWelfareMappingDo userWelfareMappingDo : userWelfareMappingDoList) {
            // 3. 判断用户推送消息凭证是否正常
            if (userWelfareMappingDo.getFromId() != null && userWelfareMappingDo.getOpenId() != null) {
                // 4. 推送消息
                try {
                    this.sendWechatMessage(userWelfareMappingDo.getFromId(),
                            userWelfareMappingDo.getOpenId(),
                            welfareNumber,
                            helpWelfareDo.getPrizeName(),
                            DateUtil.getformatToStringDate(new Date(helpWelfareDo.getSuccessTime())));
                } catch (Exception e) {
                    log.error(" ------ 用户ID为 " + userWelfareMappingDo.getUserUniId() + "的用户消息推送失败, 异常信息：" + e.getMessage() + " ------");
                }
            } else {
                log.error(" ------ 用户ID为 " + userWelfareMappingDo.getUserUniId() + "的用户没有精确信息, 无法推送消息 ------");
            }
        }
        log.info(" ------ 期号为 " + welfareNumber + "的奖品消息推送成功, 已推送给 " + userWelfareMappingDoList.size() + " 位用户 ------");
    }

    /**
     * 推送小程序消息函数
     * @param formId
     * @param openId
     */
    private void sendWechatMessage(String formId, String openId, String welfareNumber, String prizeName, String successDate) {

        String accessToken = WechatUtils.getWeChatAccessToken(wechatAppId, wechatAppSecret);
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
        sendMap.put("template_id", template_id);
        sendMap.put("page", "pages/welfare-detail/welfare-detail?welfareNumber=" + welfareNumber + "&isMessage=1");
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
        return result;
    }
}
