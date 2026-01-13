package org.example.warehousemanagersystem.study.装饰器模式学习;

import org.example.warehousemanagersystem.study.装饰器模式.ShapeDecorator;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-07
 * @Description:
 * @Version: 1.0
 */


public abstract class ColorDecorator implements Color {
    protected Color decoratedColor;
    public ColorDecorator(Color decoratedColor) {
        this.decoratedColor = decoratedColor;
    }
    @Override
    public void getColors() {
        decoratedColor.getColors();
    }


}
