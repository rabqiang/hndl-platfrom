package com.hndl.cn.activity.sys.business.other.controller;

import com.hndl.cn.activity.sys.business.other.service.OtherWechatUserInfoService;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/28 19:02
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/other/wechat")
public class OtherWechatUserController {

    @Resource
    private OtherWechatUserInfoService otherWechatUserInfoService;


    @GetMapping("/insertOtherWechatUserInfo")
    @CrossOrigin
    public Result<Object> findHappyLibraryByVersion(@RequestParam Long userUniId,
                                                    @RequestParam String channelName,
                                                    @RequestParam String ipAddress){


        otherWechatUserInfoService.insertOtherWechatUserInfo(userUniId, channelName, ipAddress);
        return ResultFactory.success();
    }
}
