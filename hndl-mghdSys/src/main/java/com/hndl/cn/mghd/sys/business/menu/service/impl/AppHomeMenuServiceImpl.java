package com.hndl.cn.mghd.sys.business.menu.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.RequestTypeEnums;
import com.hndl.cn.dao.system.bean.SystemAppMenuNewDo;
import com.hndl.cn.mghd.sys.business.menu.service.AppHomeMenuService;
import com.hndl.cn.mghd.sys.business.menu.service.CommonUserMenuInfoService;
import com.hndl.cn.mghd.sys.business.menu.vo.AppHomeMenuVo;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.mysql.manager.system.manager.SystemAppMenuNewManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description
 * @Date 2019/5/23 16:18
 * @Created by 湖南达联
 */
@Service
public class AppHomeMenuServiceImpl implements AppHomeMenuService {

    private static final Logger log = LoggerFactory.getLogger(AppHomeMenuServiceImpl.class);

    @Resource
    private SystemAppMenuNewManager systemAppMenuNewManager;

    @Resource
    private CommonUserMenuInfoService commonUserMenuInfoService;

    @Resource
    private RedisService redisService;


    @Override
    public List<AppHomeMenuVo> findAppHomeMenu(String source,String version) {

        List<SystemAppMenuNewDo> appMenu = this.findAppMenu();


            if(RequestTypeEnums.IOS.getValue().equals(source)){
                Integer sysVersion = commonUserMenuInfoService.findSysVersion();

                List<AppHomeMenuVo> list = new ArrayList<>();

                for(SystemAppMenuNewDo appMenuNewDo : appMenu){
                    //版本号
                    if(sysVersion < StringUtils.stringToInteger(version)
                            &&IsValidEnums.YES.getOldValue().equals(appMenuNewDo.getOther3())){
                        continue;
                    }
                    AppHomeMenuVo vo = SpringCglibBeanUtils.convert(appMenuNewDo,AppHomeMenuVo.class);
                    list.add(vo);
                }
                return list;
            }else {
                return SpringCglibBeanUtils.convertByList(appMenu,AppHomeMenuVo.class);
            }

    }

    private List<SystemAppMenuNewDo> findAppMenu(){
         String key = MgHdRedisKeyEnums.APP_HOME_MENU_KEY.getCacheKey();
         List<SystemAppMenuNewDo> list = redisService.get(key);

         if(CollectionUtils.isNotEmpty(list)){
              return list;
         }else {
             list = systemAppMenuNewManager.findAppHomeSystemAppMenu();
             redisService.set(key,list,MgHdRedisKeyEnums.APP_HOME_MENU_KEY.getExpireTime());
             return list;
         }
    }
}
