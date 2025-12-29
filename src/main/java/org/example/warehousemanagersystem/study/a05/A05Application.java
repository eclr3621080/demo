package org.example.warehousemanagersystem.study.a05;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

import java.util.logging.Logger;

public class A05Application {
    private static final Logger log = Logger.getLogger(A05Application.class.getName());
    public static void main(String[] args) {

        GenericApplicationContext ctx = new GenericApplicationContext();
        ctx.registerBean("config", Config.class);
        ctx.registerBean(ConfigurationClassPostProcessor.class); //@ComponentScan @Bean @ImportResource
        ctx.registerBean(MapperScannerConfigurer.class,bd->{
           bd.getPropertyValues().add("basePackage","org.example.warehousemanagersystem.study.a05.mapper");
        });//@mapperscans
        ctx.refresh();
        for (String name : ctx.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        ctx.close();
    }
}
