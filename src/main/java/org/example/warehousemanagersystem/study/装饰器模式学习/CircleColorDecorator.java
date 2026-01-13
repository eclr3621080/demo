package org.example.warehousemanagersystem.study.装饰器模式学习;

import org.example.warehousemanagersystem.study.装饰器模式.ShapeDecorator;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-07
 * @Description:
 * @Version: 1.0
 */


public class CircleColorDecorator extends ColorDecorator {
 
    public CircleColorDecorator(Color decoratedColor) {
        super(decoratedColor);
    }
    @Override
    public void getColors(){
        decoratedColor.getColors();
        setCircleColor(decoratedColor);
    }

    public void setCircleColor(Color circleColor){
        System.out.println("set circle color");
    }
}
