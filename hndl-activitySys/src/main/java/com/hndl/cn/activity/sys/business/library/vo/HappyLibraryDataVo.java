package com.hndl.cn.activity.sys.business.library.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/31 18:12
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HappyLibraryDataVo implements Serializable {

    private HappyLibraryHeadDataVo happyLibraryHeadDataVo;

    private List<HappyLibraryListDataVo>  happyLibraryListDataVoList;

}
