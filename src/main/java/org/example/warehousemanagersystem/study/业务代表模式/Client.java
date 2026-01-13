package org.example.warehousemanagersystem.study.业务代表模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:
 * @Version: 1.0
 */


public class Client {
    BusinessDelegate businessService;

    public Client(BusinessDelegate businessService){
        //根据不同的接口，床在不同的环境
        this.businessService = businessService;
    }

    public void doTask(){
        businessService.doTask();
    }
}
