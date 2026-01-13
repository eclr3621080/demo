package org.example.warehousemanagersystem.study.装饰器模式学习;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-07
 * @Description:
 * @Version: 1.0
 */


public class Test {
    public static void main(String[] args) {
        Color greenColors = new GreenColors();

        CircleColorDecorator circleColorDecorator = new CircleColorDecorator(new GreenColors());
        CircleColorDecorator circleColorDecorator1 = new CircleColorDecorator(new RedColor());
        greenColors.getColors();
        circleColorDecorator1.getColors();
        circleColorDecorator.getColors();
    }
}
