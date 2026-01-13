package org.example.warehousemanagersystem.study.策略模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:实现接口相减
 * @Version: 1.0
 */


public class OperationSubtract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
