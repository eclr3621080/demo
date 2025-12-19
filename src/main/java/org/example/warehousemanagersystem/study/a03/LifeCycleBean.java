package org.example.warehousemanagersystem.study.a03;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-17
 * @Description:
 * @Version: 1.0
 */

@Component("LifeCycleBean")
public class LifeCycleBean {
    private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);
    //构造
    public LifeCycleBean() {
        log.info("LifeCycleBean created");

    }
    //注入
    @Autowired
    public void autowire(@Value("${JAVA_HOME}") String home) {
        log.info("autowire started");
    }
    //初始化
    @PostConstruct
    public void init() {
        log.info("init初始化");
    }
    //摧毁
    @PreDestroy
    public void destroy() {
        log.info("摧毁");
    }
}
