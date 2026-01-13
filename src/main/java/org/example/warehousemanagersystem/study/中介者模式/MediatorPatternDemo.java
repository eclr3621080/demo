package org.example.warehousemanagersystem.study.中介者模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-23
 * @Description:
 * @Version: 1.0
 */


public class MediatorPatternDemo {
    public static void main(String[] args) {
        //添加了用户
        User robert = new User("Robert");
        User john = new User("John");
        //返回了数据
        robert.sendMessage("Hi!John!");
        john.sendMessage("Hi!Robert!");
    }
}
