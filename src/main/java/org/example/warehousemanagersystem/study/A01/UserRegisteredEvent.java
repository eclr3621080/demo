package org.example.warehousemanagersystem.study.A01;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-13
 * @Description:
 * @Version: 1.0
 */


public class UserRegisteredEvent extends ApplicationEvent {
    public UserRegisteredEvent(Object source) {
        super(source);
    }

    public UserRegisteredEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
