package org.example.warehousemanagersystem.jucstudy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:
 * @Version: 1.0
 */


public class MyCache {
    private volatile Map<String,String> map=new HashMap<>();
    public Object get(String key){
        System.out.println(Thread.currentThread().getName()+"读取");
        String s = map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取完毕"+s);
        return s;
    }
    public void put(String key,String value){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入完毕");
    }
}
