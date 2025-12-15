package org.example.warehousemanagersystem.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class TestBeanFactory {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //bean的定义 类型，单例还是多例，有没有初始话，销毁
        AbstractBeanDefinition singleton = BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope("singleton").getBeanDefinition();
        beanFactory.registerBeanDefinition("config", singleton);
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        //作用：给我们beanFactory 增加一些常用的后处理器 ,只是加到bean工厂
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
        //BeanFactory 后处理器主要功能，补充了一些bean定义
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().stream().forEach(beanFactoryPostProcessor ->
                beanFactoryPostProcessor.postProcessBeanFactory(beanFactory));
        //Bean 后处理器，针对bean的生命周期的各个阶段提供扩展，例如@Autowired @Resource。。。这个加会建立联系
        beanFactory.getBeansOfType(BeanPostProcessor.class).values().stream().forEach(beanFactory::addBeanPostProcessor);
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        //把每个单例都依赖注入什么的，准备好所有的单例
        beanFactory.preInstantiateSingletons();
        System.out.println("---------------------------------------");
        System.out.println(beanFactory.getBean(Bean1.class).getInter());
        /**
         * beanFactory不会主动做一些事情
         * 不会主动调用BeanFactory后处理器
         * 不会主动添加bean后处理器
         * 不会主动初始化单例
         * 不会接卸beanFactory 还不会解析${} and #{}
         * bean 后处理器会有排序的逻辑
         *
         */
    }
    @Configuration
    static class Config{
        @Bean
        public Bean1 bean(){
            return new Bean1();
        }
        @Bean
        public Bean2 bean2(){
            return new Bean2();
        }
        @Bean
        public Bean3 bean3(){
            return new Bean3();
        }    @Bean
        public Bean4 bean4(){
            return new Bean4();
        }
    }
    interface Inter{}
    static class Bean3 implements Inter{};
    static class Bean4 implements Inter{};
    static class Bean1 implements Inter{
        private static final Logger log = LoggerFactory.getLogger(Bean1.class);
        public Bean1(){
            log.debug("构造 Bean1()");
        }

//        @Autowired
//        private Bean2 bean2;


        @Autowired
        public Inter bean4;
        public Inter getInter(){
            return bean4;
        }

//        public Bean2 getBean2(){
//            return bean2;
//        }
    }
    static class Bean2 implements Inter{
        private static final Logger log = LoggerFactory.getLogger(Bean2.class);
        public Bean2(){
            log.debug("<构造> Bean2()");
        }
    }
}
