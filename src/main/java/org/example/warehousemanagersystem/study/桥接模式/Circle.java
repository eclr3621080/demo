package org.example.warehousemanagersystem.study.桥接模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:创建实现了 Shape 抽象类的实体类。
 * @Version: 1.0
 */


public class Circle extends Shape {
    private int x,y,radius;

    public Circle(int x, int y, int radius,DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    @Override
    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}
