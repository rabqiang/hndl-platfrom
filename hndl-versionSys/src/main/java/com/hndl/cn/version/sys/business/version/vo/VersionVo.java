package com.hndl.cn.version.sys.business.version.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 尹争鸣
 * @Description 版本号VO
 * @Date 2019年6月1日18:33:25
 * @Created by 湖南达联
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VersionVo implements Serializable {

    private String versionMilestone;

    private String versionId;

    private String url;

    private Integer serialNumber;

    private String remark;

    private String appName;

    private String isForce;

    private String appType;



}
