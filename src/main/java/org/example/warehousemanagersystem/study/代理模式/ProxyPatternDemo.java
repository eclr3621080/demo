package org.example.warehousemanagersystem.study.代理模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:为其他对象提供一种代理以控制对这个对象的访问。
 * @Version: 1.0
 */


public class ProxyPatternDemo {
    public static void main(String[] args) {
        RealImage image1 = new RealImage("ceshi1");

        image1.display();
        ProxyImage image=new ProxyImage("ceshi1er");
        image.getRealImage(image1);
        image.display();


    }
}
