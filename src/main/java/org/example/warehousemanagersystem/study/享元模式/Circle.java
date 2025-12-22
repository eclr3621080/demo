package org.example.warehousemanagersystem.study.享元模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;
    public Circle(String color){
        this.color = color;
    }
    public void  setX(int x){
        this.x = x;
    }
    public void  setY(int y){
        this.y = y;
    }
    public void  setRadius(int radius){
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color
                +", x : " + x +", y :" + y +", radius :" + radius);
    }
}
