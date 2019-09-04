package com.hndl.cn.utils.number;

import java.util.*;

/**
 * @author 赵俊凯
 * @Description 快乐币转换方法
 * @Date 2019/4/22 15:05
 * @Created by 湖南达联
 */
public class CoinUtils {


    public static Double longConvertDouble(Long coin){
        if(coin == null){
           return 0D;
        }
       return (double)(coin / 100) ;
    }


    public static Long doubleConvertLong(Double coin){
        if(coin == null){
            return 0L;
        }
        Double newCoin = coin * 100;
        return newCoin.longValue();
    }


    /**
     * 分转元
     * @param coin
     * @return
     */
    public static Integer centToOval(Long coin){

        if(coin == null){
           throw new NullPointerException(" coin is not null !");
        }

        if(coin % 100 != 0 && coin < 0){
           throw new NumberFormatException("coin error!coin ="+ coin);
        }
        return coin.intValue() / 100;
    }

    /**
     * 校验参数是否是100的整数
     * @param coin
     * @return
     */
    public static boolean checkCoin(Long coin){
        if(coin % 100 == 0  && coin != 0L && coin > 0){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>(12);
        map.put(1,"10积分");
        map.put(2,"20积分");
        map.put(3,"100积分");
        map.put(4,"1000积分");


        List<Integer> list = new ArrayList<>(10000);

        map.keySet().stream().forEach(key-> {
            int weight = 0;
              switch (key){
                  case 1:
                      weight = 8000;
                      for(int i = 0;i < weight; i++){
                          list.add(key);
                      }
                      break;
                  case 2:
                      weight = 1800;
                      for(int i = 0;i < weight; i++){
                          list.add(key);
                      }
                      break;
                  case 3:
                      weight = 180;
                      for(int i = 0;i < weight; i++){
                          list.add(key);
                      }
                      break;
                  case 4:
                      weight = 20;
                      for(int i = 0;i < weight; i++){
                          list.add(key);
                      }
                      break;
                  default:
                      break;

              }
        });
        Collections.shuffle(list);

        Map<Integer,Integer> testMap = new HashMap(4);

        Random random = new Random();
        for(int j = 0 ; j < 100000 ; j ++){

            int index = random.nextInt(10000);
            int code = list.get(index);
            Integer count = testMap.get(code);
            if(count == null){
                testMap.put(code,1);
            }else {
                testMap.put(code,count+1);
            }

        }
        System.out.println(testMap);
    }
}
