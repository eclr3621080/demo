package org.example.warehousemanagersystem.study.工厂模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:
 *工厂模式提供了一种创建对象的方式，而无需指定要创建的具体类。
 *
 * 通过使用工厂模式，可以将对象的创建逻辑封装在一个工厂类中，而不是在客户端代码中直接实例化对象，这样可以提高代码的可维护性和可扩展性。
 *
 * 说白了：就是在工厂中以接口类作为返回值，通过if语句，来选择相应的实现类，去new实现类，实现类去调方法
 * @Version: 1.0
 */


public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapFactory shapFactory = new ShapFactory();
        Shape circle = shapFactory.getShape("CIRCLE");

        circle.draw();
        Shape rectangle = shapFactory.getShape("RECTANGLE");
        rectangle.draw();
        Shape square = shapFactory.getShape("SQUARE");
        square.draw();


    }
}
