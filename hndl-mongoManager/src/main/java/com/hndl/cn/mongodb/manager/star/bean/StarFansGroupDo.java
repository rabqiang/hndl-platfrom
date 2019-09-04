package com.hndl.cn.mongodb.manager.star.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author admin
 * @Classname 赵俊凯
 * @Description 粉丝会信息记录 易成贤
 * @Date 2019/4/17 19:48
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_star_fans_group")
public class StarFansGroupDo implements Serializable {

    @Id
    private String id;
    /**
     * 创建时间
     */
    @Indexed
    private Long createTime;
    /**
     * 最后更新人,对应后台
     */
    private String lastAdminUserId;
    /**
     * 修改时间
     */
    @Indexed
    private Long updateTime;
    /**
     * 对应id
     */
    @Indexed(unique = true)
    private Long starId;
    /**
     * 明星名称
     */
    @Indexed(background = true)
    private String starName;
    /**
     * 明星头像
     */
    private String starImg;
    /**
     * 投票总票数
     */
    @Indexed(direction = IndexDirection.DESCENDING)
    private Long voteCount;
    /**
     * 投票总用户数
     */
    @Indexed
    private Integer voteUserCount;
    /**
     * 明星描述
     */
    private String starDescription;
    /**
     * 明星类型
     */
    private String starType;
    /**
     * 明星 性别
     */
    private Character sex;
    /**
     * 粉丝名称，就是给粉丝取一个统一的名称
     */
    private String fansName;
    /**
     * 映射用户id
     */
    @Indexed
    private Long mappingUserId;
    /**
     * 微博id
     */
    @Indexed
    private String weiboId;
    /**
     * 总守护数
     */
    @Indexed
    private Long guardCount;
    /**
     * 加入粉丝会人数
     */
    @Indexed
    private Integer userCount;
    /**
     * 推荐
     */
    @Indexed
    private Long recommend;
    /**
     * 是否被删除
     */
    private Integer isDelete;







}
