package org.example.warehousemanagersystem.jucstudy;

import org.springframework.stereotype.Component;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:
 * @Version: 1.0
 */

@Component
public class ThreadDemo extends Thread{
    @Override
    public void run(){
        System.out.println("ThreadDemo run");
    }
}
