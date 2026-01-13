package org.example.warehousemanagersystem.study.装饰器模式学习;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-07
 * @Description:
 * @Version: 1.0
 */


public class RedColor implements Color {
    @Override
    public void getColors() {
        System.out.println("实现了红色");
    }
}
