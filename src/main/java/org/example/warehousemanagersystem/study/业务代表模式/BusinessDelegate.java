package org.example.warehousemanagersystem.study.业务代表模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:
 * @Version: 1.0
 */


public class BusinessDelegate {
    //创建业务查询服务。
    private BusinessLookUp lookupService = new BusinessLookUp();
    //创建接口
    private BusinessService businessService;
    //
    private String serviceType;


    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public void doTask(){
        //业务查询服务，获取相应的实现类
        businessService=  lookupService.getBusinessService(serviceType);
        //实现操作
        businessService.doProcessing();
    }
}
