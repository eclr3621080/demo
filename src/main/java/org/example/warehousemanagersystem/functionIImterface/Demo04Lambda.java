package org.example.warehousemanagersystem.functionIImterface;

/**
 * 假设有一个startThread方法使用Runnable接口作为参数
 */
public class Demo04Lambda {
    //定义一个方法startThread，方法的参数使用函数式接口Runnable
    public static void startThread(Runnable runnable) {
        new Thread(runnable).start();
    }

    public static void main(String[] args) {
        //方法的参数是一个接口，可以传递这个接口的匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        //方法的参数是一个函数式接口，可以传递lambda表达式
        startThread(()-> System.out.println(Thread.currentThread().getName()));
    }
}
