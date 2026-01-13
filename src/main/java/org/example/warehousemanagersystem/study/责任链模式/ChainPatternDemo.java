package org.example.warehousemanagersystem.study.责任链模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description: 创建不同类型的记录器。
 * 赋予它们不同的错误级别，并在每个记录器中设置下一个记录器。
 * 每个记录器中的下一个记录器代表的是链的一部分。
 * @Version: 1.0
 */


public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers() {
        //输入1 相当于new了 抽象类
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.INFO);
        //输入2
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        //输入3
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.ERROR);
        //组成链表
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        //组成一个链
        AbstractLogger loggerChain  = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO, "Hello World!");

        loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug level information.");
        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}
