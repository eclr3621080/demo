package org.example.warehousemanagersystem.study.a05;



import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

public class A05Application {
    private static final Logger log = Logger.getLogger(A05Application.class.getName());
    public static void main(String[] args) throws IOException {

        GenericApplicationContext ctx = new GenericApplicationContext();
        ctx.registerBean("config", Config.class);
//        ctx.registerBean(ConfigurationClassPostProcessor.class); //@ComponentScan @Bean @ImportResourceb  补充到beanFactory
//        ctx.registerBean(MapperScannerConfigurer.class,bd->{
//           bd.getPropertyValues().add("basePackage","org.example.warehousemanagersystem.study.a05.mapper");
//        });//@mapperscans
        //获取config类的注解
//        ctx.registerBean(ComponentScanPostProcessor.class);
//        ctx.registerBean(AtBeanPostProcessor.class);
        ctx.registerBean(MapperPostProcessor.class);
        ctx.refresh();
        for (String name : ctx.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        ctx.close();
    }
}
