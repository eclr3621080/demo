package org.example.warehousemanagersystem.jucstudy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:
 * @Version: 1.0
 */


public class MyCacheLock {
    //voltaile 可见性和有序性
    private volatile Map<String,Object> map=new HashMap<>();
    //读写锁
    private ReadWriteLock lock=new ReentrantReadWriteLock();
    //存，写入的时候只有一个人操作
    public Object get(String key){
        lock.readLock().lock();
        Object o=null;
        try {
            System.out.println(Thread.currentThread().getName()+"读取");
            try{
                TimeUnit.SECONDS.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            o=map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取ok"+o);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
        return o;
    }
    public void put(String key,Object value){
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入完毕");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }
}
