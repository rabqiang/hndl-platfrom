package com.hndl.cn.shop.sys.config;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.prize.bean.LuckyTurntableInfoDo;
import com.hndl.cn.mysql.manager.prize.manager.LuckyTurntableManager;
import com.hndl.cn.shop.sys.business.turntable.vo.LuckyTurntableVo;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/7/17 15:36
 * @Created by 湖南达联
 */
@Slf4j
public class LuckyTurntableConfig implements Serializable{


    private static List<Long>  prizeAllList;//所有的奖品池

    private  static List<Long>  integralPrizeList;//积分奖品池

    private  static List<LuckyTurntableVo> luckyTurntableVos;//奖品列表

    private  static Map<Long,LuckyTurntableInfoDo> luckyTurntableDos;//奖品列表Do

    private static AtomicInteger atomicInteger = new AtomicInteger(0);


    private LuckyTurntableManager luckyTurntableManager;


    public LuckyTurntableConfig(LuckyTurntableManager luckyTurntableManager){
        this.luckyTurntableManager = luckyTurntableManager;
        //刷新奖品池
        this.savePrizeList();
    }


    /**
     * 用户抽奖所有
     * @return
     */

    public Long luckAllDraw(Integer version){
        if(version != atomicInteger.get()){
           return null;
        }
        Random random = new Random();
        int index = random.nextInt(prizeAllList.size());
        return prizeAllList.get(index);
    }

    /**
     * 用户抽奖
     * @return
     */
    public Long luckIntegralDraw(Integer version){
        if(version != atomicInteger.get()){
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(integralPrizeList.size());
        return integralPrizeList.get(index);
    }

    /**
     * 获取奖品列表
     * @return
     */

    public List<LuckyTurntableVo> getLuckyTurntableVos(){
        return luckyTurntableVos;
    }

    /**
     * 获取奖品do列表
     * @return
     */
    public Map<Long,LuckyTurntableInfoDo> getLuckyTurntableDos(){
        return luckyTurntableDos;
    }

    public LuckyTurntableVo getDefault(){
        LuckyTurntableVo luckyTurntableVo = new LuckyTurntableVo();
        luckyTurntableVo.setVersion(atomicInteger.get());
        return luckyTurntableVo;
    }

    /**
     * 保存奖品池
     */
    public void savePrizeList(){
        int incrementAndGet = atomicInteger.incrementAndGet();
        List<LuckyTurntableInfoDo> luckyTurntable =  this.luckyTurntableManager.findLuckyTurntable(IsValidEnums.NO);
        if(CollectionUtils.isEmpty(luckyTurntable)){
            log.error("===============转盘奖品未配置,保存失败====================");
        }else {
            luckyTurntable.stream().filter(info -> info != null).forEach(info ->  log.info("=======成功配置奖品:{}=======",info.toString()));
        }


        List<Long> allList = new ArrayList<>(luckyTurntable.size());

        luckyTurntable.stream().filter(info -> this.checkLuckyTurntableInfoDo(info)).forEach( into -> {
             int count = into.getWeightNum();
             for(int i = 0 ; i < count ; i ++){
                 allList.add(into.getId());
             }
        });
        Collections.shuffle(allList);

        List<Long>  integralList =new ArrayList<>(luckyTurntable.size());
        luckyTurntable.stream().filter(info -> this.checkLuckyTurntableInfoDo(info) &&
                info.getIsEntity().equals(IsValidEnums.NO.getValue())).forEach(into -> {
            int count = into.getWeightNum();
            for(int i = 0 ; i < count ; i ++){
                integralList.add(into.getId());
            }
        });

        Collections.shuffle(integralList);

        prizeAllList = allList;
        log.info("==========奖品池刷新成功============");
        integralPrizeList = integralList;
        log.info("==========积分奖品池刷新成功============");
        Map<Long,LuckyTurntableInfoDo> map = new HashMap();
        luckyTurntable.forEach(val -> map.put(val.getId(),val));
        luckyTurntableDos =  map;
        log.info("==========奖品Do列表刷新成功============");

        luckyTurntableVos = luckyTurntable.stream().filter(info -> info != null).map(info -> {
            LuckyTurntableVo luckyTurntableVo = SpringCglibBeanUtils.convert(info,LuckyTurntableVo.class);
            luckyTurntableVo.setVersion(atomicInteger.get());
            return luckyTurntableVo;
        }).collect(Collectors.toList());


        log.info("=========奖品列表刷新成功=============");

    }


    /**
     * 校验是否合法
     * @param infoDo
     * @return
     */
    private boolean checkLuckyTurntableInfoDo(LuckyTurntableInfoDo infoDo){
        return  infoDo !=null && infoDo.getWeightNum() != null;
    }

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,1,1,3,4);
        Integer integer = list.stream().reduce((x, y) -> x + y).get();
        System.out.println(integer);

    }


}
