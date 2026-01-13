package org.example.warehousemanagersystem.study.A02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-13
 * @Description:
 * @Version: 1.0
 */


public class Bean2 {
    private Bean1 bean1;
    private static final Logger log= LoggerFactory.getLogger(Bean2.class);
    public Bean2() {
        log.debug("构造 Bean2()");
    }

    public void setBean1(Bean1 bean1) {
        this.bean1 = bean1;
    }

    public Bean1 getBean1() {
        return bean1;
    }
}
