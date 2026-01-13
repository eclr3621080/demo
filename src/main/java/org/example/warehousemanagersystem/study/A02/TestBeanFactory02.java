package org.example.warehousemanagersystem.study.A02;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-13
 * @Description:
 * @Version: 1.0
 */


public class TestBeanFactory02 {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        AbstractBeanDefinition singleton = BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope("singleton").getBeanDefinition();

        defaultListableBeanFactory.registerBeanDefinition("config", singleton);

        //添加后置处理器，但此时后置处理器并没有启用
        AnnotationConfigUtils.registerAnnotationConfigProcessors(defaultListableBeanFactory);
        //BeanFactory 后处理器主要功能，补充了一些bean定义
        //beanFactory.getBeansOfType 根据类型获取多个bean
        defaultListableBeanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().forEach(beanFactoryPostProcessor -> {
                    beanFactoryPostProcessor.postProcessBeanFactory(defaultListableBeanFactory);//执行BeanFactory后置处理器
                }
        );
        for (String beanName : defaultListableBeanFactory.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        System.out.println("-----------------");
        System.out.println(defaultListableBeanFactory.getBean(Bean1.class).getBean2());

    }
}
