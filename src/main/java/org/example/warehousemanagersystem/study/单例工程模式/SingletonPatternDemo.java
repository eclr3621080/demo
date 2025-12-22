package org.example.warehousemanagersystem.study.单例工程模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-19
 * @Description:
 * @Version: 1.0
 */


public class SingletonPatternDemo {
    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数SingleObject() 是不可见的
        //SingleObject object=new SingleObject

        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();

        //显示消息
        object.showMessage();

    }
}
