package org.example.warehousemanagersystem.jucstudy;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:
 * @Version: 1.0
 */

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch辅助类
 * 允许一个或多个线程等待知道在其他线程中执行的一组操作完成的同步辅助
 */
public class demo02 {
    public static void main(String[] args) throws InterruptedException {
        //相当与计数器
        CountDownLatch countDownLatch = new CountDownLatch(5);
        //计数器总数是5，当减少为0，任务才继续向下执行
        for (int i = 0; i < 4; i++) {
                new Thread(()->{
                    System.out.println(Thread.currentThread().getName()+"==>start");
                    countDownLatch.countDown();
                }).start();
        }
        //如果没减到0，线程会卡在这里走不下去了
        countDownLatch.await();
        System.out.println("main线程继续向下执行");
    }
}
