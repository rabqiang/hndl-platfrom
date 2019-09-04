package com.hndl.cn.ali.oss.upload.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CopyObjectResult;
import com.hndl.cn.ali.oss.config.KlfshAliyunOssConfig;
import com.hndl.cn.ali.oss.upload.AliyunOssUploadService;
import com.hndl.cn.ali.oss.util.AliyunFileNameUtils;
import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.plugin.snowflakeid.service.impl.SnowflakeIdServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;


/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/15 11:55
 * @Created by 湖南达联
 */
@Service
@Slf4j
public class AliyunOssUploadServiceImpl implements AliyunOssUploadService {



    @Resource
    private KlfshAliyunOssConfig klfshAliyunOssConfig;

    @Override
    public String putObject(String objectName, InputStream in) throws IOException {
        String minName ;
        OSSClient client = new OSSClient(klfshAliyunOssConfig.getKlfshOssEndpoint(),
                klfshAliyunOssConfig.getKlfshAccessId(), klfshAliyunOssConfig.getKlfshAccessKeySecret());
        try {
            objectName = klfshAliyunOssConfig.getTmpDir() + "/max_img/" + objectName;
            client.putObject(klfshAliyunOssConfig.getKlfshBucketName(), objectName, in);
            minName = objectName.replace("max", "min");
            String maxUrl = klfshAliyunOssConfig.getBasePath() + "/" + objectName;
           client.putObject(klfshAliyunOssConfig.getKlfshBucketName(), minName, AliyunFileNameUtils.converter(maxUrl));
        }  finally {
            if (in != null) {
                in.close();
            }
            client.shutdown();
        }
        return klfshAliyunOssConfig.getBasePath() + "/" + minName;
    }

    @Override
    public String putTopicObject(String objecName, InputStream in) throws IOException {
        OSSClient client = new OSSClient(klfshAliyunOssConfig.getKlfshOssEndpoint(), klfshAliyunOssConfig.getKlfshAccessId(), klfshAliyunOssConfig.getKlfshAccessKeySecret());
        objecName = klfshAliyunOssConfig.getFormalDir() + objecName;
        try {
            client.putObject(klfshAliyunOssConfig.getKlfshBucketName(), objecName, in);
        }finally {
            if (in != null) { in.close();};
            client.shutdown();
        }
        return klfshAliyunOssConfig.getBasePath() + "/" + objecName;
    }


    ISnowflakeIdService iSnowflakeIdService = SnowflakeIdServiceImpl.INSTANCE;

    /**
     * 复制以前的图片
     *
     * @param sourceUrl
     * @return
     */
    @Override
    public String copyOldImg(Long callId,String sourceUrl) throws IOException {
        //获取文件路径的后缀 取最后一个点的字符串
        String type = sourceUrl.substring(sourceUrl.lastIndexOf("."));
        if (type == null) {
            log.info("图片路径不正确" + sourceUrl);
            return null;
        }
        OSSClient client = new OSSClient(klfshAliyunOssConfig.getKlfshOssEndpoint(),
                klfshAliyunOssConfig.getKlfshAccessId(), klfshAliyunOssConfig.getKlfshAccessKeySecret());

        //匹配前缀
        Pattern p = compile("^http://mghd.oss-cn-hangzhou.aliyuncs.com/.*");
        Matcher m = p.matcher(sourceUrl);
        long fileId = iSnowflakeIdService.nextFileId();
        String maxfileName = klfshAliyunOssConfig.getFormalDir() + "/call/"+callId+"/max_img/" + LocalDate.now().toString() + "/" + fileId + type;

        String minfileName = klfshAliyunOssConfig.getFormalDir() + "/call/"+callId+"/min_img/" + LocalDate.now().toString() + "/" + fileId + type;

        //如果不匹配
        if (!m.matches()) {
            URL url = new URL(sourceUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(4 * 1000);
            InputStream inStream = con.getInputStream();    //通过输入流获取图片数据

            client.putObject(klfshAliyunOssConfig.getKlfshBucketName() , maxfileName, inStream);
            InputStream inputStream = AliyunFileNameUtils.converter(sourceUrl);
            client.putObject(klfshAliyunOssConfig.getKlfshBucketName() , minfileName, inputStream);
        }else {
            //先去掉前缀
            String replace = sourceUrl.replace(klfshAliyunOssConfig.getBasePath() + "/", "");

            //CopyObjectResult copyObjectResult = null;
           // PutObjectResult putObjectResult = null;
            try {
                client.copyObject(klfshAliyunOssConfig.getKlfshBucketName(), replace, klfshAliyunOssConfig.getKlfshBucketName(), maxfileName);
                client.copyObject(klfshAliyunOssConfig.getKlfshBucketName(), replace, klfshAliyunOssConfig.getKlfshBucketName(), minfileName);
//
   //             InputStream inputStream = AliyunFileNameUtils.converter(klfshAliyunOssConfig.getBasePath() + "/" + maxfileName);
//                client.putObject(klfshAliyunOssConfig.getKlfshBucketName() , minfileName, inputStream);
            } catch (Exception e) {
//                log.error("copy或者put失败 copy 结果集为：" + JSONObject.toJSONString(copyObjectResult) + "\n put结果集为：" + JSONObject.toJSONString(putObjectResult) + "\n 原路径是：" + sourceUrl);
            } finally {
                client.shutdown();
            }
        }


        return klfshAliyunOssConfig.getBasePath() + "/" + minfileName;
    }

    /**
     * 复制临时图片到打call图片文件夹下
     * @param callId callId
     * @param callImgUrl 需要复制的图片地址路径
     * @return 返回复制后的图片地址
     */
    @Override
    public String copyCallImgUrl(Long callId,String callImgUrl) {

        String source ="call/"+callId;
      return copyObject(callImgUrl,source);
    }

    /**
     * 复制临时图片保存到用户头像文件夹
     * @param userImgUrl
     * @param id
     * @return
     */
    @Override
    public String copyUserImgUrl(String userImgUrl,Long id) {
        String replace = userImgUrl.replace(klfshAliyunOssConfig.getBasePath() + "/", "");
        String source = replace.replace(klfshAliyunOssConfig.getTmpDir(), klfshAliyunOssConfig.getFormalDir()+"/user/"+id);

        OSSClient client = new OSSClient(klfshAliyunOssConfig.getKlfshOssEndpoint(),
                klfshAliyunOssConfig.getKlfshAccessId(), klfshAliyunOssConfig.getKlfshAccessKeySecret());
        CopyObjectResult copyObjectResult = null;
        try {
            copyObjectResult = client.copyObject(klfshAliyunOssConfig.getKlfshBucketName(), replace, klfshAliyunOssConfig.getKlfshBucketName(), source);

        } catch (Exception e) {
            log.error("copyObject上传图片失败--sourceUrl:{}---" + JSONObject.toJSONString(copyObjectResult), userImgUrl);
        } finally {
            client.shutdown();
        }

        return klfshAliyunOssConfig.getBasePath() + "/" + source;
    }

    /**
     * 复制临时图片到明星头像下
     *
     * @param starId
     * @param starImgUrl
     * @return
     */
    @Override
    public String copyStarImgUrl(Long starId, String starImgUrl) {
        String source = "star/"+starId;
        return copyObject(starImgUrl,source);
    }

    /**
     * 复制临时地址到用户背景图下
     *
     * @param userBackgroundImg
     * @param uniId
     * @return
     */
    @Override
    public String copyUserBackgroundImg(String userBackgroundImg, Long uniId) {
        String source = "user/"+uniId+"/background";
        return copyObject(userBackgroundImg,source);
    }

    /**
     * 复制临时地址到反馈意见下
     *
     * @param feedBackImg
     * @param objId
     * @return
     */
    @Override
    public String copyFeedBackImg(String feedBackImg, String objId) {
        //建议目录
        String source = "feedBack/suggest";
        if (null != objId) {
            source = "feedBack/"+objId;
        }
        return copyObject(feedBackImg,source);
    }

    /**
   * 复制临时url到正式的地方
   * exp:tmpUrl =http://mghd.oss-cn-hangzhou.aliyuncs.com/temp/min_img/2019-06-02/253396258381824000.png *
   *       dirName = star/1235567345
   * 复制后：http://mghd.oss-cn-hangzhou.aliyuncs.com/fromal/star/1235567345/min_img/2019-06-02/253396258381824000.png
   * @param tmpUrl 临时完整地址
   * @param dirName 目录名<br>
   * @return 复制后的地址
   * @throws Exception
   */
  private String copyObject(String tmpUrl, String dirName) {
        //临时地址替换
        String replace = tmpUrl.replace(klfshAliyunOssConfig.getBasePath() + "/", "");
        String source = replace.replace(klfshAliyunOssConfig.getTmpDir(), klfshAliyunOssConfig.getFormalDir()+"/"+dirName);
        //1，创建OSS对象
        OSSClient client = new OSSClient(klfshAliyunOssConfig.getKlfshOssEndpoint(), klfshAliyunOssConfig.getKlfshAccessId(), klfshAliyunOssConfig.getKlfshAccessKeySecret());
        //2，复制文件
        try{
            client.copyObject(klfshAliyunOssConfig.getKlfshBucketName(), replace, klfshAliyunOssConfig.getKlfshBucketName(), source);
    } finally {
            client.shutdown();
        }

       return klfshAliyunOssConfig.getBasePath() + "/" + source;
    }

    @Override
    public String copyBannerImgUrl(String bannerImgUrl) {
        return copyObject(bannerImgUrl,"banner");
    }

    @Override
    public String copyHelpWelfareImgUrl(String helpWelfareImgUrl) {
      return copyObject(helpWelfareImgUrl,"helpWelfare");
    }

    /**
     * 复制临时图片地址到话题文件夹下
     *
     * @param topicImgUrl
     * @return
     */
    @Override
    public String copyTopicImgUrl(String topicImgUrl) {
        return copyObject(topicImgUrl,"topic");
    }

    /***
     * 复制临时图片到话题评论底下
     * @param topicId
     * @param commentImgUrl
     * @return
     */
    @Override
    public String copyTopicCommentImg(String topicId, String commentImgUrl) {
        return copyObject(commentImgUrl,"topic/"+topicId+"/");
    }
}
