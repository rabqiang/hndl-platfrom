package com.hndl.cn.mghd.admin.business.star.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.business.star.vo.ReceiveStarFansGroupVo;
import com.hndl.cn.mghd.admin.business.star.vo.StarFansGroupVo;
import com.hndl.cn.mghd.admin.business.star.vo.UpdateStarFansGroupVo;
import com.hndl.cn.mghd.admin.common.vo.PageVo;

import javax.validation.constraints.NotNull;

/**
 * @program: hndl-platform
 * @description: 后台管理粉丝会服务层
 * @author: 易成贤
 * @create: 2019-06-19 15:38 @Created by 湖南达联
 */
public interface StarFansGroupService {


  /**
   * 更新粉丝会
   * @param adminUserInfoDo
   * @param updateStarFansGroupVo
   * @return
   */
  Result upsertStarFansGroup(AdminUserInfoDo adminUserInfoDo , UpdateStarFansGroupVo updateStarFansGroupVo);

  /**
   * 插入粉丝会
   * @param adminUserInfoDo
   * @param receiveStarFansGroupVo
   * @return
   */
  Result insertStarFansGroup(AdminUserInfoDo adminUserInfoDo ,ReceiveStarFansGroupVo receiveStarFansGroupVo);

    /**
     * 根据粉丝会id查询粉丝会
     * @param starId
     * @return
     */
    StarFansGroupVo findStarFansGroupByStartId(@NotNull Long starId);

  /**
   *  删除粉丝会
   * @param adminUserInfoDo
   * @param starId
   * @return
   */
    Result deleteStarFansGroup(AdminUserInfoDo adminUserInfoDo ,@NotNull Long starId);

  /**
   * 查询所有粉丝会
   * @param id ObjId
   * @param parameters 关键字
   * @return
   */
   PageVo<StarFansGroupVo> findStarFansGroup(String id,String parameters,Integer isDelete);

  /**
   * 加入推荐
   * @param starId
   * @return
   */
   Result addRecommendation(AdminUserInfoDo adminUserInfoDo ,Long starId);
}
