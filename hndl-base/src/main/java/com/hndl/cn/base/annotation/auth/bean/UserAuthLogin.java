package com.hndl.cn.base.annotation.auth.bean;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description  jwt json对象
 * @Date 2019/3/14 14:18
 * @Created by 湖南达联
 */
@Data
@Getter
@Setter
public class UserAuthLogin implements Serializable {


    private Long loginUserId;//用户id

    private Long timeOut;//过期时间

}
