package org.example.warehousemanagersystem.study.原型模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class Rectangle extends Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method");
    }

    public Rectangle(){
        type="Rectangle";
    }
}
