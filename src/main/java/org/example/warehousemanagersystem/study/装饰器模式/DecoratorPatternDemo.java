package org.example.warehousemanagersystem.study.装饰器模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class DecoratorPatternDemo {
    public static void main(String[] args) {
        //circle 实现类
        Shape circle = new Circle();
        ShapeDecorator redCircle=new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle=new RedShapeDecorator(new Rectangle());

        circle.draw();

        redCircle.draw();

        redRectangle.draw();

    }
}
