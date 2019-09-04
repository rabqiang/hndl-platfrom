package com.hndl.cn.mysql.manager.common.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDoExample;
import com.hndl.cn.dao.common.mapper.CommonUserInfoDoMapper;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/22 10:50
 * @Created by 湖南达联
 */
@Service
public class CommonUserInfoManagerImpl implements CommonUserInfoManager {

    @Resource
    private CommonUserInfoDoMapper commonUserInfoDoMapper;

    private Long sum = 0L;

    @Override
    public CommonUserInfoDo findUserByUniId(Long uniId) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andSysUniIdEqualTo(uniId);
//        criteria.andIsDeletedEqualTo(IsValidEnums.NO.getOldValue());
        List<CommonUserInfoDo> commonUserInfoDos = commonUserInfoDoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(commonUserInfoDos) ? null : commonUserInfoDos.get(0);
    }

    @Override
    public boolean increaseCoinByUserUinId(Long userUinId, Double coin) {
        return commonUserInfoDoMapper.increaseCoinByUserUinId(userUinId, coin) > 0;
    }

    @Override
    public boolean minusCoinByUserUinId(Long userUinId, Double coin) {
        return commonUserInfoDoMapper.minusCoinByUserUinId(userUinId, coin) > 0;
    }

    @Override
    public CommonUserInfoDo findUserByUserId(Long userId) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(userId);
        criteria.andIsDeletedEqualTo(IsValidEnums.NO.getOldValue());
        List<CommonUserInfoDo> commonUserInfoDos = commonUserInfoDoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(commonUserInfoDos) ? null : commonUserInfoDos.get(0);
    }

    @Override
    public CommonUserInfoDo findUserByXcxOpenId(String xcxOpenId) {
        return null;
    }


    @Override
    public CommonUserInfoDo findUserByWeChatUniId(String weChatUniId,IsValidEnums isValidEnums) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andWeixinUniIdEqualTo(weChatUniId);
        if(isValidEnums != null){
            criteria.andIsDeletedEqualTo(isValidEnums.NO.getOldValue());
        }
        List<CommonUserInfoDo> commonUserInfoDos = commonUserInfoDoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(commonUserInfoDos) ? null : commonUserInfoDos.get(0);
    }

    @Override
    public CommonUserInfoDo findUserByMobile(String mobile,IsValidEnums isValidEnums) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneNumEqualTo(mobile);
        criteria.andQqOpenIdIsNull();
        criteria.andWeiboOpenIdIsNull();
        criteria.andWeixinUniIdIsNull();
        if(isValidEnums != null){
            criteria.andIsDeletedEqualTo(isValidEnums.getOldValue());
        }
        List<CommonUserInfoDo> commonUserInfoDos = commonUserInfoDoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(commonUserInfoDos) ? null : commonUserInfoDos.get(0);
    }

    @Override
    public CommonUserInfoDo findUserByWeiBoOpenId(String weiBoOpenId,IsValidEnums isValidEnums) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andWeiboOpenIdEqualTo(weiBoOpenId);
        if(isValidEnums != null){
            criteria.andIsDeletedEqualTo(isValidEnums.NO.getOldValue());
        }
        List<CommonUserInfoDo> commonUserInfoDos = commonUserInfoDoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(commonUserInfoDos) ? null : commonUserInfoDos.get(0);
    }

    @Override
    public CommonUserInfoDo findUserByNickName(String nickName) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andNickNameEqualTo(nickName);
        criteria.andIsDeletedEqualTo(IsValidEnums.NO.getOldValue());
        List<CommonUserInfoDo> commonUserInfoDos = commonUserInfoDoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(commonUserInfoDos) ? null : commonUserInfoDos.get(0);
    }

    @Override
    public CommonUserInfoDo findUserByQqOpenId(String qqOpenId,IsValidEnums isValidEnums) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andQqOpenIdEqualTo(qqOpenId);
        if(isValidEnums != null){
            criteria.andIsDeletedEqualTo(isValidEnums.NO.getOldValue());
        }
        List<CommonUserInfoDo> commonUserInfoDos = commonUserInfoDoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(commonUserInfoDos) ? null : commonUserInfoDos.get(0);
    }

    @Override
    public boolean addUserInfo(CommonUserInfoDo commonUserInfoDo) {
        commonUserInfoDo.setIsDeleted(IsValidEnums.NO.getOldValue());
        commonUserInfoDo.setIsVip(IsValidEnums.NO.getOldValue());
        commonUserInfoDo.setConiCount(0D);
        return commonUserInfoDoMapper.insertSelective(commonUserInfoDo) > 0;
    }

    @Override
    public void updateUserInfo(CommonUserInfoDo commonUserInfoDo) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andSysUniIdEqualTo(commonUserInfoDo.getSysUniId());
        commonUserInfoDoMapper.updateByExampleSelective(commonUserInfoDo, example);
    }

    @Override
    public void updateUserInfoById(CommonUserInfoDo commonUserInfoDo) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(commonUserInfoDo.getSysUniId());
        commonUserInfoDoMapper.updateByExampleSelective(commonUserInfoDo, example);
    }

    @Override
    public CommonUserInfoDo getMaster(Long lastUserId) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(lastUserId);
        List<CommonUserInfoDo> commonUserInfoDos = commonUserInfoDoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(commonUserInfoDos) ? null : commonUserInfoDos.get(0);
    }

    @Override
    public List<Long> getAllUserId(Long pageNo, Integer pageSize) {
        List<Long> longs = new ArrayList<>();
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andSysUniIdIsNotNull();
        pageNo = (pageNo - 1) * pageSize;
        example.setOffset(pageNo);
        example.setLimit(pageSize);
        List<CommonUserInfoDo> commonUserInfoDos = commonUserInfoDoMapper.selectByExample(example);
        commonUserInfoDos.stream().forEach(user -> {
            longs.add(user.getId());
        });
        return longs;
    }


    @Override
    public List<CommonUserInfoDo> getUserAll(CommonUserInfoDo commonUserInfoDo, Long pageNo, Integer pageSize) {
        sum = 0L;
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        if (commonUserInfoDo != null) {
            if (commonUserInfoDo.getId() != null) {//判断id不等于空
                criteria.andIdEqualTo(commonUserInfoDo.getId());
            } else if (commonUserInfoDo.getNickName() != null) {//判断昵称
                criteria.andNickNameEqualTo( commonUserInfoDo.getNickName() );
            } else if (commonUserInfoDo.getPhoneNumPerson() != null) {//判断手机号码
                criteria.andPhoneNumPersonEqualTo(commonUserInfoDo.getPhoneNumPerson());
            } else if (commonUserInfoDo.getNetType() != null) {//运营商
                if ("其它".equals(commonUserInfoDo.getNetType())){
                    criteria.andNetTypeIsNull();
                }
                else{
                    criteria.andNetTypeEqualTo(commonUserInfoDo.getNetType());
                    criteria.andNetTypeIsNotNull();
                }
            } else if (commonUserInfoDo.getAppType() != null) { //手机类型
                criteria.andAppTypeEqualTo(commonUserInfoDo.getAppType());
            } else if (commonUserInfoDo.getPhoneName() != null) {//手机型号
                criteria.andPhoneNameLike(commonUserInfoDo.getPhoneName()+"%");
            } else if (commonUserInfoDo.getCreateTime() != null && commonUserInfoDo.getLastModifyTime() != null) {//时间
                criteria.andCreateTimeBetween(commonUserInfoDo.getCreateTime(), commonUserInfoDo.getLastModifyTime());
            }
        }
        example.setOrderByClause("create_time desc");
        sum =commonUserInfoDoMapper.countByExample(example);
        PageHelper.startPage(pageNo.intValue(), pageSize);
        List<CommonUserInfoDo> coinBillInfoDos = commonUserInfoDoMapper.selectByExample(example);
        PageInfo<CommonUserInfoDo> pageInfo = new PageInfo<>(coinBillInfoDos);
        return null != pageInfo.getList() ? pageInfo.getList() : null;
    }

    @Override
    public List<CommonUserInfoDo> countApprentice(Long userId) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andLastUserIdEqualTo(userId.toString());
        criteria.andLastUserIdIsNotNull();
        return commonUserInfoDoMapper.selectByExample(example);
    }

    @Override
    public List<CommonUserInfoDo> getUserMaster() {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andLastUserIdIsNotNull();
        return commonUserInfoDoMapper.selectByExample(example);
    }


    @Override
    public PageInfo<CommonUserInfoDo> findUserGetNumberById(Long UserUniId, Integer pageNo, Integer pageSize) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneNumPersonIsNotNull();
        if (UserUniId != 0) {
            criteria.andSysUniIdEqualTo(UserUniId);
        }
        PageHelper.startPage(pageNo, pageSize);
        List<CommonUserInfoDo> coinBillInfoDos = commonUserInfoDoMapper.selectByExample(example);
        PageInfo<CommonUserInfoDo> pageInfo = new PageInfo<>(coinBillInfoDos);
        return null != pageInfo ? pageInfo : null;
    }

    @Override
    public Long getUserSum(CommonUserInfoDo commonUserInfoDo) {
        return sum;
    }

    @Override
    public List<CommonUserInfoDo> getUserMasterByPage(Integer pageNo, Integer pageSize) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause( " id asc");
        criteria.andLastUserIdIsNotNull();
        PageHelper.startPage(pageNo, pageSize);
        List<CommonUserInfoDo> list = commonUserInfoDoMapper.selectByExample(example);
        PageInfo<CommonUserInfoDo> pageInfo = new PageInfo<>(list);
        return pageInfo == null ?  new ArrayList<>() : pageInfo.getList();
    }

    /**
     * 查询昵称是否存在
     *
     * @param nickName 昵称
     * @return 是否存在
     */
    @Override
    public boolean existNickName(String nickName) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        example.createCriteria().andIsDeletedEqualTo(IsValidEnums.NO.getOldValue()).andNickNameEqualTo(nickName);
        return  commonUserInfoDoMapper.countByExample(example) > 0 ? true : false;
    }

    @Override
    public Long countNewUserByDate(Date startDate, Date endDate) {
        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        example.createCriteria().andIsDeletedEqualTo(IsValidEnums.NO.getOldValue()).andCreateTimeBetween(startDate, endDate);
        return commonUserInfoDoMapper.countByExample(example);
    }

}
