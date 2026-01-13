package org.example.warehousemanagersystem.study.单例工程模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-19
 * @Description:
 *
 * 如果去调用get的时候，返回的是静态的new类，那么返回的是同一个单例，如果是new一个返回，则返回的就不是同一个
 * @Version: 1.0
 */


public class SingletonPatternDemo {
    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数SingleObject() 是不可见的
        //SingleObject object=new SingleObject

        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();
        SingleObject object2 = SingleObject.getInstance2();

        System.out.println(object);
        System.out.println(object2);

        //显示消息
        object.showMessage();

    }
}
