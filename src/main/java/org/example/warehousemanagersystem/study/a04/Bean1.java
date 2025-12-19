package org.example.warehousemanagersystem.study.a04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-17
 * @Description:
 * @Version: 1.0
 */

@Component
public class Bean1 {
    private static final Logger logger = LoggerFactory.getLogger(Bean1.class);

    private Bean2 bean2;

    @Autowired
    public void setBean2(Bean2 bean2) {
        logger.info("@Autowired Bean2 init---------{}",bean2);
        this.bean2 = bean2;
    }
    private Bean3 bean3;
    @Resource
    public void setBean3(Bean3 bean3) {
        logger.info("@Resource Bean3 init----------{}",bean3);
        this.bean3 = bean3;
    }
    private String name;

    @Autowired
    public void setHome(@Value("${JAVA_HOME}") String  name) {
        logger.info("@Value----sethome{}",name);
        this.name = name;
    }
    //初始化
    @PostConstruct
    public void init() {
        logger.info("init初始化");
    }
    //摧毁
    @PreDestroy
    public void destroy() {
        logger.info("摧毁");
    }
}
