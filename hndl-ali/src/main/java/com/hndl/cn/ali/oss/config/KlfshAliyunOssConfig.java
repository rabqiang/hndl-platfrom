package com.hndl.cn.ali.oss.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/15 14:36
 * @Created by 湖南达联
 */
@Component
@Getter
@Slf4j
public class KlfshAliyunOssConfig {


    @Resource
    private ApplicationContext applicationContext; //注入applicationContext

    /**
     * 阿里云ACCESS_ID
     */
    private  String klfshAccessId;
    /**
     * 阿里云ACCESS_KEY
     */
    private String klfshAccessKeySecret;

    /**
     * 阿里云OSS_ENDPOINT  Url
     */
    private  String klfshOssEndpoint;

    /**
     * 阿里云BUCKET_NAME  OSS http://mianshibaoimg.oss-cn-hangzhou.aliyuncs.com/pc/2015-01-01/123.jpg
     */
    private  String klfshBucketName;


    private String basePath;//我们阿里云的basePath

    private String tmpDir;//临时文件夹

    private String formalDir;//正式文件夹


    @PostConstruct
    public void run(){
        Environment environment =  applicationContext.getEnvironment();
        klfshAccessId = environment.getProperty("klfsh.access.id");
        klfshAccessKeySecret = environment.getProperty("klfsh.access.key");
        klfshOssEndpoint = environment.getProperty("klfsh.oss.endpoint");
        klfshBucketName = environment.getProperty("klfsh.bucket.name");
        basePath = environment.getProperty("klfsh.base.path");
        tmpDir = environment.getProperty("klfsh.tmp.dir");
        formalDir = environment.getProperty("klfsh.formal.dir");
        log.info("================KlfshAliyunOssConfig 配置成功=============================");
    }

}
