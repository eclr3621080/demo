package org.example.warehousemanagersystem.study.服务定位器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-06
 * @Description:
 * @Version: 1.0
 */


public class Cache {
    private List<Service> services;
    public Cache(){
        services=new ArrayList<Service>();
    }
    public Service getService(String serviceName){
        for(Service service: services){
            if (service.getName().equals(serviceName)){
                System.out.println("Returning cached "+serviceName+" object");
                return service;
            }
        }
        return null;
    }

    public void addService(Service newService){
        boolean exists=false;
        for (Service service: services){
            if (service.getName().equalsIgnoreCase(newService.getName())){
                exists=true;
            }
        }
        if (!exists){
            services.add(newService);
        }
    }
}
