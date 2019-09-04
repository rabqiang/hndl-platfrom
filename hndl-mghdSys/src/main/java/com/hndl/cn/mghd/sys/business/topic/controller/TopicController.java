package com.hndl.cn.mghd.sys.business.topic.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.sys.business.topic.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program:hndl-platform
 * @description:TODO 话题
 * @author: 易成贤
 * @create: 2019/7/30 19:44
 * @Created by湖南达联
 **/
@RestController
@RequestMapping("/{source}/topic")
@Api( tags= "话题")
public class TopicController {

    @Resource
    TopicService topicService;

    @ApiOperation("查看话题广场")
    @AuthPassport
    @GetMapping("/findTopicPlaza")
    public Result<Map<String ,Object>> findTopicPlaza(@RequestParam Integer pageNo){
        Map<String, Object> topicPlaza = topicService.findTopicPlaza(pageNo);
        return ResultFactory.success(topicPlaza);
    }

    @ApiOperation("查看话题详细")
    @AuthPassport
    @GetMapping("/findTopicDetail")
    public Result<Map<String ,Object>> findTopicDetail(String id,@RequestParam String topicId,Integer pageNo,@RequestParam Integer isHot){
        Map<String, Object> topicPlaza = topicService.findTopicDetail(id,topicId,pageNo,isHot);
        return ResultFactory.success(topicPlaza);
    }
}
