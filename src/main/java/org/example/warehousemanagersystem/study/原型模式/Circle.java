package org.example.warehousemanagersystem.study.原型模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class Circle extends Shape{
    public Circle(){
        type="Circle";
    }
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}
