package org.example.warehousemanagersystem.study.策略模式;

import io.swagger.v3.oas.annotations.Operation;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 实现接口相乘
 * @Version: 1.0
 */


public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
