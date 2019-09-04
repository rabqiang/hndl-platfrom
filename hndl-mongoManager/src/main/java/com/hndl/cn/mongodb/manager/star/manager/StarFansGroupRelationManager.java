package com.hndl.cn.mongodb.manager.star.manager;


import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.permission.RelationPermissionEnum;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupRelationDo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 易成贤
 * @Description 明星与用户之间的关系
 * @Date 2019/4/18 10:54
 * @Created by 湖南达联
 */
public interface StarFansGroupRelationManager {

    /**
     * 创建用户粉丝会关系
     * @param userUinId
     * @param starId
     */
    void insertStarFansGroupRelation(@NotNull Long userUinId,@NotNull Long starId);


    /**
     * 批量插入数据
     * @param list
     */
    void inbanch(List<StarFansGroupRelationDo> list);
    /**
     * 根据用户id和粉丝会查询这个明星粉丝会关系,没有就应该返回null
     */
    StarFansGroupRelationDo findStarFansGroupRelation(@NotNull Long userUinId, @NotNull Long starId);


    /**
     * 根据用户id查询所有粉丝会
     * @param userUinId
     * @return
     */
    List<StarFansGroupRelationDo> findByUserUinId(@NotNull Long userUinId);


    /**
     *
     * 查询粉丝会粉丝数量
     * @return 粉丝会粉丝的数量
     */
    Long getFansCountByStarId(Long starId);

    /**
     * 查询用户关注粉丝会的数量
     * @param userUinId 用户id
     * @return
     */
    Long getFansCountByUserUinId(@NotNull Long userUinId) ;

    /**
     * 获取粉丝会中指定权限的粉丝数量<br/>
     * exp：查询粉丝会关系表,然后统计粉丝会中普通权限的粉丝数量
     * @param relationPermission 权限枚举
     * @return
     */
    Integer getPowerFansCount(@NotNull Long starId,@NotNull RelationPermissionEnum relationPermission);

    /**
     * 更新粉丝权限
     * @param relationPermission 粉丝权限的枚举
     * @param starFansGroupRelation
     */
    void updatePower(@NotNull RelationPermissionEnum relationPermission,@NotNull StarFansGroupRelationDo starFansGroupRelation);


    /**
     * 更新粉丝会与粉丝信息数据
     *
     * @param starFansGroupRelation
     */
    void updateStarFansGroupRelation(StarFansGroupRelationDo starFansGroupRelation);


    /**
     * 更新粉丝会贡献值/粉丝票数/比心票数/积分打榜/爱心数量
     * @param userUinId
     * @param starId
     * @param voteTypeEnum
     * @param voteNum
     */
    public void updateVote(@NotNull Long userUinId, @NotNull Long starId,@NotNull VoteTypeEnums voteTypeEnum, @NotNull Long voteNum );

    /**
     * 更新是否删除字段
     * @param sysUniId
     * @param starId
     */
    void updateIsDelete(@NotNull Long sysUniId, @NotNull Long starId, @NotNull IsValidEnums isValidEnums);

    /**
     * 获取粉丝会中指定权限的用户
     * @param starId
     * @param relationPermissionEnum
     * @return
     */
    List<StarFansGroupRelationDo> getPowerFans(@NotNull Long starId,@NotNull RelationPermissionEnum relationPermissionEnum);

    /**
     * 查询用户投没投过票
     * @param userUinId
     * @param starId
     * @return
     */
    boolean findVote(Long userUinId, Long starId);

    /**
     * 更新累计打榜天数
     * @param userUinId
     * @param starId
     * @return
     */
    boolean updateVoteDayCount(@NotNull Long userUinId, @NotNull Long starId);

    /**
     * 根据粉丝会id删除关系
     * @param starId
     */
    void updateIsDeleteBystarId( Long starId,IsValidEnums isDelete);


    void insert(@NotNull StarFansGroupRelationDo starFansGroupRelationDo);



}
