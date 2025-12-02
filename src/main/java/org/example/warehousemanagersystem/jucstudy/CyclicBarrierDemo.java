package org.example.warehousemanagersystem.jucstudy;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:允许一组线程全部等待彼此达到共同屏障点的同步辅助
 * //加法计数器
 * @Version: 1.0
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
       CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
           System.out.println("集齐7个龙珠，召唤神龙");
       });

       for (int i = 0; i < 7; i++) {
           int temp=i;
           new Thread(()->{
               System.out.println(Thread.currentThread().getName()+"收集"+temp+"个龙珠");

           try {
               cyclicBarrier.await();
           }catch (Exception e){
               e.printStackTrace();
           }
           }).start();
       }
    }
}
