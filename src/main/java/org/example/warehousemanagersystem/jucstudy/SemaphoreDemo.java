package org.example.warehousemanagersystem.jucstudy;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:一个技术信号两。在概念上，信号量维持一组须贺挣
 * @Version: 1.0
 */


public class SemaphoreDemo {
    public static void main(String[] args) {
        //信号旗
        Semaphore semaphore = new Semaphore(3);
        for(int i = 0; i < 6; i++){
            int temp=i;
            new Thread(()->{
                try{
                    semaphore.acquire();//获取
                    System.out.println(temp+"号车抢到车位");
                    TimeUnit.SECONDS.sleep(5);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                    System.out.println(temp+"号车离开车位");
                }
            }).start();
        }
        //semaphore.acquire(); //获取信号量,假设如果已经满了,等待信号量可用时被唤醒
        //
        //semaphore.release(); //释放信号量
        //
        //作用: 多个共享资源互斥的使用!并发限流,控制最大的线程数
    }
}
