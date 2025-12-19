package org.example.warehousemanagersystem.study.a04;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-17
 * @Description:
 * @Version: 1.0
 */


public class A04Application {
    public static void main(String[] args) {
        //是一个干净的容器
        GenericApplicationContext context = new GenericApplicationContext();
        //用原始化的方法注册三个bean
        context.registerBean("bean1", Bean1.class);
        context.registerBean("bean2", Bean2.class);
        context.registerBean("bean3", Bean3.class);
        context.registerBean("bean4", Bean4.class);
        //用来解析注解
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class);//@Autowired,@Value
        context.getDefaultListableBeanFactory().setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());//自动装备解析器
        context.registerBean(CommonAnnotationBeanPostProcessor.class);//Resource @PostConstruct @PreDestroy
//        context.registerBean();
        context.refresh();//初始化容器
        context.close();
    }
}
