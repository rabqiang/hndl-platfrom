package com.hndl.cn.dao.weibo.weiboUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:hndl-platform
 * @description: 微博作者的用户信息  //暂定
 * @author: 易成贤
 * @create: 2019-05-24 19:31
 * @Created by湖南达联
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //用户UID
  //  private Integer id;
    //字符串型的用户UID
    private String idstr;
}
