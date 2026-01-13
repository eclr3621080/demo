package org.example.warehousemanagersystem.study.业务代表模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:实现类
 * @Version: 1.0
 */


public class JMSService implements BusinessService {

    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking JMS Service");
    }
}
