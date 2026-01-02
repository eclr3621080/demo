package org.example.warehousemanagersystem.study.a06;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Configuration
public class MyConfig1 {
    private static final Logger log = LoggerFactory.getLogger(MyConfig1.class.getName());
    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.debug("Setting application context~~~~~~~~~~~~~~~~~~~~~~~~~`");
    }

    @PostConstruct
    public void init() {
        log.debug("Setting application context**************************8");
    }


    @Bean
    public BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return beanFactory -> {
            log.debug("BeanFactoryPostProcessor1%%%%%%%%%%%%%%%%%%%555555555");
        };
    }
}
