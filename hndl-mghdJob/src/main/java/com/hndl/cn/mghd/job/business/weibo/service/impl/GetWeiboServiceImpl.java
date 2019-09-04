package com.hndl.cn.mghd.job.business.weibo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.weibo.Statuses;
import com.hndl.cn.dao.weibo.WeiboDo;
import com.hndl.cn.dao.weibo.weiboUser.User;
import com.hndl.cn.mghd.job.business.weibo.service.GetWeiboService;
import com.hndl.cn.mongodb.manager.content.bean.StarCallContentDo;
import com.hndl.cn.mongodb.manager.content.manager.StarCallContentManger;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.http.HttpClientUtil;
import com.hndl.cn.utils.string.StringUtils;
import com.hndl.cn.utils.weibo.WeiboLoginer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * @program:hndl-platform
 * @description: 获取微博数据,&nusp;只可以获取关注了的用户的获取，至多也就是100条
 * @author: 易成贤
 * @create: 2019-05-25 13:32
 * @Created by湖南达联
 **/
@Service
@Slf4j
public class GetWeiboServiceImpl implements GetWeiboService {


    @Resource
    StarFansGroupManager starFansGroupManager;
    @Resource
    StarCallContentManger starCallContentManger;

    /**
     * 获取微博数据
     *
     * @param token token
     * @param page  当前页
     * @param count 总记录数
     * @return
     */
    @Override
    public WeiboDo getWeibo(String token, String page, String count) {
        //获取关注用户发表的微博
        String url = String.format(BaseConstants.HOME_TIMELINE, token, page, count);
        // log.info("测试url："+url);
        //获取数据，该数据为字符串型json数据
        String data = HttpClientUtil.doGet(url);
        //  log.info("测试请求获取的数据："+data);
        return JSONObject.parseObject(data, WeiboDo.class);
    }

    /**
     * 获取token
     *
     * @return
     */
    @Override
    public String getToken(String userName, String password) {
       String code = WeiboLoginer.getWeiboCode(userName, password);
        //https://api.weibo.com/oauth2/access_token?client_id=644266243&client_secret=f916ea640fa8dc55f97f85651109e6ed&grant_type=authorization_code&redirect_uri=https://api.weibo.com/oauth2/default.html&code=ec8052c0e1c794559a273a2745de66cd
        String tokenUrl = String.format(BaseConstants.OAUTH2,BaseConstants.CLIENT_ID,BaseConstants.CLIENT_SECRET, code);
        Map<String, String> map = JSON.parseObject(HttpClientUtil.doPost(tokenUrl), Map.class);
        return map.get("access_token");
    }
    /**
     * 获取粉丝会微博数据
     *
     * @param statuses
     */
    @Override
    public List<StarCallContentDo> analysisWeiboJson(List<Statuses> statuses) {
        //判断数据数据是否为空
        if (CollectionUtils.isEmpty(statuses)){
            return null;
        }

        //用于存储
        List<StarCallContentDo> starCallContentDos = new ArrayList<>();
        for (Statuses status : statuses) {
            User user = status.getUser();
            if (null == user) {
                //log.info("获取微博数据未包含微博id，将不加入");
                continue;
            }
            //通过微博id获取粉丝会
            String weiboId = user.getIdstr();
            StarFansGroupDo fansGroup = starFansGroupManager.findFansGroupByWeiboId(weiboId);
            //没有粉丝会跳过
            if (null == fansGroup) {
                continue;
            }
            StarCallContentDo starCallContentDo = new StarCallContentDo();
            //callId 直接取微博的id
            long callId = Long.valueOf(status.getIdstr());
            StarCallContentDo callContent = starCallContentManger.findCallContent(callId);
            //数据库存在这个打call了跳过
            if (null != callContent){
                continue;
            }
            starCallContentDo.setCallId(callId);
            //是转发的微博数据跳过
            if (null != status.getRetweeted_status()) {
                continue;
            }
            //解析时间
  /*          String patternDate = "EEE MMM dd HH:mm:ss Z yyyy";
            long milli = LocalDateTime.parse(status.getCreated_at(), DateTimeFormatter.ofPattern(patternDate)).toInstant(ZoneOffset.of("+8")).toEpochMilli();
            starCallContentDo.setCreateTime(milli);*/
            //SimpleDateFormat线程不安全
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
            try {
                Date parse = simpleDateFormat.parse(status.getCreated_at());
                starCallContentDo.setCreateTime(parse.getTime());
            } catch (ParseException e) {
                log.info("指定微博%s采取时候解析时间异常"+callId);
                starCallContentDo.setCreateTime(System.currentTimeMillis());
                e.printStackTrace();
            }
            //创建用户id
            starCallContentDo.setUserUniId(fansGroup.getMappingUserId().longValue());  //当粉丝会MappingUserId全不为空时候放开
            //昵称
            starCallContentDo.setUserNickName(fansGroup.getStarName());
            //明星头像
            starCallContentDo.setUserImg(fansGroup.getStarImg());
            //明星id
            starCallContentDo.setStarId(fansGroup.getStarId());
            //内容 过滤掉网址连接
            Pattern pattern = compile("[http]{4}\\:\\/\\/[a-z]*(\\.[a-zA-Z]*)*(\\/([a-zA-Z]|[0-9])*)*\\s?");
            String text = status.getText();
            Matcher matcher = pattern.matcher(text);
            text = matcher.replaceAll("");
            //空数据跳过
            if (StringUtils.isBlank(text)){
                continue;
            }
            starCallContentDo.setContent(text);
            //内容图片
            List<String> pic_urls = status.getPic_urls();
            if (CollectionUtils.isNotEmpty(pic_urls)){
                //过滤掉网址前缀字符和反斜杠
                List<String> urlList = new ArrayList<>();
                for (String pic_url : pic_urls) {
                    //只保留：之后的数据
                    //  {"thumbnail_pic":"http://wx1.sinaimg.cn/thumbnail/69e273f8ly1g3kmn2ht5ej2214340ww8.jpg"}
                    String picUrl = pic_url.substring(pic_url.lastIndexOf("http"));
                    //有些图片存在转义符和一些特殊符号 {\"thumbnail_pic\":\"http://wx2.sinaimg.cn/thumbnail/77d52051gy1g3kgiyzoikj21qx26nkjo.jpg\"}
                    String imgUrl;
                    imgUrl = picUrl.replaceAll("[(\\\")|(\\\\)|(})]", "");
                    //替换图片为微博690图片地址
                    //首先替换成为https
                    imgUrl = imgUrl.replaceAll("http://", "https://");
                    //替换文件夹
                    imgUrl = imgUrl.replaceAll(imgUrl.substring(imgUrl.indexOf("/", 8), imgUrl.lastIndexOf("/")), "/orj360");
                    urlList.add(imgUrl);
                }
            starCallContentDo.setContentImgList(urlList);
            }
            //点赞数
            starCallContentDo.setLikeCount(Integer.valueOf(0));
            //评论数
            starCallContentDo.setCommentCount(Integer.valueOf(0));
            //是否推荐
            starCallContentDo.setIsRecommen(0L);
            //是不是爱豆说
            starCallContentDo.setIsStarSaid(IsValidEnums.YES.getValue());
            //是否删除
            starCallContentDo.setIsDelete(IsValidEnums.NO.getValue());
            starCallContentDos.add(starCallContentDo);
        }
        return starCallContentDos;
    }

    /**
     * 插入微博打call数据
     *
     * @param starCallContentDos
     */
    @Override
    public void insertWeiboCall(List<StarCallContentDo> starCallContentDos) {
        if (CollectionUtils.isEmpty(starCallContentDos)){
            log.info("插入的微博数据为空==》分析完微博数据得到数据是空的");
            return;
        }
        starCallContentDos.stream().forEach(val -> starCallContentManger.inserOne(val));

    }
/*
    public static void main(String[] args) {
*//*        String url ="{\\\"thumbnail_pic\\\":\\\"http://wx2.sinaimg.cn/thumbnail/77d52051gy1g3kgiyzoikj21qx26nkjo.jpg\\\"}";
        String picUrl = url.substring(url.lastIndexOf("http"));
        //://wx2.sinaimg.cn/thumbnail/77d52051gy1g3kgiyzoikj21qx26nkjo.jpg\
        String s = picUrl.replaceAll("[(\\\")|(\\\\)|(})]", "");
        System.out.println(s);*//*

        String imgUrl = "http://wx2.sinaimg.cn/thumbnail/77d52051gy1g3kgis4zykj20xc15oam2.jpg";

        imgUrl = imgUrl.replaceAll("http", "https");
        //替换文件夹
        imgUrl = imgUrl.replaceAll(imgUrl.substring(imgUrl.indexOf("/", 8), imgUrl.lastIndexOf("/")), "/mw690");
        System.out.println(imgUrl);

    }*/

}
