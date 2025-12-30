package org.example.warehousemanagersystem.study.空对象模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-30
 * @Description:
 * @Version: 1.0
 */


public class CustomerFactory {
    public static final String[] names = {"Rob","Joe","Julie"};

    public static AbstractCustomer getCustomer(String name){
        for (int i = 0; i < names.length; i++){
            if (names[i].equals(name)){
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
