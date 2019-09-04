package com.hndl.cn.activity.sys.business.library.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/31 18:03
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HappyLibraryListDataVo implements Serializable {

    private Long groupId;//战队id对应用户id

    private String starName;//明星name

    private String faceImg;//头像

    private String groupName;//战队name

    private Long voteCount;//票数
}
