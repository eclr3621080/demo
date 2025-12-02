package org.example.warehousemanagersystem.functionIImterface;

import java.util.function.Supplier;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:java.util.function.Supplier接口仅包含一个无参的方法，：T get()。用来获取一个泛型参数执行类型的数据。该接口被称为生产型接口，指定接口的泛型是什么类型，get方法就会生产什么类型的数据。
 * @Version: 1.0
 */


public class Demo06Lambda {
    public static Integer getString(Supplier<Integer> supplier) {
        return supplier.get();
    }
    public static void main(String[] args) {
        Integer s=getString(()->1);
        System.out.println(s);
    }
}
