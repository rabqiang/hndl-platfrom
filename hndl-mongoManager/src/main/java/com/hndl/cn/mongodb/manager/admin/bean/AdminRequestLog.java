package com.hndl.cn.mongodb.manager.admin.bean;

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
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/24 20:44
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "admin_request_log")
public class AdminRequestLog implements Serializable {

    @Id
    private String id;

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long createTime;//创建时间

    @Indexed
    private Long adminUserId;//后台用户id

    @Indexed
    private String ip;

    @Indexed
    private String requestUrl;

    private String args;
}
