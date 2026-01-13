package org.example.warehousemanagersystem.study.享元模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class FlyweightPattern {
    private static final String colors[]=  { "Red", "Green", "Blue", "White", "Black" };


    public static void main(String[] args) {
        //一次输出数据
        for (int i=0;i<colors.length;i++){
            //每次输入一个值
            Circle circle= (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            //画出来
            circle.draw();
        }

    }

    private static String getRandomColor(){
        return colors[(int)(Math.random()*colors.length)];

    }
    private static int getRandomX(){
        return (int)(Math.random()*100);
    }

    private static int getRandomY(){
        return (int)(Math.random()*100);
    }
}
