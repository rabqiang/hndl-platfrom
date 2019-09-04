package com.hndl.cn.mghd.admin.business.topic.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.business.topic.service.TopicService;
import com.hndl.cn.mghd.admin.business.topic.vo.TopicStatusVo;
import com.hndl.cn.mghd.admin.business.topic.vo.TopicVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 审核人员控制层
 * @author: 易成贤
 * @create: 2019/7/30 14:03
 * @Created by湖南达联
 **/
@RestController
@RequestMapping("/topicCheck")
@Api(tags = "话题审核管理")
public class TopicCheckController {

    @Resource
    TopicService topicService;

    @GetMapping("/findTopicById")
    @AdminLog
    //@AuthPower
    @ApiOperation("查看单个话题")
    Result<TopicVo> findTopicById(String id){
        return topicService.findTopicById(id);
    }

    @GetMapping("/passTopic")
    @AdminLog
   // @AuthPower
    @ApiOperation("通过话题")
    Result passTopic(String id){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return topicService.passTopic(loginUser,id);
    }

    @GetMapping("/noPassTopic")
    @AdminLog
   // @AuthPower
    @ApiOperation("不通过话题")
    public Result noPassTopic(String id){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return topicService.noPassTopic(loginUser,id);
    }


    @GetMapping("/findAllTopic")
    @AdminLog
    //@AuthPower
    @ApiOperation("审核人员查询所有话题")
    public Result<List<TopicVo>> findAllTopic(String id, Integer topicStatus){
        List<TopicVo> allTopic = topicService.findAllCheckTopic(id, topicStatus);
        return ResultFactory.success(allTopic);
    }

    @GetMapping("/unPublishedTopic")
    @AdminLog
    // @AuthPower
    @ApiOperation("取消发布话题")
    public Result unPublishedTopic(String id){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return topicService.unPublishedTopic(loginUser,id);
    }
    @AdminLog
   // @AuthPower
    @GetMapping("/findCheckStatus")
    @ApiOperation("查询审核人员所得的状态")
    public Result<List<TopicStatusVo>> findCheckStatus(){
        return topicService.findCheckStatus();
    }

}
