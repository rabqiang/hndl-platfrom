package com.hndl.cn.dao.weibo;

import com.hndl.cn.dao.weibo.weiboUser.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program:hndl-platform
 * @description: 微博抓取的数据保存的实体类
 * @author: 易成贤
 * @create: 2019-05-24 19:22
 * @Created by湖南达联
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Statuses {
    //微博创建时间
    private String created_at;
    //微博id
   // private Integer id;
    /* mid为该条微博/评论/私信在web系统中的id值。
     例如一条微博的地址为：http://t.sina.com.cn/1649394251/3z4efAo4lk
     则其mid=3z4efAo4lk */
    //private Integer mid;
    //字符串型的微博ID
   private String idstr;
    //微博信息内容
    private String text;
    //微博作者的用户信息字段
    private User user;
    //被转发的原微博信息字段，当该微博为转发微博时返回
    private Retweeted_status retweeted_status;
    //微博配图ID。多图时返回多图ID，用来拼接图片url。用返回字段thumbnail_pic的地址配上该返回字段的图片ID，即可得到多个图片url。

    //多图列表
    private List<String> pic_urls;
}
