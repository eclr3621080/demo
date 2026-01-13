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
 * @Description:
 * 如何解决上面出现的问题
 * 解决方案：添加bean的后置处理器
 *
 *
 *总结：bean工厂后置处理器 & bean后置处理器
 *bean工厂后置处理器：补充了一些 bean 定义
 *1.org.springframework.context.annotation.internalConfigurationAnnotationProcessor 解析@Configuration、@Bean注解
 *bean的后置处理器：针对每个bean的生命周期（创建、依赖注入、初始化）提供扩展功能
 *
 * 1.org.springframework.context.annotation.internalAutowiredAnnotationProcessor  解析@Autowired、@Value
 *
 * 2.org.springframework.context.annotation.internalCommonAnnotationProcessor
 *
 * 解析@Resource注解（JavaEE注解，非Spring注解）
 * @Version: 1.0
 */


public class TestBeanFactory03 {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition singleton = BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope("singleton").getBeanDefinition();
        beanFactory.registerBeanDefinition("config", singleton);
        //把后置处理器加到bean工厂
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);

        //BeanFactory 后处理器主要功能，补充了一些bean定义
        //beanFactory.getBeansOfType 根据类型获取多个bean
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().forEach(beanFactoryPostProcessor -> {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);//执行BeanFactory后置处理器
        });
        //Bean后处理器，针对bean的生命周期的各个阶段提供扩展，例如@Autowired @Resource...
        //家里后置处理器和bean工厂的联系
        beanFactory.getBeansOfType(BeanPostProcessor.class).values().forEach(beanFactory::addBeanPostProcessor);

        for (String beanName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        System.out.println("------------");
        System.out.println(beanFactory.getBean(Bean1.class).getBean2());
    }
}
