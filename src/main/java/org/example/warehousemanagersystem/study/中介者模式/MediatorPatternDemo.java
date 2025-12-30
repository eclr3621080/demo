package org.example.warehousemanagersystem.study.中介者模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-23
 * @Description:
 * @Version: 1.0
 */


public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi!John!");
        john.sendMessage("Hi!Robert!");
    }
}
