package com.hndl.cn.activity.sys.task;


import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.plugin.snowflakeid.service.impl.SnowflakeIdServiceImpl;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDoExample;
import com.hndl.cn.dao.common.mapper.CommonUserInfoDoMapper;
import com.hndl.cn.utils.collection.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/4/5 15:59
 * @Created by 湖南达联
 */
@Component
public class UserUniIdTask{

    private static final Logger log = LoggerFactory.getLogger(UserUniIdTask.class);

    @Resource
    private CommonUserInfoDoMapper commonUserInfoDoMapper;

    @Resource
    private ISnowflakeIdService iSnowflakeIdService;

//    @Scheduled(cron="0/30 * * * * ? ")
//    public void run(){
//
//        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
//        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
//        criteria.andSysUniIdIsNull();
//        List<CommonUserInfoDo> userInfoDos = commonUserInfoDoMapper.selectByExample(example);
//
//        if(CollectionUtils.isNotEmpty(userInfoDos)){
//            userInfoDos.stream().forEach(user -> {
//                Long userUniId =iSnowflakeIdService.nextUserId();
//                user.setSysUniId(userUniId);
//                commonUserInfoDoMapper.updateByPrimaryKey(user);
//            });
//        }
//        log.info("==================uniId补偿成功=====================");
//
//
//
//    }
}
