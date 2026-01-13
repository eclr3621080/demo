package org.example.warehousemanagersystem.study.策略模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 通过进入的不同参数，来实现不同的算法
 * @Version: 1.0
 */


public class Context {
    private Strategy strategy;
    public Context(Strategy strategy) {
        //使得环境与入参相同
        this.strategy = strategy;
    }
    //根据不同的环境，可以进入不同的实现
    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }

}
