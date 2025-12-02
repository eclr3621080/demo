package org.example.warehousemanagersystem.jucstudy;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:
 * @Version: 1.0
 */


public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        System.out.println(queue.size());
        System.out.println(queue.offer("d"));
        System.out.println(queue.offer("a"));
        System.out.println(queue.poll());
        System.out.println("----------------------");

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        //java.util.NoSuchElementException
        System.out.println(queue.remove());

    }
}
