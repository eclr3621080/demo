package org.example.warehousemanagersystem.study.责任链模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:允许将请求沿着处理者链传递，直到请求被处理为止。创建抽象的记录器类。
 * @Version: 1.0
 */


public  abstract  class AbstractLogger {
    public static int INFO=1;
    public static int DEBUG=2;
    public static int ERROR=3;

    protected int level;

    protected  AbstractLogger nextLogger;
    //塞了一个抽象类，组成链表
    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }
    public void logMessage(int level,String message){
        if (this.level==level){
            write(message);
        }
        if (nextLogger != null){
            nextLogger.logMessage(level,message);
        }
    }

    abstract protected void write(String message);
}
