package org.example.warehousemanagersystem.study.原型模式;





import java.util.Hashtable;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:创建一个类，从数据库获取实体类，并把它们存储在一个 Hashtable 中。
 * @Version: 1.0
 */


public class ShapeCache {
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);

        return (Shape) cachedShape.clone();

    }

    //对每一种形状都运行数据库查询，并创建该形状
    //shapeMap.put(shapeKey,shape);
    //例如，我们要添加三种形状
    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);
        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);

    }
}
