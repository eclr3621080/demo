package org.example.warehousemanagersystem.study.A01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-13
 * @Description:
 * BeanFactory是ApplicationContext的父接口，它是Spring的核心容器
 * ApplicationContext间接继承了BeanFactory，通过组合的方式(BeanFactory是ApplicationContext的一个成员变量，
 * ApplicationContext的部分给你是直接调用BeanFactory的给你，getBean，对BeanFactory的功能提供了一些扩展
 *
 * 实际上，控制反转，基本的依赖注入，直至Bean的生命周期的各种功能，都由BeanFactory的实现类提供。
 *
 * DefaultListableBeanFactory管理所有对象（尤其是管理单例对象），是BeanFactory的一个实现
 * DefaultSingletonBeanFactory管理所有的单例对象
 * @Version: 1.0
 */

@Component
public class BeanFactoryAndApplicationContext {
    @Autowired
    private static ApplicationContext context; // 自动注入
    //获取所有以component开头的单例对象
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanFactoryAndApplicationContext.class);
        ConfigurableListableBeanFactory beanFactory = (ConfigurableListableBeanFactory) context.getAutowireCapableBeanFactory();
        Map<String, Object> map = (Map<String, Object>) singletonObjects.get(beanFactory);
        map.entrySet().stream().filter(e -> e.getKey().startsWith("component"))
                .forEach(e -> {
                    System.out.println(e.getKey() + "=" + e.getValue());
                });

    }
}
