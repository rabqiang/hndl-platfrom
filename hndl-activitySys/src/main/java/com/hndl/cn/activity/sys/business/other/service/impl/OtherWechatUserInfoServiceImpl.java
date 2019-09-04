package com.hndl.cn.activity.sys.business.other.service.impl;

import com.hndl.cn.activity.sys.business.other.service.OtherWechatUserInfoService;
import com.hndl.cn.mongodb.manager.extend.manager.OtherWechatUserInfoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/28 18:57
 * @Created by 湖南达联
 */
@Service
public class OtherWechatUserInfoServiceImpl implements OtherWechatUserInfoService {

    private static final Logger log = LoggerFactory.getLogger(OtherWechatUserInfoServiceImpl.class);

    @Resource
    private OtherWechatUserInfoManager otherWechatUserInfoManager;

    @Override
    public void insertOtherWechatUserInfo(Long userUniId, String channelName, String ipAddress) {
        boolean flag = otherWechatUserInfoManager.isExist(userUniId,channelName);

        if(flag){
            log.error("=============推广数据重复插入,userUniId: "+userUniId+",channelName:"+channelName+" ==================");
            return;
        }

        otherWechatUserInfoManager.insertOtherWechatUserInfo(userUniId, channelName, ipAddress);
    }
}
