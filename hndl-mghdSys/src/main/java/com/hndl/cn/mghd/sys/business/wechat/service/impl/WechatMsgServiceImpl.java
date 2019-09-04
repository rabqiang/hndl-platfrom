 package com.hndl.cn.mghd.sys.business.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.shade.org.apache.commons.codec.digest.DigestUtils;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.message.wechat.customer.CustomerImageData;
import com.hndl.cn.base.message.wechat.customer.CustomerTextData;
import com.hndl.cn.base.message.wechat.enums.WechatCustomerEnums;
import com.hndl.cn.dao.wechat.bean.WechatAppletsCustomerMsgConfigDo;
import com.hndl.cn.mghd.sys.business.wechat.service.WechatMsgService;
import com.hndl.cn.mysql.manager.wechat.manager.WechatAppletsCustomerMsgConfigManager;
import com.hndl.cn.utils.http.HttpServletResponseUtil;
import com.hndl.cn.utils.request.RequestUtil;
import com.hndl.cn.utils.wechat.WechatUtils;
import org.assertj.core.util.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/8/26 15:32
 * @Created by 湖南达联
 */
@Service
public class WechatMsgServiceImpl implements WechatMsgService {

    private static final Logger log = LoggerFactory.getLogger(WechatMsgServiceImpl.class);

    @Value("${wechat.msg.token}")
    private String token;

    @Value("${wecaht.app.id}")
    private String appId;

    @Value("${wechat.app.secret}")
    private String appSecret;

    @Resource
    private WechatAppletsCustomerMsgConfigManager wechatAppletsCustomerMsgConfigManager;

    @Override
    public void signature(HttpServletRequest request, HttpServletResponse response) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        log.info("signature : " +  signature + "  ,timestamp : "+ timestamp + " ,nonce  " + nonce + " ,echostr : " + echostr);
        String[] params = new String[]{token, timestamp, nonce};
        // 1、将token、timestamp、nonce三个参数按照字典排序
        Arrays.sort(params);
        // 2、将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder sb = new StringBuilder();
        for (String param : params) {
            sb.append(param);
        }
        try{
            String localSignature = DigestUtils.sha1Hex(sb.toString());
            if(localSignature.equals(signature)){
                HttpServletResponseUtil.responseMsg(response,Long.valueOf(echostr));
            }else {
                HttpServletResponseUtil.responseMsg(response,"");
            }
        }catch (Exception e){
            log.info(" wechat 解码异常:{}",sb.toString());
        }
    }

    @Override
    public void receiveMsg(HttpServletRequest request, HttpServletResponse response) {
        String bodyParm = RequestUtil.getBodyParm(request);
        log.info(bodyParm);
        JSONObject jsonObject = JSONObject.parseObject(bodyParm);
        String toUserName = jsonObject.getString("ToUserName");
        String fromUserName = jsonObject.getString("FromUserName");
        String createTime = jsonObject.getString("CreateTime");
        String msgType = jsonObject.getString("MsgType");
        String content = jsonObject.getString("Content");


        if(WechatCustomerEnums.TEXT.getType().equals(msgType)){
            //查询数据库配置的是否匹配
            WechatCustomerEnums wechatCustomerEnums = WechatCustomerEnums.evalVal(msgType);
            WechatAppletsCustomerMsgConfigDo msgByContent = wechatAppletsCustomerMsgConfigManager.findMsgByContent(wechatCustomerEnums.getCode(), content);

            //查询数据库是否有匹配
            if(msgByContent == null){
               this.switchCustomer(response,fromUserName,toUserName,createTime);
               return;
            }

            String result = null;

            //现在只匹配文本类型和图片类型
            if(WechatCustomerEnums.TEXT.getCode().equals(msgByContent.getResponseMsgType())){
                CustomerTextData customerTextDate = new CustomerTextData();
                customerTextDate.setTouser(fromUserName);
                customerTextDate.setMsgtype(WechatCustomerEnums.TEXT.getType());
                customerTextDate.setText(Maps.newHashMap("content",msgByContent.getResponseMsg()));
                String weChatAccessToken = WechatUtils.getWeChatAccessToken(appId, appSecret);
                result = WechatUtils.sendWechatMsg(weChatAccessToken,JSONObject.toJSONString(customerTextDate));

            }else if(WechatCustomerEnums.IMAGE.getCode().equals(msgByContent.getResponseMsgType())){
                CustomerImageData customerImageData = new CustomerImageData();
                customerImageData.setTouser(fromUserName);
                customerImageData.setMsgtype(WechatCustomerEnums.IMAGE.getType());
                customerImageData.setImage(Maps.newHashMap("media_id",msgByContent.getResponseMsg()));
                String weChatAccessToken = WechatUtils.getWeChatAccessToken(appId, appSecret);
                result = WechatUtils.sendWechatMsg(weChatAccessToken,JSONObject.toJSONString(customerImageData));

            }else {
                //没有匹配则发送回人工处理
                this.switchCustomer(response,fromUserName,toUserName,createTime);
                return;
            }

            log.info("sendWechatMsg result : {}",result);

            HttpServletResponseUtil.responseMsg(response, BaseConstants.SUCESS);
        }
    }



    /***
     * 文档地址：https://mp.weixin.qq.com/debug/wxadoc/dev/api/custommsg/conversation.html
     * 转发至人工客服
     */
    public void switchCustomer(HttpServletResponse response,String fromUserName, String toUserName,String createTime){
        //返回客服默认数据
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("ToUserName",fromUserName);
        resultMap.put("FromUserName",toUserName);
        resultMap.put("CreateTime", createTime);
        resultMap.put("MsgType",WechatCustomerEnums.TRANSFER_CUSTOMER.getType());
        HttpServletResponseUtil.responseMsg(response,JSONObject.toJSONString(resultMap));
    }


    public static void main(String[] args) {
        CustomerImageData customerImageData = new CustomerImageData();
        customerImageData.setTouser("ouFc75CTg8DvbJqW9msU7Y6rzt_Q");
        customerImageData.setMsgtype(WechatCustomerEnums.IMAGE.getType());
        customerImageData.setImage(Maps.newHashMap("media_id","k_jMdsn8lbZDmuEv4N54PWD6SNQqmgNpJKEWF3sVri2oVZVhYpUPDnHmnI5Gm2yD"));
        String weChatAccessToken = WechatUtils.getWeChatAccessToken("wx4b09491c12b811cd", "f8e627532fc1cdfc7108ee00ffa1c47b");
        System.out.println(JSONObject.toJSONString(customerImageData));
        String wechatMsg = WechatUtils.sendWechatMsg(weChatAccessToken,
                JSONObject.toJSONString(customerImageData));
        System.out.println(wechatMsg);
    }

}
