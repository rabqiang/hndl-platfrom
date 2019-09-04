package com.hndl.cn.mghd.sys.business.resources.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.sys.business.resources.service.ResourcesService;
import com.hndl.cn.mghd.sys.business.resources.vo.Base64Vo;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.utils.file.FileUtils;
import com.hndl.cn.utils.string.StringUtils;
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
@RequestMapping("/{source}/resources")
@Api(tags = "资源上传")
public class ResourcesContrller {


    @Resource
    private ResourcesService resourcesService;



    @PostMapping("/uploadBase64Img")
    @CrossOrigin
    @AuthPassport
    @ApiOperation(value="base64图片上传", notes="base64图片上传")
    public Result<Object> uploadTemporaryBase64Img(@PathVariable String source,@RequestBody @Valid Base64Vo base64Vo){


        return resourcesService.uploadTemporaryBase64Img(base64Vo.getBaseImg());
    }

    @ApiOperation(value = "上传-图片", notes = "图片上传")
    @CrossOrigin
    @RequestMapping(value = { "/uploadImg" }, method = RequestMethod.POST)
    @AuthPassport
    public Result<Object> uploadImg(@RequestParam("imgFile") MultipartFile imgFile) throws IOException {
        if(imgFile == null){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        String fileExtensionName = FileUtils.getExtensionName(imgFile.getOriginalFilename());

        // 检查上传参数
        if (StringUtils.isBlank(fileExtensionName)
                || MghdSysConstants.USER_AUTH_UPLOAD_IMG_LIMIT_TYPE.indexOf(fileExtensionName) == -1) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_FILE_NAME_ERROR.getCode());
        }

        long fileSize = imgFile.getSize();

        if ((fileSize / 1024) > MghdSysConstants.USER_AUTH_UPLOAD_IMG_LIMIT_SIZE){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_FILE_SIZE_MAX_ERROR.getCode());
        }
        return resourcesService.uploadTemporaryImg(imgFile.getInputStream(),fileExtensionName);
    }
}
