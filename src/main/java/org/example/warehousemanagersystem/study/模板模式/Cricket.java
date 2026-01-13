package org.example.warehousemanagersystem.study.模板模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:创建扩展了上述类的实体类。
 * @Version: 1.0
 */


public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket initialize");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket startPlay");
    }

    @Override
    void stopPlay() {
        System.out.println("Cricket stopPlay");
    }
}
