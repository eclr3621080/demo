package org.example.warehousemanagersystem.study.解释器模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-23
 * @Description:
 * @Version: 1.0
 */


public class TerminalExpression implements Expression {
    private String data;
    public TerminalExpression(String data) {
        this.data = data;
    }
    @Override
    public boolean interpret(String context) {
        //判断是否包含
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
