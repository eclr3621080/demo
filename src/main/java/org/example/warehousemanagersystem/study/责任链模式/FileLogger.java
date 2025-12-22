package org.example.warehousemanagersystem.study.责任链模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class FileLogger extends AbstractLogger{
    public FileLogger(int level) {
        this.level=level;
    }

    @Override
    protected  void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
