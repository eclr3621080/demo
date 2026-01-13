package org.example.warehousemanagersystem.study.模板模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 在父类中定义了算法的骨架，并允许子类在不改变算法结构的前提下重定义算法的某些特定步骤。
 * @Version: 1.0
 */


public class TemplatePatternDemo {
    public static void main(String[] args) {
        //创建Cricket，继承Game
        Game game = new Cricket();
        game.play();
        System.out.println("----------");
        //创建Football，继承Game
        game = new Football();
        game.play();

    }
}
