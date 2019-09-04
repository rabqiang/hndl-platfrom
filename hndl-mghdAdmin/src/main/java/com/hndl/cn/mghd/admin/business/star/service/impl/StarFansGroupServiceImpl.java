package com.hndl.cn.mghd.admin.business.star.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.plugin.snowflakeid.service.impl.SnowflakeIdServiceImpl;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.admin.business.rank.service.StarRankService;
import com.hndl.cn.mghd.admin.business.rank.vo.StarRankVo;
import com.hndl.cn.mghd.admin.business.resources.service.ResourcesService;
import com.hndl.cn.mghd.admin.business.star.service.StarFansGroupService;
import com.hndl.cn.mghd.admin.business.star.vo.ReceiveStarFansGroupVo;
import com.hndl.cn.mghd.admin.business.star.vo.StarFansGroupVo;
import com.hndl.cn.mghd.admin.business.star.vo.UpdateStarFansGroupVo;
import com.hndl.cn.mghd.admin.common.vo.PageVo;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mghd.admin.exception.MghdAdminExceptionEnums;
import com.hndl.cn.mongodb.manager.content.manager.StarCallContentManger;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.manager.*;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.mysql.manager.star.manager.GameStarVoteManager;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program:hndl-platform
 * @description: 粉丝会管理
 * @author: 易成贤
 * @create: 2019-06-19 15:39 @Created by湖南达联
 */
@Service
@Slf4j
public class StarFansGroupServiceImpl implements StarFansGroupService {
  /** 数字常量 */
  private final String NUMBER_REGEX = "[0-9]+";

  private ISnowflakeIdService iSnowflakeIdService = SnowflakeIdServiceImpl.INSTANCE;

  @Resource
  StarFansGroupManager starFansGroupManager;
  @Resource
  StarRankService starRankService;
  @Resource
  CommonUserInfoManager commonUserInfoManager;

  @Resource
  StarCallContentManger starCallContentManger;

  @Resource
  ResourcesService resourcesService;

  @Resource
  GameStarVoteManager gameStarVoteManager;


  @Resource
  StarDayRankManager starDayRankManager;
  @Resource
  StarFansDayStatisticsManager starFansDayStatisticsManager;
  @Resource
  StarFansMonthStatisticsManager starFansMonthStatisticsManager;
  @Resource
  StarFansWeekStatisticsManager starFansWeekStatisticsManager;
  @Resource
  StarMonthRankManager starMonthRankManager;
  @Resource
  StarWeekRankManager starWeekRankManager;

  @Resource
  StarFansGroupRelationManager starFansGroupRelationManager;



  /**
   * 更新粉丝会
   *
   * @param adminUserInfoDo
   * @param updateStarFansGroupVo
   * @return
   */
  @Override
  public Result upsertStarFansGroup(
          AdminUserInfoDo adminUserInfoDo, UpdateStarFansGroupVo updateStarFansGroupVo) {
    StarFansGroupDo starFansGroupDo =
        SpringCglibBeanUtils.convert(updateStarFansGroupVo, StarFansGroupDo.class);

    Long starId = starFansGroupDo.getStarId();
    StarFansGroupDo starFansGroup = starFansGroupManager.findOneStarFansGroup(starId);
    if (null == starFansGroup) {
      throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_STAR_FANS_GROUP_IS_NULL_EXCEPTION.getCode());
    }
    // 设置未删除
    starFansGroupDo.setIsDelete(IsValidEnums.NO.getValue());
    // 设置最后更新人的id
    starFansGroupDo.setLastAdminUserId(String.valueOf(adminUserInfoDo.getId()));
    // 设置修改时间
    starFansGroupDo.setUpdateTime(System.currentTimeMillis());

   String voSex = updateStarFansGroupVo.getSex();
    if (StringUtils.isNotBlank(voSex) &&  !starFansGroup.getSex().equals(voSex)) {

      if (!voSex.matches("F") && !voSex.matches("M")){
        //参数错误
        throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
      }
      starFansGroupDo.setSex(voSex.toCharArray()[0]);
    }
  //更新图片
   String starImg = updateStarFansGroupVo.getStarImg();
    //判断是不是原图
    if (null != starImg && !starImg.equals(starFansGroup.getStarImg())) {
      String img = resourcesService.registerStarImg(starId, starImg.replace("min", "max"));
      starCallContentManger.updateUserImgByUniId(starFansGroup.getMappingUserId(),img);
       updateStarImg(img,starId);
      starFansGroupDo.setStarImg(img);
    }
    //更新粉丝会名字
    if (null != starFansGroupDo.getStarName() && !starFansGroup.getStarName().equals(starFansGroupDo.getStarName()) ) {
      starCallContentManger.updateUserNickNameByUniId(starFansGroup.getMappingUserId(),starFansGroupDo.getStarName());
      updateStarName(starFansGroupDo.getStarName(),starId);
    }

    // 更新粉丝会
    starFansGroupManager.upsert(starFansGroupDo);

    //恢复对应的用户关系表
  //  starFansGroupRelationManager.updateIsDeleteBystarId(starId,IsValidEnums.NO);
   /* //恢复call
    starCallContentManger.updateIsDeleteByStarId(starId,IsValidEnums.NO);
*/
    log.info(adminUserInfoDo.getLoginName()+"正在更新粉丝会:\n"+starFansGroup.toString()+"\n===>"+starFansGroupDo.toString()+"\n");

    return ResultFactory.success();
  }

  /**
   * 插入粉丝会
   *
   * @param adminUserInfoDo
   * @param receiveStarFansGroupVo
   * @return
   */
  @Override
  public Result insertStarFansGroup(AdminUserInfoDo adminUserInfoDo, ReceiveStarFansGroupVo receiveStarFansGroupVo) {
    StarFansGroupDo starFansGroupDo =
        SpringCglibBeanUtils.convert(receiveStarFansGroupVo, StarFansGroupDo.class);
    // 创建时间
    long createTime = System.currentTimeMillis();
    starFansGroupDo.setCreateTime(createTime);
    // 最后更新人id
    starFansGroupDo.setLastAdminUserId(String.valueOf(adminUserInfoDo.getId()));
    // 未删除
    starFansGroupDo.setIsDelete(IsValidEnums.NO.getValue());
    // 修改时间
    starFansGroupDo.setUpdateTime(createTime);
    // 粉丝会id
    Long maxStarId = gameStarVoteManager.getNewStarId();
    starFansGroupDo.setStarId(maxStarId);

    char sex = receiveStarFansGroupVo.getSex().toCharArray()[0];
    starFansGroupDo.setSex(sex);
    //返回注册小图片地址
    String minStarImg = resourcesService.registerStarImg(maxStarId, receiveStarFansGroupVo.getStarImg());
    //返回注册大图片地址
    String maxStarImg = resourcesService.registerStarImg(maxStarId, receiveStarFansGroupVo.getStarImg().replace("min", "max"));
    starFansGroupDo.setStarImg(maxStarImg);

    // 创建粉丝会对应的用户(不知道啥作用)
    Long userUinId = iSnowflakeIdService.nextUserId();
    CommonUserInfoDo commonUserInfoDo = new CommonUserInfoDo();
    commonUserInfoDo.setIsDeleted(IsValidEnums.NO.getOldValue());
    commonUserInfoDo.setCreateTime(new Date(createTime));
    commonUserInfoDo.setPersonImgUrlMin(minStarImg);
    commonUserInfoDo.setPersonImgUrlMax(maxStarImg);
    commonUserInfoDo.setDoudouCount(0);
    commonUserInfoDo.setConiCount(0D);
    String starName = receiveStarFansGroupVo.getStarName();
    commonUserInfoDo.setNickName(starName);
    commonUserInfoDo.setLastModifyTime(new Date(createTime));
    commonUserInfoDo.setSysUniId(userUinId);
    commonUserInfoDo.setLastOperator(adminUserInfoDo.getNickName());
    commonUserInfoDo.setCreateOperator(adminUserInfoDo.getLoginName());

    commonUserInfoManager.addUserInfo(commonUserInfoDo);
    // 加入粉丝会人数
    starFansGroupDo.setUserCount(0);
    //推荐值
    starFansGroupDo.setRecommend(0L);
    //插入对应人
    starFansGroupDo.setMappingUserId(userUinId);
    //守护数
    starFansGroupDo.setGuardCount(0L);
    //
    starFansGroupManager.upsert(starFansGroupDo);
    //建立榜单数据
    StarRankVo starRankVo = StarRankVo.builder()
            .createTime(createTime)
            .starId(maxStarId)
            .starName(starName)
            .starImg(maxStarImg)
            .voteCount(receiveStarFansGroupVo.getVoteCount())
            .coinCount(0)
            .integralCount(0)
            .gettingLoveCount(0)
            .currentRank(0)
            .build();
    starRankService.initStarRank(starRankVo);

    return ResultFactory.success();
  }

  /**
   * 根据粉丝会id查询粉丝会
   *
   * @param starId
   * @return
   */
  @Override
  public StarFansGroupVo findStarFansGroupByStartId(Long starId) {
    // 1,查询关键字对应的粉丝会
    StarFansGroupDo starFansGroup = starFansGroupManager.findStarFansGroup(starId);
    // 2，转换为vo
    StarFansGroupVo starFansGroupVo = SpringCglibBeanUtils.convert(starFansGroup, StarFansGroupVo.class);
    // 3，查询守护大使数据??
    /*starFansGroupVo.set*/
    // 4，返回数据

    return starFansGroupVo;
  }

  /**
   * 删除粉丝会
   *
   * @param starId 粉丝会id
   * @return 成功
   */
  @Override
  public Result deleteStarFansGroup(AdminUserInfoDo adminUserInfoDo,Long starId) {

    StarFansGroupDo starFansGroupDo = starFansGroupManager.findOneStarFansGroup(starId);

    if (null ==  starFansGroupDo) {
      throw  new MghdAdminException(MghdAdminExceptionEnums.MGHD_STAR_FANS_GROUP_IS_NULL_EXCEPTION.getCode());
    }
    if (IsValidEnums.YES.getValue().equals(starFansGroupDo.getIsDelete())){
      throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_STAR_FANS_GROUP_IS_DELETE_EXCEPTION.getCode());
    }
    //更新最后修改人
    starFansGroupManager.updatelastAdminUserId(starId,adminUserInfoDo.getLoginName());
    //跟新删除字段
    starFansGroupManager.updateIsDelete(starId, IsValidEnums.YES);
    //删除对应的用户关系表
    starFansGroupRelationManager.updateIsDeleteBystarId(starId,IsValidEnums.YES);
/*    //删除粉丝会的call
    starCallContentManger.updateIsDeleteByStarId(starId,IsValidEnums.YES);*/

    return ResultFactory.success();
  }

  /**
   * 查询所有粉丝会
   *
   * @param
   * @return
   */
  @Override
  public PageVo<StarFansGroupVo> findStarFansGroup(String id,String parameters,Integer isDelete) {
    Long count =0L ;
    List<StarFansGroupDo> starFansGroupDos = new ArrayList<>(1);
      if ( StringUtils.isNotBlank(parameters) && parameters.matches(NUMBER_REGEX)  ) {
          StarFansGroupDo starFansGroup = starFansGroupManager.findStarFansGroup(NumberUtils.toLong(parameters));
          starFansGroupDos.add(starFansGroup);
          count = Long.valueOf(starFansGroupDos.size());

      } else {
        starFansGroupDos =
            starFansGroupManager.findAllStarFansGroup(
              parameters,
                   id,
                IsValidEnums.evalVal(isDelete),
                BaseConstants.DEFAULT_LIMIT);
        count = starFansGroupManager.countByKeyWords(parameters);
     }
    List<StarFansGroupVo> starFansGroupVos =
        SpringCglibBeanUtils.convertByList(starFansGroupDos, StarFansGroupVo.class);
  /*  // // 计算总页数 formula:(总数+每页记录数-1)/每页显示数
    Long totalPage = (count + BaseConstants.DEFAULT_LIMIT - 1) / BaseConstants.DEFAULT_LIMIT;*/

    return PageVo.<StarFansGroupVo>builder().dataList(starFansGroupVos).total(count).build();
  }

  /**
   * 加入推荐
   *
   * @param starId
   * @return
   */
  @Override
  public Result addRecommendation(AdminUserInfoDo adminUserInfoDo ,Long starId) {
    //更新最后修改人
    starFansGroupManager.updatelastAdminUserId(starId,adminUserInfoDo.getLoginName());

    starFansGroupManager.updateRecommend(starId, System.currentTimeMillis());
    return ResultFactory.success();
  }

  /**
   * 更新粉丝会头像接口
   * @param img
   * @param starId
   */
  private void updateStarImg(String img,Long starId){

    starDayRankManager.updateImgByStarId(img,starId);
    starFansDayStatisticsManager.updateImgByStarId(img,starId);
    starFansMonthStatisticsManager.updateImgByStarId(img,starId);
    starFansWeekStatisticsManager.updateImgByStarId(img,starId);
    starMonthRankManager.updateImgByStarId(img,starId) ;
    starWeekRankManager.updateImgByStarId(img,starId);
  }

  /**
   * 更新粉丝会名称
   * @param starName
   * @param starId
   */
  private void  updateStarName(String starName,Long starId){

    starDayRankManager.updateStarNameByStarId(starName,starId);
    starFansDayStatisticsManager.updateStarNameByStarId(starName,starId);
    starFansMonthStatisticsManager.updateStarNameByStarId(starName,starId);
    starFansWeekStatisticsManager.updateStarNameByStarId(starName,starId);
    starMonthRankManager.updateStarNameByStarId(starName,starId);
    starWeekRankManager.updateStarNameByStarId(starName,starId);
  }

  public static void main(String[] args) {
    //
    boolean matches = "13235".matches(null);
    System.out.println(matches);
  }


}
