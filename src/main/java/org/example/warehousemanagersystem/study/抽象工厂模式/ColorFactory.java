package org.example.warehousemanagersystem.study.抽象工厂模式;

import org.example.warehousemanagersystem.study.序列化.ShapeFactory;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-19
 * @Description:
 * @Version: 1.0
 */


public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String color) {
        if (color==null){
            return null;
        }else if (color.equalsIgnoreCase("RED")) {
            return new Red();
        }else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        }else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }







    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
