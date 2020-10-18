package com.space.common.util;

import org.springframework.context.ApplicationContext;

/**
 * @Author LUOZHENGCHAO674
 * @Date 2020-1-17 15:00
 */
public class SpringContextUtil {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static String getProperty(String name) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getEnvironment().getProperty(name);
    }
}
