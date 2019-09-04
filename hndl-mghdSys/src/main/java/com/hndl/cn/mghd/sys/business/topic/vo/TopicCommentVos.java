package com.hndl.cn.mghd.sys.business.topic.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 评论vo
 * @author: 易成贤
 * @create: 2019/7/30 19:56
 * @Created by湖南达联
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class TopicCommentVos extends TopicCommentVo {

    //包含两条子评论
    List<TopicCommentVo> topicCommentVo;
}
