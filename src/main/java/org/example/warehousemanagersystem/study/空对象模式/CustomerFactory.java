package org.example.warehousemanagersystem.study.空对象模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-30
 * @Description: 创建 CustomerFactory 类。
 * @Version: 1.0
 */


public class CustomerFactory {
    public static final String[] names = {"Rob","Joe","Julie"};

    public static AbstractCustomer getCustomer(String name){
        //判断是否有相同名字，创建不同的实体类，
        for (int i = 0; i < names.length; i++){
            if (names[i].equals(name)){
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
