package org.example.warehousemanagersystem.study.A02;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-13
 * @Description: BeanFactory总结
 *不会主动调用 BeanFactory 后处理器
 *
 * 不会主动添加 Bean 后处理器
 *
 * 不会主动初始化单例
 *
 * 不会解析beanFactory 还不会解析 ${ } 与 #{ } //$占位符,Spring中的EL表达式
 *
 * 那么BeanFactory不会做的话，AppliactionContext就会自己做
 *
 *
 * @Version: 1.0
 */


public class TestBeanFactory04 {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition singleton = BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope("singleton").getBeanDefinition();

        beanFactory.registerBeanDefinition("singleton", singleton);

        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().forEach(beanFactoryPostProcessor -> {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);//执行BeanFactory后置处理器
        });

        beanFactory.getBeansOfType(BeanPostProcessor.class).values().stream()
                .sorted(beanFactory.getDependencyComparator())
                .forEach(beanPostProcessor -> {
                    System.out.println(">>>"+beanPostProcessor);
                    beanFactory.addBeanPostProcessor(beanPostProcessor);
                });
        for(String beanName : beanFactory.getBeanDefinitionNames()){
            System.out.println(beanName);
        }
        System.out.println(beanFactory.getBean(Bean1.class).getInter());
    }
}
