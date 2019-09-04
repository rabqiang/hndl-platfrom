package com.hndl.cn.mghd.admin.business.topic.controller;


import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.topic.service.TopicCommentService;
import com.hndl.cn.mghd.admin.business.topic.vo.TopicCommentVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
*  @author 尹争鸣
*  @Description 话题评论
*  @Date  2019年8月6日17:24:14
*  @Created by 湖南达联
*/

@RestController
@RequestMapping("/topicComment")
@Api(tags = "话题评论管理")
public class TopicCommentController {

    @Resource
    private TopicCommentService topicCommentService;

    @GetMapping("/findPageTopicComment")
    @AdminLog
    // @AuthPower
    @ApiOperation("查询所有话题评论")
    public Result<List<TopicCommentVo>> findPageTopicComment(String id,String nikeName,String topicId,Long userUniId){

        return  topicCommentService.findPageTopicComment(id, nikeName, topicId, userUniId);
    }


    @GetMapping("/delTopicCommentById")
    @AdminLog
    // @AuthPower
    @ApiOperation("删除话题评论")
    public  Result<Object> delTopicCommentById(@RequestBody String id){

        return   topicCommentService.deleteTopicCommentById(id);
    }


}
