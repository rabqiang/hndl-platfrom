package com.hndl.cn.utils.collection;

import com.hndl.cn.utils.string.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/15 10:03
 * @Created by 湖南达联
 */
public class CollectionUtils {


    /**
     * 判断是否为空.
     */
    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null) || collection.isEmpty();
    }

    /**
     * 判断是否不为空.
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return (collection != null) && !(collection.isEmpty());
    }

    /*
     * author:wsx
     */
    public static List getSubStringByRandom(List list, int count){
        List backList = new ArrayList();

        Random random = new Random();
        int backSum = 0;
        if (list.size() >= count) {
            backSum = count;
        }else {
            backSum = list.size();
        }
        for (int i = 0; i < backSum; i++) {
//			随机数的范围为0-list.size()-1
            int target = random.nextInt(list.size());
            backList.add(list.get(target));
            list.remove(target);
        }
        return backList;
    }




    /**
     * 非法string集合
     *
     * @param collection
     * @return
     */
    public static boolean illegalStringCollection(Collection<String> collection) {
        if (isEmpty(collection)){
            return true;
        }
        for (String str : collection) {
            boolean flag = StringUtils.isBlank(str);
            if (flag) {
                return flag;
            }
        }
        return true;
    }

    /**
     * 包含Null
     *
     * @param collection
     * @return
     */
    public static boolean hasNull(Collection<?> collection) {
        return collection.contains(null);
    }

    /**
     * 不包含null
     *
     * @param collection
     * @return
     */
    public static boolean notHasNull(Collection<?> collection) {
        return false == collection.contains(null);
    }


}
