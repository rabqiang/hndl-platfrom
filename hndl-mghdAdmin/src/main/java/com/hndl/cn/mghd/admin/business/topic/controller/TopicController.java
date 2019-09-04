package com.hndl.cn.mghd.admin.business.topic.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.admin.business.topic.service.TopicService;
import com.hndl.cn.mghd.admin.business.topic.vo.TopicVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 话题公共
 * @author: 易成贤
 * @create: 2019/7/30 11:18
 * @Created by湖南达联
 **/
@RestController
@RequestMapping("/topic")
@Api(tags = "话题")
public class TopicController {


    @Resource
    TopicService topicService;



    @GetMapping("/findAllTopic")
    @AdminLog
   // @AuthPower
    @ApiOperation("查询所有话题")
    public Result<List<TopicVo>> findAllTopic(@ApiParam("用于分页") String id,@ApiParam("搜索参数（暂时无效）") String parameter,@ApiParam("先写死传2") Integer topicStatus,@ApiParam("是否推荐1是0否不写死") Integer isRecommen,@ApiParam("写死传0") Integer isDelete){
        List<TopicVo> allTopic = topicService.findAllTopic(id, parameter, topicStatus,isRecommen,isDelete);
        return ResultFactory.success(allTopic);
    }

}
