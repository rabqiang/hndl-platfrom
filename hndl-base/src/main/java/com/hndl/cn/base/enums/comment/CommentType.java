package com.hndl.cn.base.enums.comment;

/**
 * @author 赵俊凯
 * @Description 评论类型枚举
 * @Date 2019/5/6 15:33
 * @Created by 湖南达联
 */
public enum CommentType {

    /**
     * 待确定
     */
   COMMENT_TYPE_TEST(1,"默认值")

    ;

   
    private Integer type;

    private String description;


    public Integer getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    CommentType(Integer type, String description) {

        this.type = type;
        this.description = description;
    }
}
