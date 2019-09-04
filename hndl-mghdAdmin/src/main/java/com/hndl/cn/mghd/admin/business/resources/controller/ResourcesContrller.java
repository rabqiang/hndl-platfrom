package com.hndl.cn.mghd.admin.business.resources.controller;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.resources.service.ResourcesService;
import com.hndl.cn.mghd.admin.business.resources.vo.Base64Vo;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.utils.file.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;

/**
 * @author 赵俊凯
 * @Description 资源上传
 * @Date 2019/5/7 14:34
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/resources")
@Api(tags = "资源上传")
public class ResourcesContrller {


    @Resource
    private ResourcesService resourcesService;



    @PostMapping("/uploadBase64Img")
    @ApiOperation(value="base64图片上传", notes="base64图片上传")
    public Result<Object> uploadTemporaryBase64Img(@RequestBody @Valid Base64Vo base64Vo){
        return resourcesService.uploadTemporaryBase64Img(base64Vo.getBaseImg());
    }

    @ApiOperation(value = "上传-图片", notes = "图片上传")
    @RequestMapping(value = { "/uploadImg" }, method = RequestMethod.POST)
    public Result<Object> uploadImg(@RequestParam("file") MultipartFile file) throws IOException {
        if(file == null){
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        String fileExtensionName = FileUtils.getExtensionName(file.getOriginalFilename());

        long fileSize = file.getSize();

        if ((fileSize / 1024) > 10*1024){
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_FILE_SIZE_MAX_ERROR.getCode());
        }
        return resourcesService.uploadTemporaryImg(file.getInputStream(),fileExtensionName);
    }
}
