package org.example.warehousemanagersystem.study.业务代表模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 创建业务查询服务。
 * @Version: 1.0
 */


public class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType) {
        //分类
        if (serviceType.equalsIgnoreCase("EJB")) {
            return new EJBService();
        }else {
            return new JMSService();
        }
    }
}
