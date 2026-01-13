package org.example.warehousemanagersystem.study.原型模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description: 使用原型实例指定要创建对象的种类，并通过拷贝这些原型创建新的对象。
 * @Version: 1.0
 */


public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape  = ShapeCache.getShape("1");
        System.out.println("Shape:"+clonedShape.getType());

        Shape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape:"+clonedShape2.getType());

        Shape clonedShape3 = ShapeCache.getShape("3");
        System.out.println("Shape:"+clonedShape3.getType());


    }
}
