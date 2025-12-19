package org.example.warehousemanagersystem.study.序列化;

import org.example.warehousemanagersystem.study.抽象工厂模式.*;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-19
 * @Description:
 * @Version: 1.0
 */


public class ShapeFactory extends AbstractFactory {


    @Override
    public Shape getShape(String shapeType) {
         if (shapeType==null){
             return null;
         }
        else  if (shapeType.equalsIgnoreCase("Circle")) {
            return new Circle();
        }
        else if (shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        }
        else if (shapeType.equalsIgnoreCase("Square")) {
            return new Square();
        }
        return null;
    }



    @Override
    public Color getColor(String color) {
        return null;
    }


}
