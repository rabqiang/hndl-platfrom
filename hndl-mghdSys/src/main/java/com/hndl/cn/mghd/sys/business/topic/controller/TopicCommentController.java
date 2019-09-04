package com.hndl.cn.mghd.sys.business.topic.controller;


import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.topic.service.TopicCommentService;
import com.hndl.cn.mghd.sys.business.topic.vo.TopicCommentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
/**
*  @author 尹争鸣
*  @Description TODO
*  @Date  2019年7月30日16:48:04
*  @Created by 湖南达联
*/

@RestController
@RequestMapping("/{source}/topicComment")
@Api( tags = "话题评论相关接口")
public class TopicCommentController {

    @Resource
    private TopicCommentService topicCommentService;

      @ApiOperation(value = "添加话题评论 ", notes = "必须先登陆")
      @CrossOrigin
      @AuthPassport
      @PostMapping("/saveTopicComment")
    public Result<Object> saveTopicComment(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                           @RequestBody TopicCommentVo topicCommentVo){

        topicCommentService.saveTopicComment(commonUserInfoDo,topicCommentVo);
        return ResultFactory.success();
    }



    @ApiOperation(value = "删除话题评论 ", notes = "必须先登陆")
    @CrossOrigin
    @AuthPassport
    @GetMapping("/delTopicComment")
    public Result<Object> delTopicComment(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                          @RequestParam String id){
          topicCommentService.delTopicCommentById(commonUserInfoDo,id);
        return ResultFactory.success();
    }

    @ApiOperation(value = "查询话题评论 ", notes = "必须先登陆")
    @CrossOrigin
    @AuthPassport
    @GetMapping("/findPageTopicComment")
    public  Result<Object> findPageTopicComment(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                                 String objId,@RequestParam Long commentId){
          return   ResultFactory.success(topicCommentService.findPageTopicCommentByTopicIdAndTopicCommentId(objId,commentId));
    }

    @ApiOperation(value = "点赞话题评论 ", notes = "必须先登陆")
    @CrossOrigin
    @AuthPassport
    @GetMapping("/addLike")
    public Result<Object> addLike(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                  @RequestParam Long commentId){
          topicCommentService.addLike(commonUserInfoDo,commentId);
        return ResultFactory.success();
    }

}
