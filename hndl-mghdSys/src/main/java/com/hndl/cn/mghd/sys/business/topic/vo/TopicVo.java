package com.hndl.cn.mghd.sys.business.topic.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:hndl-platform
 * @description:TODO 话题vo
 * @author: 易成贤
 * @create: 2019/7/29 15:53
 * @Created by湖南达联
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicVo {
    /**
     * id
     */
    private String id;

    /**
     *创建时间
     */
    private Long createTime;

    /**
     * 创建者
     */
    private String createAdminId;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 最后更新者
     */
    private String updateAdminId;

    /**
     *标题
     */
    private String title;

    /**
     *内容
     */
    private String content;


    /**
     *话题标题图
     */
    private String titleImgUrl;

    /**
     * 评论数
     */
    private Integer commentCount;

    /**
     * 点赞数
     */
    private Integer likeCount;

}
