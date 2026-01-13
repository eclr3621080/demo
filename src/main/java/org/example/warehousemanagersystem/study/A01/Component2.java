package org.example.warehousemanagersystem.study.A01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-13
 * @Description:
 * @Version: 1.0
 */

@Component
public class Component2 {
    private static Logger logger = LoggerFactory.getLogger(Component2.class);
    @EventListener
    public void aaa(UserRegisteredEvent event) {
        logger.debug("{}", event);
        logger.debug("发送短信");
    }
}
