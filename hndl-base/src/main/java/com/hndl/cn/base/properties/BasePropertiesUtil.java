package com.hndl.cn.base.properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;


/**
 * <pre>
 *
 *
 * 【标题】:
 * 【描述】: 读取cache.properties文件
 * 【版权】: 湖南达联
 * 【作者】: 赵俊凯
 * 【时间】: 2017年7月26日 下午2:46:02
 * </pre>
 */
public class BasePropertiesUtil extends PropertyPlaceholderConfigurer {

    private static Properties props; // 存取properties配置文件key-value结果

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        BasePropertiesUtil.props = props;
    }

    /**
     * 获取value
     *
     * @param key
     * @return
     * @Description
     * @author 张国栋
     */
    public static String getPropertyValue(String key) {
        return props.getProperty(key);
    }



}
