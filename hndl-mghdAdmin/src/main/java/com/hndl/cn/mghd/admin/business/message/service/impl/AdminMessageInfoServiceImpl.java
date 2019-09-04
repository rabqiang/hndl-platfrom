package com.hndl.cn.mghd.admin.business.message.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.message.MessageTypeEnums;
import com.hndl.cn.base.lock.RedisLockKey;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.admin.business.message.service.AdminMessageInfoService;
import com.hndl.cn.mghd.admin.business.message.vo.AdminMessageVo;
import com.hndl.cn.mghd.admin.common.constants.MgdAdminConstants;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mghd.admin.exception.MghdAdminExceptionEnums;
import com.hndl.cn.mongodb.manager.message.bean.UserMessageDo;
import com.hndl.cn.mongodb.manager.message.manager.UserMessageManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.reg.RegExUtil;
import com.hndl.cn.utils.sms.SmsUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年6月21日14:04:45
 * @Created by 湖南达联
*/

@Service
public class AdminMessageInfoServiceImpl implements AdminMessageInfoService {

    private static final Logger log = LoggerFactory.getLogger(AdminMessageInfoServiceImpl.class);

    @Resource
    private UserMessageManager userMessageManager;

    @Resource
    private CommonUserInfoManager commonUserInfoManager;

    @Resource
    private RedisService redisService;


    @Override
    public void saveMessage(AdminMessageVo adminMessageVo) {

        String lockKey = RedisLockKey.builderRedisKey(MgdAdminConstants.INIT_CHAT_MESSAGE_REDIS_NAME, adminMessageVo.getCreateUserId());

        boolean exists = redisService.exists(lockKey);

        log.info("锁是否存在:" + exists + "  lockKey:" + lockKey);
        if (exists) {
            throw new MghdAdminException(
                    MghdAdminExceptionEnums.MGHD_MESSAGE_SYS_EX_EASE_MOB_CREATE_RUN_TIME_ERROR.getCode());
        }

        //加锁,因为redis是单线程的，如果失败，则是因为这个锁已经存在
        boolean nxFlag = false;
        try {

            nxFlag = redisService.setNX(lockKey, RedisLockKey.DEFAULT_VALUE, MgdAdminConstants.INIT_CHAT_MESSAGE_REDIS_TIME_OUT);
            log.info("是否成功获取到锁:" + nxFlag + "  lockKey:" + lockKey);
            if (!nxFlag) {
                throw new MghdAdminException(
                        MghdAdminExceptionEnums.MGHD_MESSAGE_SYS_EX_EASE_MOB_CREATE_RUN_TIME_ERROR.getCode());
            }


            UserMessageDo userMessageDo = new UserMessageDo();
            //是否全局通知
            if (StringUtils.isBlank(adminMessageVo.getSendUserId())) {
                userMessageDo = SpringCglibBeanUtils.convert(adminMessageVo, UserMessageDo.class);
                //0 是发送给所有人
                userMessageDo.setSendUserId(0L);
                JSONObject json = new JSONObject();
                //是否发送短信  1 YES  0 NO
                json.put("isSms", adminMessageVo.getIsSms());
                //添加消息
                userMessageManager.insertUserMessageDo(userMessageDo);
                //分页获取用户电话号码信息 每次1000条
                if (adminMessageVo.getIsSms().equals(IsValidEnums.YES.getValue())) {
                    PageInfo<CommonUserInfoDo> pageInfo = commonUserInfoManager.findUserGetNumberById(0L, 1, 1000);
                    for (int i = 2; i < pageInfo.getPages(); i++) {
                        for (CommonUserInfoDo commonUserInfoDo : pageInfo.getList()) {
                            this.sendSms(commonUserInfoDo, adminMessageVo.getContent());
                        }
                        pageInfo = commonUserInfoManager.findUserGetNumberById(0L, i, 1000);
                    }
                }
            } else {
                List<String> sendUserIdList = Arrays.asList(adminMessageVo.getSendUserId().split(","));
                //不是全局通知的情况下 ，可以发送给多人

                for (int i = 0; i < sendUserIdList.size(); i++) {
                    userMessageDo = SpringCglibBeanUtils.convert(adminMessageVo, UserMessageDo.class);

                    userMessageDo.setSendUserId(Long.parseLong(sendUserIdList.get(i)));
                    JSONObject json = new JSONObject();
                    //是否发送短信  1 YES  0 NO
                    json.put("isSms", adminMessageVo.getIsSms());
                    //添加消息
                    userMessageManager.insertUserMessageDo(userMessageDo);
                    //是否发送短信
                    if (adminMessageVo.getIsSms().equals(IsValidEnums.YES.getValue())) {
                        //获取接受短信人的信息
                        CommonUserInfoDo userByUniId = commonUserInfoManager.findUserByUniId(Long.parseLong(sendUserIdList.get(i)));
                        //发送短信
                        this.sendSms(userByUniId, adminMessageVo.getContent());
                    }
                }
            }
        } finally {

            //删除锁
            if (nxFlag) {
                boolean isDelNX = redisService.delNX(lockKey);
                log.info("是否成功删除锁:" + isDelNX + "  lockKey : " + lockKey);
            }
        }


    }




    @Override
    public List<AdminMessageVo> findByMessage(AdminMessageVo adminMessageVo, Long messageId) {

        UserMessageDo userMessageDo = SpringCglibBeanUtils.convert(adminMessageVo, UserMessageDo.class);
        List<UserMessageDo> byUserMessage = userMessageManager.findByUserMessage(userMessageDo,MessageTypeEnums.SYS_MSG.getType(), messageId, MgdAdminConstants.PAGE_LIMIT);
        List<AdminMessageVo> adminMessageVoList = new ArrayList<>();
        for (UserMessageDo userMessage : byUserMessage) {
            AdminMessageVo adminMessage = SpringCglibBeanUtils.convert(userMessage, AdminMessageVo.class);
            adminMessage.setSendUserId(userMessage.getSendUserId().toString());
            //是否发送短信
            adminMessage.setIsSms(this.getSms(userMessage.getExpandJson()));

            adminMessageVoList.add(adminMessage);
        }
        return null == adminMessageVoList ? new ArrayList<>() : adminMessageVoList;
    }


    @Override
    public void updateMessage(AdminMessageVo adminMessageVo) {
        UserMessageDo userMessageDo = SpringCglibBeanUtils.convert(adminMessageVo, UserMessageDo.class);
        userMessageDo.setSendUserId(Long.parseLong(adminMessageVo.getSendUserId()));
        JSONObject json = new JSONObject();
        //是否发送短信  1 YES  0 NO
        json.put("isSms", adminMessageVo.getIsSms());
        userMessageDo.setExpandJson(json.toString());
        userMessageManager.updateByMessageId(userMessageDo);
        //是否发送短信
        if (adminMessageVo.getIsSms().equals(IsValidEnums.YES.getValue())) {
            //获取电话号码
            CommonUserInfoDo userByUserId = commonUserInfoManager.findUserByUniId(Long.parseLong(adminMessageVo.getSendUserId()));
            //发送短信
            this.sendSms(userByUserId, adminMessageVo.getContent());
        }
    }


    @Override
    public void removeMessage(Long messageId) {
        UserMessageDo userMessageDo = new UserMessageDo();

        userMessageDo.setMessageId(messageId);
        userMessageDo.setIsDelete(IsValidEnums.YES.getValue());
        userMessageManager.updateByMessageId(userMessageDo);
    }


    private Integer getSms(String expandJson) {
        if (StringUtils.isNotBlank(expandJson)) {
            JSONObject jsonObject = JSONObject.parseObject(expandJson);
            if (null != jsonObject.getString("isSms"))
                return new Integer(jsonObject.getString("isSms"));
        }
        return 0;

    }


    // 符合条件 执行发送短信 不符合就什么都不做
    private void sendSms(CommonUserInfoDo userByUniId, String content) {
        if (null != userByUniId) {
            if (StringUtils.isNotBlank(String.valueOf(userByUniId.getPhoneNumPerson())) && RegExUtil.isPhoneLegal(String.valueOf(userByUniId.getPhoneNumPerson()))) {
                //发送消息
                SmsUtil.sendSms(String.valueOf(userByUniId.getPhoneNumPerson()), "【快乐粉丝会】" + content);
            }

        }
    }
}
