package org.example.warehousemanagersystem.study.A02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-13
 * @Description:
 * @Version: 1.0
 */


public class Bean1 {
    private static final Logger log= LoggerFactory.getLogger(Bean1.class);
    @Autowired
    private Bean2 bean2;

    public Bean2 getBean2() {
        return bean2;
    }

    public void setBean2(Bean2 bean2) {
        this.bean2 = bean2;
    }

    @Autowired
    @Resource(name="bean4")
    private Inter bean3;

    public Inter getInter() {
        return bean3;
    }

}
