package org.example.warehousemanagersystem.functionIImterface;

import java.util.function.Consumer;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:java.util.function.Consumer接口与Supplier接口相反，它消费数据，数据类型由泛型执行，接口中只有一个抽象方法accept(T t)，表示消费一个指定泛型的数据。 定义一个方法，参数传递Consumer接口，泛型使用String，Consumer接口进行消费字符串。
 * @Version: 1.0
 */


public class Demo08Lambda {
    public static  void consumerStr(String name, Consumer<String> consumer){
        consumer.accept(name);
    }

    public static void main(String[] args) {
        ////调用consumerStr方法，传递字符串姓名，方法的另一个参数是一个函数式接口，可以传递lambda表达式
        consumerStr("sq",name -> {
            String revName=new StringBuffer(name).reverse().toString();
            System.out.println(revName);
        });
    }
}
