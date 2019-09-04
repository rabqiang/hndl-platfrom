package com.hndl.cn.mongodb.manager.star.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

/** @author 易成贤 @Description 粉丝会信息记录操作 @Date 2019/4/18 10:54 @Created by 湖南达联 */
public interface StarFansGroupManager {

  /**
   * 根据明星()查询粉丝会基础信息，<br>
   * 一个明星()只有一个粉丝会
   *
   * @param starId
   * @return
   */
  StarFansGroupDo findStarFansGroup(@NotNull Long starId);

  /**
   * 插入粉丝会
   * @param starFansGroupDo 粉丝会do
   */
  void upsert(@NotNull StarFansGroupDo starFansGroupDo);

  /**
   * 批量插入数据
   *
   * @param starFansGroupDos
   */
  void insertInBatchStarFansGroup(List<StarFansGroupDo> starFansGroupDos);

  /**
   * 更新投票总数
   *
   * @param starId
   * @param voteCount
   */
  void updateVoteCount(@NotNull Long starId, @NotNull Long voteCount);

  /**
   * 更新总守护数
   *
   * @param starId
   * @param
   */
  void updateGuardCount(@NotNull Long starId);


  /**
   * 更新总守护数
   *
   * @param starId
   * @param
   */
  void updateGuardCount(@NotNull Long starId,Long number);

  /**
   * 更新加入粉丝会人数
   *
   * @param starId
   * @param userCount
   */
  boolean updateUserCount(@NotNull Long starId, @NotNull Integer userCount);

  /**
   * 更新投票总用户数
   * @param starId
   * @param
   */
  void incVoteUserCount(@NotNull Long starId);



  /**
   * 更新是否删除 //后台使用
   *
   * @param starId
   * @param isValidEnums
   */
  void updateIsDelete(@NotNull Long starId, @NotNull IsValidEnums isValidEnums);

  /**
   * 查询所有粉丝会详细信息
   *
   * @return
   */
  List<StarFansGroupDo> findAll();

  /**
   * 查询所有粉丝会带分页
   * @param keyWord
   * @param id
   * @param
   * @param limit
   * @return
   */
  List<StarFansGroupDo> findAllStarFansGroup(String keyWord ,String id,IsValidEnums isDelete, @NotNull Integer limit);

  /**
   * 统计关键字搜索的个数
   * @param keyWord
   * @return
   */
  Long countByKeyWords(String keyWord);

   /**
   * 批量查询粉丝会
   *
   * @param idList
   * @return
   */
  List<StarFansGroupDo> findStarFansGroupById(@NotNull Collection<Long> idList);

  /**
   * 关键词搜索明星
   *
   * @param keyWord
   * @return
   */
  List<StarFansGroupDo> findFansGroupByKeyword(@NotNull String keyWord);

  /**
   * 微博id查询明星粉丝会
   *
   * @param weiboId
   * @return
   */
  StarFansGroupDo findFansGroupByWeiboId(@NotNull String weiboId);

  /**
   * 查找粉丝会id最大的粉丝会
   * @return
   */
  Long findMaxStarId();

  /**
   * 统计粉丝会记录数
   * @return
   */
  Long countStarFansGroup();

  /**
   * 更新粉丝会推荐值
   * @param starId
   * @param value
   */
  void updateRecommend(Long starId, long value);

  /**
   * 更新最後更新人【会跟新时间】
   * @param starId
   * @param lastAdminUserId
   */
  void updatelastAdminUserId(Long starId,String lastAdminUserId);

  /**
   * 根据明星姓名精确搜索明星
   * @param starName
   * @return
   */
  List<StarFansGroupDo> findStarByStarName(String starName);

  /**
   * 查询粉丝会，不管删除不删除
   * @param starId
   * @return
   */
  StarFansGroupDo findOneStarFansGroup(Long starId);

  /**
   * 查询推荐的明星
   * @return
   */
  List<StarFansGroupDo> findRecommendStar();

}
