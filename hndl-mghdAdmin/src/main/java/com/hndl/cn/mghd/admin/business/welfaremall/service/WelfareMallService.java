package com.hndl.cn.mghd.admin.business.welfaremall.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.welfaremall.vo.CommodityVo;
import com.hndl.cn.mghd.admin.business.welfaremall.vo.HelpCommodityVo;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/7/25 15:10
 * @Created by 湖南达联
 */
public interface WelfareMallService {

    /**
     * 查询奖品商场所有的商品信息
     *
     * @param id
     * @param welfareNumber 商品期号
     * @return
     */
    Result<Object> findWelfareMall(String id, String welfareNumber, Integer isValidEnums, Integer pageSize);


    /**
     * 增加奖品商场的奖品信息
     *
     * @param commodityVo 奖品信息
     * @param userUinId   操作用户
     * @return
     */
    Result<Object> welfareMallAddCommodity(CommodityVo commodityVo, Long userUinId);

    /**
     * 修改商品
     * @param helpCommodityVo 修改的商品信息
     * @return
     */
    Result<Object> welfareMallUpdateCommodity(HelpCommodityVo helpCommodityVo);

    /**
     * 查询参与过抢福利的用户
     *
     * @param welfareNumber 商品期号
     * @return
     */
    Result<Object> findWelfareGetUser(String welfareNumber, Integer limit);

    /**
     * 修改发货状态
     *
     * @param welfareName 商品名称
     * @param userUniId   用户id
     * @return
     */
    Result<Object> updateUserAddress(String welfareName, Long userUniId, Long receivingNumber);

    /**
     * 查询中奖用户的收货地址
     * @param id    分页使用的id
     * @param welfareName 商品期号
     * @param limit  每页分条
     * @return
     */
    Result<Object> findPrizeUserAddressAll(String id, String welfareName, Integer isDelivery, Integer limit);

}
