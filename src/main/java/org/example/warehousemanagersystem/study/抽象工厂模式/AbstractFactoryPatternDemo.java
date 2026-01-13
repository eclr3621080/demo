package org.example.warehousemanagersystem.study.抽象工厂模式;

import org.springframework.cglib.proxy.Factory;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-19
 * @Description:
 * 在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象
 *
 *
 * 用抽象类作为返回值，if语句去找到相应的实现类，然后new出来返回，相应的实现类可以调用方法
 * @Version: 1.0
 */


public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        //获取形状Circle的对象
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取形状为 Rectangle 的对象
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        //调用 Rectangle 的 draw 方法
        shape2.draw();
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color red = colorFactory.getColor("RED");
        red.fill();

    }
}
