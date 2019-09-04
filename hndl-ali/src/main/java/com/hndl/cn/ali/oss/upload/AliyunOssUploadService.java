package com.hndl.cn.ali.oss.upload;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname 赵俊凯
 * @Description 阿里云文件上传
 * @Date 2019/3/15 11:47
 * @Created by 湖南达联
 */
public interface AliyunOssUploadService {


    /**
     *
     * @param objectName 文件的名称 包括全路径
     * @param in 输入流
     * @return
     */
     String putObject(String objectName, InputStream in) throws IOException;

    /**
     * 话题图片
     * @param objecName
     * @param in
     * @return
     * @throws IOException
     */
     String putTopicObject(String objecName,InputStream in) throws IOException;



    /**
     * 复制以前的图片
     * @param sourceUrl
     * @return
     */
    String copyOldImg( Long callId,String sourceUrl) throws IOException;

    /**
     * 复制临时图片到打call图片文件夹下
     * @param callId callId
     * @param callImgUrl 需要复制的图片地址路径
     * @return 返回复制后的图片地址
     */
    String copyCallImgUrl(Long callId,String callImgUrl);

    /**
     * 复制临时图片保存到用户头像文件夹
     * @param userImgUrl
     * @param id
     * @return
     */
    String copyUserImgUrl(String userImgUrl,Long id);

    /**
     * 复制临时图片到明星头像下
     * @param starId
     * @param starImgUrl
     * @return
     */
    String copyStarImgUrl(Long starId, String starImgUrl);

    /**
     * 复制临时地址到用户背景图下
     * @param userBackgroundImg
     * @param uniId
     * @return
     */
    String copyUserBackgroundImg(String userBackgroundImg, Long uniId);

    /**
     * 复制临时地址到反馈意见下
     * @param feedBackImg
     * @param objId
     * @return
     */
    String copyFeedBackImg(String feedBackImg,String objId);

    /**
     * 复制临时图片到打banner图片文件夹下
     * @param bannerImgUrl 需要复制的图片地址路径
     * @return 返回复制后的图片地址
     */
    String copyBannerImgUrl(String bannerImgUrl);

    /**
     * 复制临时地址到福利商场的文件夹下
     * @param helpWelfareImgUrl   需要复制的商品福利地址
     * @return
     */
    String copyHelpWelfareImgUrl(String helpWelfareImgUrl);

    /**
     * 复制临时图片地址到话题文件夹下
     * @param topicImgUrl
     * @return
     */
    String copyTopicImgUrl(String topicImgUrl);

    /**
     * 复制临时图片到话题评论底下
     * @param topicId
     * @param commentImgUrl
     * @return
     */
    String copyTopicCommentImg(String topicId, String commentImgUrl);
}
