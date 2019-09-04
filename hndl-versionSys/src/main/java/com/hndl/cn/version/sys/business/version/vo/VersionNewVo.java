package com.hndl.cn.version.sys.business.version.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
*  @author 尹争鸣
*  @Description  Version 2.0
*  @Date  2019年7月15日11:36:02
*  @Created by 湖南达联
*/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VersionNewVo implements Serializable {

    private VersionVo versionVo;//版本信息

    private Integer  renewalType;//更新 状态  0正常  1更新 2强更

    private String maintainState;//维护状态  1正常   2维护

    private String description;
}
