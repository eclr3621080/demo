package org.example.warehousemanagersystem.study.单例工程模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-19
 * @Description:
 * @Version: 1.0
 */


public class SingleObject {
    //创建一个SingleObject 对象
    private static SingleObject instance=new SingleObject();
    // 让构造函数未private ，这样该类就不会被实例化
    private SingleObject(){}

    //获取唯一可用的对象
    public static SingleObject getInstance(){
        return instance;
    }
    //获取唯一可用的对象
    public static SingleObject getInstance2(){
        return instance;
    }
    public void showMessage(){
        System.out.println("Hello World!");
    }
}
