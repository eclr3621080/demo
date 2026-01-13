package org.example.warehousemanagersystem.study.访问者模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 旨在将数据结构与在该数据结构上执行的操作分离，从而使得添加新的操作变得更容易，而无需修改数据结构本身。
 * @Version: 1.0
 */


public class VisitorPatternDemo {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());

        Keyboard keyboard = new Keyboard();
        keyboard.accept(new ComputerPartDisplayVisitor());

        Monitor monitor = new Monitor();
        monitor.accept(new ComputerPartDisplayVisitor());

        Mouse mouse = new Mouse();
        mouse.accept(new ComputerPartDisplayVisitor());



    }
}
