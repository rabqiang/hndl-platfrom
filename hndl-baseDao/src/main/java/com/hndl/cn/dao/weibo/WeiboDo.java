package com.hndl.cn.dao.weibo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program:hndl-platform
 * @description: 微博do
 * @author: 易成贤
 * @create: 2019-05-27 09:59
 * @Created by湖南达联
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeiboDo {
    private List<Statuses> statuses;
}
