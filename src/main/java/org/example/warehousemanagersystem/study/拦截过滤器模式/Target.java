package org.example.warehousemanagersystem.study.拦截过滤器模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:
 * @Version: 1.0
 */


public class Target {

    public void execute(String request) {
        System.out.println("Execute request:"+ request);
    }
}
