package com.hndl.cn.chat.sys.business.maesmob.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.hndl.cn.chat.sys.business.maesmob.service.EaseMobTokenService;
import com.hndl.cn.chat.sys.easemob.OrgInfoConfig;
import com.hndl.cn.chat.sys.easemob.enums.EaseMobBusinessEnums;
import com.hndl.cn.utils.http.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 10:44
 * @Created by 湖南达联
 */
@Service
public class EaseMobTokenServiceImpl implements EaseMobTokenService {
    private static final Logger logger = LoggerFactory.getLogger(EaseMobTokenServiceImpl.class);

    @Resource
    private OrgInfoConfig orgInfoConfigConfig;


    private  String accessToken;

    private static  Double EXPIREDAT = -1D;


    @Override
    public String getEaseMobToken() {
        if (accessToken == null || isExpired()) {
            this.initTokenByProp();
        }
        return accessToken;
    }


    private void initTokenByProp() {

        Map map = new HashMap();
        map.put("grant_type", orgInfoConfigConfig.getGrantType());
        map.put("client_id", orgInfoConfigConfig.getClientId());
        map.put("client_secret", orgInfoConfigConfig.getClientSecret());
        String [] parmams = {orgInfoConfigConfig.getSeaemobServerUrl(), orgInfoConfigConfig.getOrgName(),
                orgInfoConfigConfig.getAppName(),EaseMobBusinessEnums.EASE_MOB_TOKEN.getBusinessUrl()};
        logger.info(EaseMobBusinessEnums.getEasemobServeUrl(parmams));
        String data = HttpClientUtil.doPostJson(EaseMobBusinessEnums.getEasemobServeUrl(parmams),JSONObject.toJSONString(map));
        logger.info(data);
        Gson gson = new Gson();
        Map gmap = gson.fromJson(data, Map.class);
        accessToken = " Bearer " + gmap.get("access_token");
        EXPIREDAT = System.currentTimeMillis() + (Double) gmap.get("expires_in");
    }

    private static Boolean isExpired() {
        return System.currentTimeMillis() > EXPIREDAT;
    }
}
