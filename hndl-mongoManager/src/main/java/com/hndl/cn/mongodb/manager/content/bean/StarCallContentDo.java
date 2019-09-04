package com.hndl.cn.mongodb.manager.content.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description 打call
 * @Date 2019/5/6 13:33
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_star_call_content")
@CompoundIndexes({@CompoundIndex(name="call_index",def = "{userUniId:1,starId:1,createTime:-1}",background = true)})
public class StarCallContentDo implements Serializable {


    @Id
    private String id;

    @Indexed(background = true)
    private Long callId;
    /**
     * 创建时间
     */
    @Indexed(direction = IndexDirection.DESCENDING,background = true)
    private Long createTime;
    /**
     * 创建用户id
     */
    @Indexed(background = true)
    private Long userUniId;
    /**
     * 用户昵称
     */
    private String userNickName;
    /**
     * 用户头像
     */
    private String userImg;

    /**
     * 明星id
     */
    @Indexed(background = true)
    private Long starId;
    /**
     * 内容
     */
    private String content;
    /**
     * 内容图片
     */
    private List<String> contentImgList;

    //点赞数
    private Integer likeCount;

    //评论数
    private Integer commentCount;

    /**
     * 推荐
     */
    @Indexed(background = true)
    private  Long isRecommen;

    /**
     * 是不是明星说
     */
    @Indexed(background = true)
    private Integer isStarSaid;

    /**
     * 是否删除
     */
    private Integer isDelete;
}
