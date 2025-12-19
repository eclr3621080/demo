package org.example.warehousemanagersystem.springboot的启动流程;

import org.springframework.boot.SpringApplicationRunListener;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-02
 * @Description:
 * @Version: 1.0
 */


public class SpringApplicationRunListeners {
    private final Log log;

    private final List<SpringApplicationRunListener> listeners;
    //返回的是一个Collection 类型。也就是说明在 SpringApplicationRunListeners并非代表一个监听器，而是保存了监听器集合
    SpringApplicationRunListeners(Log log, Collection<? extends SpringApplicationRunListener> listeners) {
        this.log = log;
        this.listeners = new ArrayList<>(listeners);
    }

}
