package org.example.warehousemanagersystem.jucstudy;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description: ReadWriteLock维护一对关联的lock，一个用于只读操作，一个用于写入。read lock可以由多个阅读器线程同事经行，只要没有作者，write lock是独家的
 * @Version: 1.0
 */

/**
 * 独占锁(写锁) 一次只能由一个线程占有
 * 共享锁(读锁) 一次可以有多个线程占有
 * readWriteLock
 * 读-读 可以共存
 * 读-写  不能共存
 * 写-写 不能共存
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCacheLock myCacheLock = new MyCacheLock();
        //写入操作
        for (int i = 0; i < 6; i++) {
            int temp=i;
            new Thread(()->{
                myCacheLock.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        //读取操作
        for (int i = 0; i < 6; i++) {
            int temp = i;
            new Thread(() -> {
                myCacheLock.get(temp + "");
            }, String.valueOf(i)).start();
        }
    }
}
