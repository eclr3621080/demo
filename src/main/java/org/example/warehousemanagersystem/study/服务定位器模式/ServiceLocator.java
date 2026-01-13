package org.example.warehousemanagersystem.study.服务定位器模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-06
 * @Description:
 * @Version: 1.0
 */


public class ServiceLocator {
    private static Cache cache;

    static{
        cache = new Cache();
    }

    public static Service getService(String jndiName){
        Service service = cache.getService(jndiName);
        if(service != null){
            return service;
        }
        InitialContext context = new InitialContext();
        Service newService = (Service) context.lookup(jndiName);
        cache.addService(newService);
        return newService;
    }

}
