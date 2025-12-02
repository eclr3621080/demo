package org.example.warehousemanagersystem.functionIImterface;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:
 * @Version: 1.0
 */


public class Demo01 {
    public static  void show(MyFunctionalInterface myFunctionalInterface) {
        myFunctionalInterface.method();
    }

    public static void main(String[] args) {
        //调用show方法，方法的参数是一个接口，所以可以传递接口的匿名内部类
         show(new MyFunctionalInterface() {

             @Override
             public String  method() {
                 System.out.println("Hello Worldx");
                 return "Hello Worldx";
             }
         });
        //调用show方法，方法的参数是一个函数式接口，所以我们可以使用lambda表达式
         show(()->{
           return "Hello Worldx";
         });

    }
}
