package com.hndl.cn.dao.user.mapper;

import com.hndl.cn.dao.user.bean.UserFollowRelationDo;
import com.hndl.cn.dao.user.bean.UserFollowRelationDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFollowRelationDoMapper {
    long countByExample(UserFollowRelationDoExample example);

    int deleteByExample(UserFollowRelationDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserFollowRelationDo record);

    int insertSelective(UserFollowRelationDo record);

    List<UserFollowRelationDo> selectByExample(UserFollowRelationDoExample example);

    UserFollowRelationDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserFollowRelationDo record, @Param("example") UserFollowRelationDoExample example);

    int updateByExample(@Param("record") UserFollowRelationDo record, @Param("example") UserFollowRelationDoExample example);

    int updateByPrimaryKeySelective(UserFollowRelationDo record);

    int updateByPrimaryKey(UserFollowRelationDo record);
}