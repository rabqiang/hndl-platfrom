package com.hndl.cn.mghd.admin.business.topic.controller;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.business.resources.service.ResourcesService;
import com.hndl.cn.mghd.admin.business.topic.service.TopicService;
import com.hndl.cn.mghd.admin.business.topic.vo.ReceiveTopicVo;
import com.hndl.cn.mghd.admin.business.topic.vo.TopicStatusVo;
import com.hndl.cn.mghd.admin.business.topic.vo.TopicVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.utils.file.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 编辑人员控制层
 * @author: 易成贤
 * @create: 2019/7/30 14:05
 * @Created by湖南达联
 **/
@RestController
@RequestMapping("/topicEdit")
@Api(tags = "话题编辑管理")
public class TopicEditController {
    @Resource
    private ResourcesService resourcesService;

    @Resource
    TopicService topicService;

    @PutMapping("/updateTopic/{id}")
    @AdminLog
    //@AuthPower
    @ApiOperation("更新话题")
    public Result updateTopic(@PathVariable String id,@RequestBody @Valid ReceiveTopicVo receiveTopicVo){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return topicService.updateTopic(loginUser,id,receiveTopicVo);
    }


    @PostMapping("/addTopic")
    @AdminLog
    //@AuthPower
    @ApiOperation("添加话题")
    public Result addTopic(@RequestBody @Valid ReceiveTopicVo receiveTopicVo){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return topicService.addTopic(loginUser,receiveTopicVo);
    }



    @DeleteMapping("/deleteTopic/{id}")
    @AdminLog
    //@AuthPower
    @ApiOperation("删除话题")
    public Result deleteTopic(@PathVariable String id){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return topicService.deleteTopic(loginUser,id);
    }

    @GetMapping("/submitAudit")
    @AdminLog
    //@AuthPower
    @ApiOperation("提交审核")
    public Result submitAudit(String id){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return topicService.submitAudit(loginUser,id);
    }

    @GetMapping("/findAllTopic")
    @AdminLog
  //  @AuthPower
    @ApiOperation("编辑查询所有话题")
    public Result<List<TopicVo>> findAllTopic(String id, Integer topicStatus){
        List<TopicVo> allTopic = topicService.findAllEditTopic(id, topicStatus);
        return ResultFactory.success(allTopic);
    }

    @AdminLog
   // @AuthPower
    @GetMapping("/findEditStatus")
    @ApiOperation("编辑人员查询所有话题状态")
    public Result<List<TopicStatusVo>> findEditStatus(){
        return topicService.findEditStatus();
    }

    @GetMapping("/findTopicById")
    @AdminLog
    //@AuthPower
    @ApiOperation("查看单个话题")
    Result<TopicVo> findTopicById(String id){
        return topicService.findTopicById(id);
    }

    @ApiOperation(value = "编辑人员上传-图片")
    @RequestMapping(value = { "/uploadTopicContentImg" }, method = RequestMethod.POST)
//    @ApiImplicitParam( value = "图片文件", required = true, paramType = "body", dataType = "file")
    public Result<Object> uploadTopicContentImg(@RequestParam("file") MultipartFile file) throws IOException {
        if(file == null){
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        String fileExtensionName = FileUtils.getExtensionName(file.getOriginalFilename());

        long fileSize = file.getSize();

        if ((fileSize / 1024) > 10*1024){
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_FILE_SIZE_MAX_ERROR.getCode());
        }
        return resourcesService.uploadTopicImg(file.getInputStream(),fileExtensionName);
    }
}
