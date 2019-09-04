package com.hndl.cn.mghd.admin.business.resources.service;

import com.hndl.cn.base.result.Result;

import java.io.InputStream;

/**
 * @author 赵俊凯
 * @Description 资源上传
 * @Date 2019/5/7 14:14
 * @Created by 湖南达联
 */
public interface ResourcesService {


    /**
     * 上传临时资源
     * @param base64
     * @return
     */
    Result<Object> uploadTemporaryBase64Img(String base64);


    /**
     * 文件上传
     * @param io
     * @param fileExtensionName
     * @return
     */
    Result<Object> uploadTemporaryImg(InputStream io, String fileExtensionName);

    /**
     * 注册打call图片
     * @param callId callId 主要用于区分文件夹
     * @param callImgUrl 需要注册图片的url
     * @return 返回注册成功后的图片
     */
    String registerCallImg(Long callId, String callImgUrl);

    /**
     * 注解明星头像
     * @param starId 明星id
     * @param starImgUrl 明星url
     * @return 注册后的地址值
     */
    String registerStarImg(Long starId, String starImgUrl);

    /**
     * 注册用户头像图片
     * @param userImgUrl  图片url
     * @param id
     * @return 返回注册成功的图片
     */
    String registerUserImgUrl(String userImgUrl, Long id);

    /**
     * 注册用户背景图
     * @param userBackgroundImg 背景图临时地址
     * @param uniId 用户id
     * @return
     */
    String registerUserBackgroundImg(String userBackgroundImg, Long uniId);

    /**
     *注册举报反馈图片
     * @param feedBackImg
     * @return
     */
    String registerFeedBackImg(String feedBackImg, String Obj);

    /**
     * 注册banner图片
     * @param bannerImgUrl
     * @return
     */
    String registerBannerImg(String bannerImgUrl);

    /**
     * 注册话题图片
     * @param topicImgUrl
     * @return
     */
    String registerTopicImg(String topicImgUrl);

    /**
     * 注册福利商场商品的图片
     * @param helpWelfareImgUrl
     * @return
     */
    String registerHelpWelfareImg(String helpWelfareImgUrl);

    /**
     * 上传话题编辑图
     * @param inputStream
     * @param fileExtensionName
     * @return
     */
    Result<Object> uploadTopicImg(InputStream inputStream, String fileExtensionName);
}
