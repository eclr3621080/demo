package org.example.warehousemanagersystem.study.抽象工厂模式;

import org.example.warehousemanagersystem.study.序列化.ShapeFactory;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-19
 * @Description:
 * @Version: 1.0
 */


public class FactoryProducer {
   public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        }else if (choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
   }
}
