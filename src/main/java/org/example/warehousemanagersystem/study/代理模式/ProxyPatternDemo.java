package org.example.warehousemanagersystem.study.代理模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image=new ProxyImage("test_10mb.jpg");
        image.display();
        System.out.println("");
        image.display();
    }
}
