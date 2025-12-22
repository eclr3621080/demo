package org.example.warehousemanagersystem.study.原型模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class Square extends Shape{
    public Square(){
        type="Square";
    }

    @Override
    void draw() {
        System.out.println("Drawing Square");
    }
}
