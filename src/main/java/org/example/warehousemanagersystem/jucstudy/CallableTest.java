package org.example.warehousemanagersystem.jucstudy;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:
 * @Version: 1.0
 */


public class CallableTest {
    //FutureTask只能使用Callable
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new ThreadDemo2());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
