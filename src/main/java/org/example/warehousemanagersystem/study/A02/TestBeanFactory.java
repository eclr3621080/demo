package org.example.warehousemanagersystem.study.A02;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-13
 * @Description: 输出结果为config，只有自己定义的bean，如果我们使用@Configuration、@Bean等注解，使用注解标注的bean也不会被扫描
 * 总结：原始的BeanFactory没有解析注解的能力
 * @Version: 1.0
 */


public class TestBeanFactory {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition singleton = BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope("singleton").getBeanDefinition();

        defaultListableBeanFactory.registerBeanDefinition("config", singleton);

        for (String beanName : defaultListableBeanFactory.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

    }
}
