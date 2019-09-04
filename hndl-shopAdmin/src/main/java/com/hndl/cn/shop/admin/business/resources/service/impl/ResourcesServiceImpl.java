package com.hndl.cn.shop.admin.business.resources.service.impl;

import com.hndl.cn.ali.oss.config.KlfshAliyunOssConfig;
import com.hndl.cn.ali.oss.upload.AliyunOssUploadService;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.plugin.snowflakeid.service.impl.SnowflakeIdServiceImpl;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.shop.admin.business.resources.service.ResourcesService;
import com.hndl.cn.shop.admin.exception.ShopAdminException;
import com.hndl.cn.shop.admin.exception.ShopAdminExceptionEnums;
import com.hndl.cn.utils.file.CheckFileTypeUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * @author 赵俊凯
 * @Description
 * @Date 2019/5/7 14:17
 * @Created by 湖南达联
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {

    /**
     * 统一校验的图片格式以免上传不符合要求的图片
     */
    private final static Pattern uploadFilePattern =  Pattern.compile(".*(jpg|png|gif|jpeg).*");

    @Resource
    private AliyunOssUploadService aliyunOssUploadService;

    @Resource
    private KlfshAliyunOssConfig klfshAliyunOssConfig;


    private ISnowflakeIdService snowflakeIdService = SnowflakeIdServiceImpl.INSTANCE;


    @Override
    public Result<Object> uploadTemporaryBase64Img(String base64) {
        try{

            String[] d =base64.split("base64,");
            String imgData;

            if (d != null && d.length == 2) {
                imgData = d[1];
            } else {
                throw new ShopAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
            }

            String suffix = "";
            byte[] bs = Base64.decodeBase64(imgData);
            for (int i = 2; i < 5; i++) {
                byte[] b = new byte[i];
                suffix = CheckFileTypeUtil.getFileType(new ByteArrayInputStream(bs), b);
                if (null != suffix) {
                    break;
                }
            }
            if (null == suffix) {
                throw new ShopAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
            }
            String fileName =LocalDate.now().toString()+"/" +  snowflakeIdService.nextFileId()  + "." + suffix;
            ByteArrayInputStream in = new ByteArrayInputStream(bs);

            return ResultFactory.success(aliyunOssUploadService.putObject(fileName, in));
        }catch (Exception e){
            //防止图片上传异常(比如传文件不被压缩支持,比如文件后缀为jpg，但实际文件头为riff)
            throw new ShopAdminException(ShopAdminExceptionEnums.MGHD_SYS_PIC_UPLOAD_FAIL_EXCEPTION.getCode());
        }
    }

    @Override
    public Result<Object> uploadTemporaryImg(InputStream io, String fileExtensionName) {
        try{

            String fileName =LocalDate.now().toString()+"/" +  snowflakeIdService.nextFileId()  + "." + fileExtensionName;

            return ResultFactory.success(aliyunOssUploadService.putObject(fileName,io));
        }catch (Exception e){
            throw new ShopAdminException(ShopAdminExceptionEnums.MGHD_SYS_PIC_UPLOAD_FAIL_EXCEPTION.getCode());
        }

    }



    /**
     * 注册打call图片
     * @param callId callId 主要用于区分文件夹
     * @param callImgUrl 需要注册图片的url
     * @return 返回注册成功后的图片
     */
    @Override
    public String registerCallImg(Long callId,String callImgUrl) {
        //校验图片前缀
        String path = klfshAliyunOssConfig.getBasePath() + "/" + klfshAliyunOssConfig.getTmpDir();
        if(!callImgUrl.contains(path)){
            throw new ShopAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        return aliyunOssUploadService.copyCallImgUrl(callId,callImgUrl);
    }

    /**
     * 注册明星头像
     *
     * @param starId     明星id
     * @param starImgUrl 明星url
     * @return 注册后的地址值
     */
    @Override
    public String registerStarImg(Long starId, String starImgUrl) {
        //校验图片前缀
        String path = klfshAliyunOssConfig.getBasePath() + "/" + klfshAliyunOssConfig.getTmpDir();
        if(!starImgUrl.contains(path)){
            throw new ShopAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        //
        aliyunOssUploadService.copyStarImgUrl(starId, starImgUrl);
        return aliyunOssUploadService.copyStarImgUrl(starId, starImgUrl);
    }

    /**
     * 注册用户头像图片
     * @param userImgUrl  图片url
     * @param id
     * @return 返回注册成功的图片
     */
    @Override
    public String registerUserImgUrl(String userImgUrl,Long id) {
        String path = klfshAliyunOssConfig.getBasePath() + "/" + klfshAliyunOssConfig.getTmpDir();
        if(!userImgUrl.contains(path)){
            throw new ShopAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        return aliyunOssUploadService.copyUserImgUrl(userImgUrl,id);
    }

    /**
     * 注册用户背景图
     *
     * @param userBackgroundImg 背景图临时地址
     * @param uniId             用户id
     * @return
     */
    @Override
    public String registerUserBackgroundImg(String userBackgroundImg, Long uniId) {

        String path = klfshAliyunOssConfig.getBasePath() + "/" + klfshAliyunOssConfig.getTmpDir();
        if(!userBackgroundImg.contains(path)){
            throw new ShopAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        return aliyunOssUploadService.copyUserBackgroundImg(userBackgroundImg,uniId);
    }

    /**
     * @param feedBackImg
     * @param ObjId
     * @return
     */
    @Override
    public String registerFeedBackImg(String feedBackImg, String ObjId) {
        String path = klfshAliyunOssConfig.getBasePath() + "/" + klfshAliyunOssConfig.getTmpDir();
        if(!feedBackImg.contains(path)){
            throw new ShopAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        return aliyunOssUploadService.copyFeedBackImg(feedBackImg,ObjId);
    }

    /**
     * 注册打banner图片
     * @param bannerImgUrl 需要注册图片的url
     * @return 返回注册成功后的图片
     */
    @Override
    public String registerBannerImg(String bannerImgUrl) {
        //校验图片前缀
        String path = klfshAliyunOssConfig.getBasePath() + "/" + klfshAliyunOssConfig.getTmpDir();
        if(!bannerImgUrl.contains(path)){
            throw new ShopAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        return aliyunOssUploadService.copyBannerImgUrl(bannerImgUrl);
    }

    @Override
    public String registerHelpWelfareImg(String helpWelfareImgUrl) {
        String path=klfshAliyunOssConfig.getBasePath()+"/"+klfshAliyunOssConfig.getTmpDir();
        if (!helpWelfareImgUrl.contains(path)){
            throw  new ShopAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        return aliyunOssUploadService.copyHelpWelfareImgUrl(helpWelfareImgUrl);
    }

}
