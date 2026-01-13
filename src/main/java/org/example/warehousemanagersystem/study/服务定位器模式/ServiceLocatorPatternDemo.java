package org.example.warehousemanagersystem.study.服务定位器模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-06
 * @Description: 用于在应用程序中提供一个中心化的服务访问点，用以获取各种服务或资源。
 * @Version: 1.0
 */


public class ServiceLocatorPatternDemo {
    public static void main(String[] args) {
        Service service=ServiceLocator.getService("Service1");
        service.execute();
        service=ServiceLocator.getService("Service2");
        service.execute();
        service = ServiceLocator.getService("Service1");
        service.execute();
        service = ServiceLocator.getService("Service2");
        service.execute();
    }
}
