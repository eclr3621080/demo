package org.example.warehousemanagersystem.study.责任链模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class ConsoleLogger extends AbstractLogger{
    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }

    public ConsoleLogger(int level) {
        this.level=level;
    }
}
