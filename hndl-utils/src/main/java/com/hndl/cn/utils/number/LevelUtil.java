package com.hndl.cn.utils.number;

import com.hndl.cn.utils.string.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 2019年4月15日 00:11:27
 * 等级Util,用于获取用户等级配置,获取收徒奖励积分配置,获取等级对应任务积分翻倍数值配置
 *
 * @author Longmao
 */
public class LevelUtil {

    /**
     * 等级/经验 对应配置
     */
    public final static Map<Integer, Integer> levelConfig = new HashMap<Integer, Integer>();
    /**
     * 收徒个数/收徒奖励积分 对应配置
     */
    public final static Map<Integer, Integer> pupilCountFraction = new HashMap<Integer, Integer>();
    /**
     * 等级/任务积分翻倍数值 对应配置
     */
    public final static Map<Integer, Double> levelCoefficient = new HashMap<Integer, Double>();

    static {
        levelConfig.put(1, 0);
        levelConfig.put(2, 300);
        levelConfig.put(3, 800);
        levelConfig.put(4, 1500);
        levelConfig.put(5, 3000);
        levelConfig.put(6, 4500);
        levelConfig.put(7, 6000);
        levelConfig.put(8, 8000);
        levelConfig.put(9, 10000);
        levelConfig.put(10, 15000);
        levelConfig.put(11, 20000);
        levelConfig.put(12, 25000);
        levelConfig.put(13, 30000);
        levelConfig.put(14, 40000);
        levelConfig.put(15, 50000);
        levelConfig.put(16, 100000);
        levelConfig.put(17, 200000);
        levelConfig.put(18, 400000);
        levelConfig.put(19, 600000);
        levelConfig.put(20, 1000000);
        levelConfig.put(21, 1500000);
        levelConfig.put(22, 2000000);
        levelConfig.put(23, 2500000);
        levelConfig.put(24, 3000000);
        levelConfig.put(25, 3500000);

        pupilCountFraction.put(1, 50);
        pupilCountFraction.put(11, 100);
        pupilCountFraction.put(31, 150);
        pupilCountFraction.put(51, 200);

        levelCoefficient.put(1, 1.0);
        levelCoefficient.put(4, 1.1);
        levelCoefficient.put(7, 1.2);
        levelCoefficient.put(10, 1.3);
        levelCoefficient.put(13, 1.5);
        levelCoefficient.put(16, 1.8);
        levelCoefficient.put(19, 2.0);
    }

    /**
     * 2019年4月15日 00:11:32
     *
     * @param currentValue 已收徒个数
     * @return 收徒应得积分
     * @author Longmao
     * 收徒 根据已有徒弟个数计算应得积分
     */
    public static int getContributionLevelFraction(Integer currentValue) {
        if (currentValue == null || currentValue.equals("") || currentValue < 0) {
            return 0;
        }
        // 小于等于10个徒弟，则收徒奖励50积分
        if (currentValue <= 10) {
            return pupilCountFraction.get(1);
            // 小于等于30个徒弟，则收徒奖励100积分
        } else if (currentValue > 10 && currentValue <= 30) {
            return pupilCountFraction.get(11);
            // 小于等于50个徒弟，则收徒奖励150积分
        } else if (currentValue > 30 && currentValue <= 50) {
            return pupilCountFraction.get(31);
            // 小于等于100个徒弟，则收徒奖励200积分
        } else if (currentValue > 50 && currentValue <= 100) {
            return pupilCountFraction.get(51);
        }
        return 0;
    }

    /**
     * 2019年4月15日 00:11:35
     *
     * @param userLevel 用户等级
     * @return 积分奖励倍数
     * @author Longmao
     * 根据等级获取任务积分翻倍倍数
     */
    public static Double getContributionlevelCoefficient(Integer userLevel) {
        Double integralMultiple = 0D;
        // 判空
        if (userLevel == null ||userLevel < 0 ) {
            integralMultiple = 1.0;
        }
        // 如果小于4级，则为1.0倍积分奖励
        if (userLevel <= 3) {
            integralMultiple = levelCoefficient.get(1);
            // 如果小于7级，则为1.1倍积分奖励
        } else if (userLevel > 3 && userLevel <= 6) {
            integralMultiple = levelCoefficient.get(4);
            // 如果小于10级，则为1.2倍积分奖励
        } else if (userLevel > 6 && userLevel <= 9) {
            integralMultiple = levelCoefficient.get(7);
            // 如果小于13级，则为1.3倍积分奖励
        } else if (userLevel > 9 && userLevel <= 12) {
            integralMultiple = levelCoefficient.get(10);
            // 如果小于16级，则为1.5倍积分奖励
        } else if (userLevel > 12 && userLevel <= 15) {
            integralMultiple = levelCoefficient.get(13);
            // 如果小于19级，则为1.8倍积分奖励
        } else if (userLevel > 15 && userLevel <= 18) {
            integralMultiple = levelCoefficient.get(16);
            // 如果大于18级，则为2.0倍积分奖励
        } else if (userLevel > 18) {
            integralMultiple = levelCoefficient.get(19);
        }
        return integralMultiple;
    }

    /**
     * 2019年4月15日 00:11:38
     *
     * @param experienceValue 经验值
     * @return level 等级值
     * @author Longmao
     * 功能： 根据用户经验值计算用户对应等级
     */
    public static int getContributionLevel(Integer experienceValue) {
        // 默认等级0
        int level = 0;
        if (experienceValue == null ||experienceValue < NumberUtils.INTEGER_ZERO ) {
            return level;
        }
        // 如果经验值大于等于0并且小于10
        if (experienceValue >= levelConfig.get(1) && experienceValue <= levelConfig.get(2) - 1) {
            level = 1;
        } else if (experienceValue >= levelConfig.get(2) && experienceValue <= levelConfig.get(3) - 1) {
            level = 2;
        } else if (experienceValue >= levelConfig.get(3) && experienceValue <= levelConfig.get(4) - 1) {
            level = 3;
        } else if (experienceValue >= levelConfig.get(4) && experienceValue <= levelConfig.get(5) - 1) {
            level = 4;
        } else if (experienceValue >= levelConfig.get(5) && experienceValue <= levelConfig.get(6) - 1) {
            level = 5;
        } else if (experienceValue >= levelConfig.get(6) && experienceValue <= levelConfig.get(7) - 1) {
            level = 6;
        } else if (experienceValue >= levelConfig.get(7) && experienceValue <= levelConfig.get(8) - 1) {
            level = 7;
        } else if (experienceValue >= levelConfig.get(8) && experienceValue <= levelConfig.get(9) - 1) {
            level = 8;
        } else if (experienceValue >= levelConfig.get(9) && experienceValue <= levelConfig.get(10) - 1) {
            level = 9;
        } else if (experienceValue >= levelConfig.get(10) && experienceValue <= levelConfig.get(11) - 1) {
            level = 10;
        } else if (experienceValue >= levelConfig.get(11) && experienceValue <= levelConfig.get(12) - 1) {
            level = 11;
        } else if (experienceValue >= levelConfig.get(12) && experienceValue <= levelConfig.get(13) - 1) {
            level = 12;
        } else if (experienceValue >= levelConfig.get(13) && experienceValue <= levelConfig.get(14) - 1) {
            level = 13;
        } else if (experienceValue >= levelConfig.get(14) && experienceValue <= levelConfig.get(15) - 1) {
            level = 14;
        } else if (experienceValue >= levelConfig.get(15) && experienceValue <= levelConfig.get(16) - 1) {
            level = 15;
        } else if (experienceValue >= levelConfig.get(16) && experienceValue <= levelConfig.get(17) - 1) {
            level = 16;
        } else if (experienceValue >= levelConfig.get(17) && experienceValue <= levelConfig.get(18) - 1) {
            level = 17;
        } else if (experienceValue >= levelConfig.get(18) && experienceValue <= levelConfig.get(19) - 1) {
            level = 18;
        } else if (experienceValue >= levelConfig.get(19) && experienceValue <= levelConfig.get(20) - 1) {
            level = 19;
        } else if (experienceValue >= levelConfig.get(20) && experienceValue <= levelConfig.get(21) - 1) {
            level = 20;
        } else if (experienceValue >= levelConfig.get(21) && experienceValue <= levelConfig.get(22) - 1) {
            level = 21;
        } else if (experienceValue >= levelConfig.get(22) && experienceValue <= levelConfig.get(23) - 1) {
            level = 22;
        } else if (experienceValue >= levelConfig.get(23) && experienceValue <= levelConfig.get(24) - 1) {
            level = 23;
        } else if (experienceValue >= levelConfig.get(24) && experienceValue <= levelConfig.get(25) - 1) {
            level = 24;
        }else {
            // 此用户已成仙
            level = 25;
        }
        return level;
    }

    /**
     * 2019年4月15日 01:04:02
     *
     * @param levelValue 等级值
     * @return experience 经验值
     * @author Longmao
     * 根据用户等级获取用户对应经验值
     */
    public static int getExperienceByUserLevel(Integer levelValue) {
        // 默认经验0
        int experience = 0;

        if ( levelValue == null ||levelValue < NumberUtils.INTEGER_ZERO ) {
            return experience;
        }
        switch (levelValue) {
            case 0:
                experience = levelConfig.get(0);
                break;
            case 1:
                experience = levelConfig.get(1);
                break;
            case 2:
                experience = levelConfig.get(2);
                break;
            case 3:
                experience = levelConfig.get(3);
                break;
            case 4:
                experience = levelConfig.get(4);
                break;
            case 5:
                experience = levelConfig.get(5);
                break;
            case 6:
                experience = levelConfig.get(6);
                break;
            case 7:
                experience = levelConfig.get(7);
                break;
            case 8:
                experience = levelConfig.get(8);
                break;
            case 9:
                experience = levelConfig.get(9);
                break;
            case 10:
                experience = levelConfig.get(10);
                break;
            case 11:
                experience = levelConfig.get(11);
                break;
            case 12:
                experience = levelConfig.get(12);
                break;
            case 13:
                experience = levelConfig.get(13);
                break;
            case 14:
                experience = levelConfig.get(14);
                break;
            case 15:
                experience = levelConfig.get(15);
                break;
            case 16:
                experience = levelConfig.get(16);
                break;
            case 17:
                experience = levelConfig.get(17);
                break;
            case 18:
                experience = levelConfig.get(18);
                break;
            case 19:
                experience = levelConfig.get(19);
                break;
            case 20:
                experience = levelConfig.get(20);
                break;
            case 21:
                experience = levelConfig.get(21);
                break;
        }
        return experience;
    }

    /**
     * 2019年4月15日 00:11:43
     *
     * @param experienceValue 用户当前经验值
     * @return
     * @author Longmao
     * 根据当前经验值获取当前等级到下一级所需经验百分比
     */
    public static double initProgressValue(int experienceValue) {
        /** 根据现有经验值获取等级值 */
        Integer userLevel = LevelUtil.getContributionLevel(experienceValue);
        /** 根据等级值获取当前等级对应经验 */
        Integer currentLevelExperienceValue = LevelUtil.levelConfig.get(userLevel);
        /** 获取下一级所对应经验值 */
        Integer nextLevelExperienceValue = LevelUtil.levelConfig.get((userLevel + 1));
        if (nextLevelExperienceValue == null) {
            return 0D;
        }
        /** 获取用户当前经验超出当前等级对应经验的值 */
        int restValue = experienceValue - currentLevelExperienceValue;
        /** 获取当前等级到下一级共需要多少经验值 */
        int sumValue = nextLevelExperienceValue - currentLevelExperienceValue;
        /** 获取当前等级到下一级所需经验百分比 */
        double progressValue = (restValue * 1.0) / sumValue;
        // 无论如何给这个百分比赋值
        if (progressValue < 0.01 && progressValue > 0) {
            progressValue = 0.01;
        }
        // 返回百分比
        return (((int) (progressValue * 100)) * 1.0) / 100;
    }

    public static Long getTaskAward(Integer empirical, Integer integralCount) {
        return BigDecimal.valueOf(getContributionlevelCoefficient(getContributionLevel(empirical))).multiply(BigDecimal.valueOf(integralCount)).longValue();
    }

    public static void main(String[] args) {
        System.out.println("s " + getContributionLevel(200000));
	/*	System.out.println("s "+initProgressValue(25));
		System.out.println("s "+initProgressValue(26));
		System.out.println("s "+initProgressValue(30));
		System.out.println("s "+initProgressValue(35));
		System.out.println("s "+initProgressValue(39));
		System.out.println("s "+initProgressValue(40));*/
      /*  System.out.println("s " + initProgressValue(35000));
        System.out.println(levelConfig.get(21) - 1);*/
    }

    public static int getNewLevelFans(String title) {
        if (StringUtils.isEmpty(title)) {
            return 1;
        }
        if (StringUtils.isNumeric(title)) {
            return Integer.parseInt(title);
        } else {
            if (title.equals("初级粉丝")) {
                return 1;
            } else if (title.equals("中级粉丝")) {
                return 2;
            } else if (title.equals("高级粉丝")) {
                return 3;
            } else if (title.equals("进阶粉丝")) {
                return 4;
            } else if (title.equals("活跃粉丝")) {
                return 5;
            } else if (title.equals("忠实粉丝")) {
                return 6;
            } else if (title.equals("铁杆粉丝")) {
                return 7;
            } else if (title.equals("知名粉丝")) {
                return 8;
            } else if (title.equals("人气粉丝")) {
                return 9;
            } else if (title.equals("资深粉丝")) {
                return 10;
            } else if (title.equals("掌门元老")) {
                return 11;
            } else if (title.equals("荣誉元老")) {
                return 12;
            } else if (title.equals("精神领袖")) {
                return 13;
            } else {
                return 1;
            }
        }
    }
}
