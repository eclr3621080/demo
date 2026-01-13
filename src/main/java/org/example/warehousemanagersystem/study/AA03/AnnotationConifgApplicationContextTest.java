package org.example.warehousemanagersystem.study.AA03;

import org.example.warehousemanagersystem.study.A02.Bean2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-13
 * @Description:
 * @Version: 1.0
 */


public class AnnotationConifgApplicationContextTest {
    //较为经典的容器，基于java配置类来创建
    private static void testAnnotationConifgApplicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        for(String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        System.out.println(context.getBean(Bean2.class).getBean1());
    }


}
