package org.example.warehousemanagersystem.study.空对象模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-30
 * @Description:使用一个空对象代替 null 值，这个空对象实现了相同的接口，但对请求不做任何操作或提供默认操作。
 * @Version: 1.0
 */


public class NullpatternDemo {
    public static void main(String[] args) {
        //塞入数据，就行判断
        AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

        System.out.println("Customers");
        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }
}
