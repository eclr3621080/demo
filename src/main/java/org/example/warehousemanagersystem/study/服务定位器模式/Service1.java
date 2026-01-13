package org.example.warehousemanagersystem.study.服务定位器模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-06
 * @Description:
 * @Version: 1.0
 */


public class Service1 implements Service{
    @Override
    public String getName() {
        return "Service1";
    }

    @Override
    public void execute() {
        System.out.println("Executing Service1");
    }
}
