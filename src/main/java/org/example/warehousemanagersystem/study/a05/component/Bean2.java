package org.example.warehousemanagersystem.study.a05.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Bean2 {
    private static final Logger logger = LoggerFactory.getLogger(Bean2.class);
    public Bean2() {
        logger.info("Bean2 constructor -0----沈琪");
    }
}
