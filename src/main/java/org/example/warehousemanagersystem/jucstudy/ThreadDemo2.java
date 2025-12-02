package org.example.warehousemanagersystem.jucstudy;

import java.util.concurrent.Callable;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:
 * @Version: 1.0
 */


public class ThreadDemo2 implements Callable {
    @Override
    public String call() throws Exception {
        return "ThreadDemo2 running";
    }
}
