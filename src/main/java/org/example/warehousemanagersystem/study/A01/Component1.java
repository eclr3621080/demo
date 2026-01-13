package org.example.warehousemanagersystem.study.A01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-13
 * @Description:
 * @Version: 1.0
 */

@Component
public class Component1 {
    private static final  Logger logger = LoggerFactory.getLogger(Component1.class);

    @Autowired
    private ApplicationContext applicationContext;

    public void register(){
        logger.debug("用户注册");
        applicationContext.publishEvent(new UserRegisteredEvent(this));
    }
}
