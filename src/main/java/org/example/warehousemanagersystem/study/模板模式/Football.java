package org.example.warehousemanagersystem.study.模板模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:
 * @Version: 1.0
 */


public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football initialize");
    }

    @Override
    void startPlay() {
        System.out.println("Football startPlay");
    }

    @Override
    void stopPlay() {
        System.out.println("Football stopPlay");
    }
}
