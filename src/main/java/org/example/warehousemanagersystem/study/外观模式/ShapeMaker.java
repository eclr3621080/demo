package org.example.warehousemanagersystem.study.外观模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description: 创建一个外观类。
 * @Version: 1.0
 */


public class ShapeMaker {
    private  Shape circle;
    private  Shape rectangle;
    private  Shape square;

    public  ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle() {
        circle.draw();
    }
    public void drawRectangle() {
        rectangle.draw();
    }
    public void drawSquare() {
        square.draw();
    }
}

