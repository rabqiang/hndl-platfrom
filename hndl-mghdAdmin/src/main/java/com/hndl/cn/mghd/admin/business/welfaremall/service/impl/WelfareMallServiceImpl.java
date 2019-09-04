package com.hndl.cn.mghd.admin.business.welfaremall.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.math.NumberEnums;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.admin.business.resources.service.ResourcesService;
import com.hndl.cn.mghd.admin.business.welfaremall.service.WelfareMallService;
import com.hndl.cn.mghd.admin.business.welfaremall.vo.AddressVo;
import com.hndl.cn.mghd.admin.business.welfaremall.vo.CommodityVo;
import com.hndl.cn.mghd.admin.business.welfaremall.vo.HelpCommodityVo;
import com.hndl.cn.mghd.admin.business.welfaremall.vo.WelfareMallVo;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mghd.admin.exception.MghdAdminExceptionEnums;
import com.hndl.cn.mongodb.manager.luckdraw.bean.HelpWelfareDo;
import com.hndl.cn.mongodb.manager.luckdraw.bean.UserWelfareMappingDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.HelpWelfareManager;
import com.hndl.cn.mongodb.manager.luckdraw.manager.UserWelfareMappingManager;
import com.hndl.cn.mongodb.manager.user.bean.UserReceivingAddressDo;
import com.hndl.cn.mongodb.manager.user.manager.UserReceivingAddressManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import com.hndl.cn.utils.reg.RegExUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/7/25 16:58
 * @Created by 湖南达联
 */
@Service
public class WelfareMallServiceImpl implements WelfareMallService {

    private static final Logger log = LoggerFactory.getLogger(WelfareMallServiceImpl.class);
    @Resource
    private HelpWelfareManager helpWelfareManager;
    @Resource
    private CommonUserInfoManager commonUserInfoManager;
    @Resource
    private UserReceivingAddressManager userReceivingAddressManager;

    @Resource
    private UserWelfareMappingManager userWelfareMappingManager;

    @Resource
    private ResourcesService resourcesService;
    @Resource
    private RedisService redisService;


    /**
     * 查询奖品信息
     *
     * @param id
     * @param welfareNumber
     * @return
     */
    @Override
    public Result<Object> findWelfareMall(String id, String welfareNumber, Integer isValidEnums, Integer pagerSize) {
//        1.创建保存奖品信息的ListVo
        List<WelfareMallVo> mallVoArrayList = new ArrayList<>();
        //2.查询奖品信息
        List<HelpWelfareDo> helpUserById = helpWelfareManager.findHelpUserById(id, welfareNumber, isValidEnums, pagerSize);
        if (helpUserById.size() == 0) {
            log.info("============findWelfareMall方法 查询信息为空=============");
            return ResultFactory.success(mallVoArrayList);
        }
        for (HelpWelfareDo helpWelfareDo : helpUserById) {
            WelfareMallVo convert = SpringCglibBeanUtils.convert(helpWelfareDo, WelfareMallVo.class);
            //查询参与此福利的用户数
            convert.setParticipants(userWelfareMappingManager.findUserWelfareByWelfareNumber(helpWelfareDo.getWelfareNumber(), null).size());
            //将用户list<Long>转换为list<String>类型保证精度
            if (helpWelfareDo.getSuccessUserUniId() != null)
                convert.setSuccessUserUniId(helpWelfareDo.getSuccessUserUniId().stream().map(s -> (s.toString())).collect(Collectors.toList()));
            mallVoArrayList.add(convert);
        }
        //3.返回奖品信息的listVo
        return ResultFactory.success(mallVoArrayList);
    }


    /**
     * 增加奖品
     * 可能会同时调用所有在方法中添加synchronized,保存同步
     *
     * @param commodityVo
     * @return
     */
    @Override
    public synchronized Result<Object> welfareMallAddCommodity(CommodityVo commodityVo, Long userUinId) {
        //设置奖品期号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//获取当前的年月日
        // 1.获取当日增加了多少商品再加1
        String format = String.format("%02d", helpWelfareManager.countAddCommodity() + 1);
        //2.将相同的属性保存到福利商场的do中
        HelpWelfareDo helpWelfareDo = SpringCglibBeanUtils.convert(commodityVo, HelpWelfareDo.class);
        //判断当前用户输入的福利开始时间不能小于当前时间
        if (helpWelfareDo.getStartTime() < LocalDateTimeUtil.getNowMinTimeMilli()) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_START_DATE_ERROR.getCode());
        }
        //结束时间必须大于开始时间
        if (helpWelfareDo.getEndTime() < helpWelfareDo.getStartTime() & helpWelfareDo.getEndTime() < System.currentTimeMillis()) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_END_DATE_ERROR.getCode());
        }
        //3.然后将日期和当日增加多少商品数保存到商品期号中
        helpWelfareDo.setWelfareNumber(sdf.format(new Date()) + format);
        helpWelfareDo.setCreateName(userUinId);                       //用户id
        //判断奖品封面图的地址是否本项目临时图片
        if (RegExUtil.isImgUrl(commodityVo.getPrizeImg())) {
            String replaceImg = commodityVo.getPrizeImg().replace("min_img", "max_img");
            String registerHelpWelfareImg = resourcesService.registerHelpWelfareImg(replaceImg);
            String replace = registerHelpWelfareImg.replace("http://", "https://");
            helpWelfareDo.setPrizeImg(replace);//奖品封面图
        } else {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_WELFARE_DATA_EXCEPTION.getCode());
        }

        //1.创建保存奖品详细信息的list
        List<String> listImg = new ArrayList<>();
        //2.将图片一个一个注册保存的奖品信息图片的list
        for (String img : commodityVo.getDetailsPrizeImg()) {
            if (RegExUtil.isImgUrl(img)) {
                String replaceImg = img.replace("min_img", "max_img");
                String registerHelpWelfareImg = resourcesService.registerHelpWelfareImg(replaceImg);
                String replace = registerHelpWelfareImg.replace("http://", "https://");
                listImg.add(replace);
            } else {
                throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_WELFARE_DATA_EXCEPTION.getCode());
            }
        }
        //判断设置前几名不能小于奖品值
        if (commodityVo.getSortCount() < commodityVo.getPrizeCount()) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN__WELFARENUMBER_SORTCOUNT_LESS_PRIZECOUNT.getCode());
        }
        //保存奖品详情信息保存的属性中
        helpWelfareDo.setDetailsPrizeImg(listImg); //保存奖品详细信息
        helpWelfareDo.setDescription(commodityVo.getDescription()); //商品描述
        helpWelfareManager.insertHelpWelfare(helpWelfareDo);
        //刷新 redis 缓存
        String key = MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getCacheKey(NumberEnums.ONE.getEnglish());
        redisService.set(key, null, MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getExpireTime());
        return ResultFactory.success();
    }

    /**
     * 修改商品信息
     *
     * @param helpCommodityVo
     * @return
     */
    @Override
    public Result<Object> welfareMallUpdateCommodity(HelpCommodityVo helpCommodityVo) {
        HelpWelfareDo helpWelfare = helpWelfareManager.findWelfarePrizeByWelfareNumber(helpCommodityVo.getWelfareNumber());
        //判断查询福利商品存在并且现在开奖状态是未开奖方可修改
        if (helpWelfare != null && helpWelfare.getIsSuccess() == IsValidEnums.NO.getValue()) {
            HelpWelfareDo helpWelfareDo = new HelpWelfareDo();
            //判断奖品封面图的地址是否本项目临时图片
            if (StringUtils.isNotEmpty(helpCommodityVo.getPrizeImg()) && RegExUtil.isImgUrl(helpCommodityVo.getPrizeImg())) {
                String replaceImg = helpCommodityVo.getPrizeImg().replace("min_img", "max_img");
                String registerHelpWelfareImg = resourcesService.registerHelpWelfareImg(replaceImg);
                String replace = registerHelpWelfareImg.replace("http://", "https://");
                helpWelfareDo.setPrizeImg(replace);//奖品封面图
            }
            if (CollectionUtils.isNotEmpty(helpCommodityVo.getDetailsPrizeImg())) {
                //1.创建保存奖品详细信息的list
                List<String> listImg = new ArrayList<>();
                //2.将图片一个一个注册保存的奖品信息图片的list
                if (helpCommodityVo.getDetailsPrizeImg() != null) {
                    for (String img : helpCommodityVo.getDetailsPrizeImg()) {
                        if (RegExUtil.isImgUrl(img)) {
                            String replaceImg = img.replace("min_img", "max_img");
                            String registerHelpWelfareImg = resourcesService.registerHelpWelfareImg(replaceImg);
                            String replace = registerHelpWelfareImg.replace("http://", "https://");
                            listImg.add(replace);
                        }
                    }
                    helpWelfareDo.setDetailsPrizeImg(listImg);
                }
            }

            // .获取指定用户中奖Id
            if (CollectionUtils.isNotEmpty(helpCommodityVo.getSuccessUserUniId())) {
                CommonUserInfoDo user1 = commonUserInfoManager.findUserByUserId(helpCommodityVo.getSuccessUserUniId().get(0));
                //根据奖品期号及用户id查询用户是否参与此次活动
                if (! ObjectUtils.isEmpty(user1)) {
                    UserWelfareMappingDo mappingDo = userWelfareMappingManager.queryHelpCountByUserId(helpCommodityVo.getWelfareNumber(), user1.getSysUniId());
                    if (mappingDo == null) {
                        throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_OF_VALUE_NOT_ENOUGH.getCode());
                    } else if (mappingDo.getHelpCount() == 0) {
                        throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN__VALUE_NOT_ENOUGH.getCode());
                    } else {
                        List<Long> user = new ArrayList<>();
                        user.add(mappingDo.getUserUniId());
                        helpWelfareDo.setSuccessUserUniId(user);
                    }
                }
            }


            if (StringUtils.isNotEmpty(helpCommodityVo.getDescription()))
                helpWelfareDo.setDescription(helpCommodityVo.getDescription());
            helpWelfareDo.setWelfareNumber(helpCommodityVo.getWelfareNumber());
            helpWelfareDo.setSortCount(helpCommodityVo.getSortCount());
            helpWelfareManager.updateHelpWelfare(helpWelfareDo);
            //刷新 redis 缓存
            String key = MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getCacheKey(NumberEnums.ONE.getEnglish());
            redisService.set(key, null, MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getExpireTime());
            return ResultFactory.success();
        } else {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_WELFARENUMBER__NOT_ZERO.getCode());
        }
    }


    /**
     * 查询参与此福利商品的用户(目前暂时没用)
     *
     * @param welfareNumber 商品期号
     * @return
     */
    @Override
    public Result<Object> findWelfareGetUser(String welfareNumber, Integer limit) {
        //1.创建参与此福利的用户id的listVo
        List<Long> userWelfare = new ArrayList<>();
        //2.查询参与此福利的用户信息
        List<UserWelfareMappingDo> userWelfareByWelfareNumberList = userWelfareMappingManager.findUserWelfareByWelfareNumber(welfareNumber, limit);
        for (UserWelfareMappingDo userWelfareMappingDo : userWelfareByWelfareNumberList) {
            //将查询出来的用户id保存到listVo中
            userWelfare.add(userWelfareMappingDo.getUserUniId());
        }
        //3.返回用户idListVo信息
        return ResultFactory.success(userWelfare);
    }

    /**
     * 修改发货状态   (目前暂时没用)
     *
     * @param welfareName 商品名称
     * @param userUniId   用户id
     * @return
     */
    @Override
    public Result<Object> updateUserAddress(String welfareName, Long userUniId, Long receivingNumber) {
        if (userReceivingAddressManager.findAddressByWelfareNumber(userUniId, welfareName) != null) {
            //1.实例化中奖用户的收货地址的类
            UserReceivingAddressDo addressDo = new UserReceivingAddressDo();
            //将需要修改和查询条件添加到地址类中
            addressDo.setUserUniId(userUniId);
            addressDo.setWelfareNumber(welfareName);
            addressDo.setReceivingNumber(receivingNumber);
            addressDo.setIsDelivery(2);
            //2.调用方法进行修改用户领奖
            userReceivingAddressManager.setUserReceiving(addressDo);
            return ResultFactory.success();
        }
        return ResultFactory.failure();
    }

    /**
     * 查询中奖用户的收货地址
     *
     * @param id          分页使用的id
     * @param welfareName 商品期号
     * @param limit       每页分条
     * @return
     */
    @Override
    public Result<Object> findPrizeUserAddressAll(String id, String welfareName, Integer isDelivery, Integer limit) {
        //1.返回中奖用户的收货地址的listVo
        List<AddressVo> addressVoList = new ArrayList<>();
        // 2.查询中奖用户的收货信息
        List<UserReceivingAddressDo> userReceivingAddressDoList = userReceivingAddressManager.findUserAddress(id, welfareName, isDelivery, limit);
        if (CollectionUtils.isEmpty(userReceivingAddressDoList)) {
            log.info("==========================findPrizeUserAddressAll方法查询信息为空==========================");
            return ResultFactory.success(addressVoList);
        }
        for (UserReceivingAddressDo addressDo : userReceivingAddressDoList) {
            //将 收货信息与收货地址Vo对象之间转换
            AddressVo addressVo = SpringCglibBeanUtils.convert(addressDo, AddressVo.class);
            addressVo.setUserUniId(addressDo.getUserUniId().toString());
            HelpWelfareDo welfarePrizeByWelfareNumber = helpWelfareManager.findWelfarePrizeByWelfareNumber(addressDo.getWelfareNumber());
            if (welfarePrizeByWelfareNumber != null) {
                //查询用户中奖名称
                addressVo.setWelfareName(helpWelfareManager.findWelfarePrizeByWelfareNumber(addressDo.getWelfareNumber()).getPrizeName());
                //查询用户昵称
                addressVo.setSuccessUserName(commonUserInfoManager.findUserByUniId(addressDo.getUserUniId()).getNickName());
            }
            //3.将查询的信息保存到收货地址的listVo
            addressVoList.add(addressVo);
        }
        //4.返回数据
        return ResultFactory.success(addressVoList);
    }

}
