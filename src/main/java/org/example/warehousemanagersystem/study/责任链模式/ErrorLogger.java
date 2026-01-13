package org.example.warehousemanagersystem.study.责任链模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class ErrorLogger extends AbstractLogger{
     //给抽象类一个level的值
    public ErrorLogger(int level) {
        this.level=level;
    }
    //实现write方法
    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
