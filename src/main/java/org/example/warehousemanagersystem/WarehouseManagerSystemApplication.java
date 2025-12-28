package org.example.warehousemanagersystem;

import cn.dev33.satoken.SaManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;


import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
public class WarehouseManagerSystemApplication {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ConfigurableApplicationContext context = SpringApplication.run(WarehouseManagerSystemApplication.class, args);

        System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
        /*
        到底什么是BeanFactory
           它是 ApplicationContext的父接口
           他才是Spring的核心容器，主要的ApplicationContext实现都组合了他的功能
         */
        System.out.println(context);

        /**
         * BeanFactory能干点啥
         * 表面上只有getBean
         * 世界上控制反转、基本的依赖注入、直至bean的生命周期的各种功能，都有它的实现类提供
         */
        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        System.out.println(singletonObjects.get(beanFactory));
        Map<String,Object> o =(Map<String,Object> ) singletonObjects.get(beanFactory);
    /*    o.forEach((k,v)->{
            System.out.println(k+":"+v);
        });*/
        System.out.println(context.getEnvironment().getProperty("java_home"));
    }

}
