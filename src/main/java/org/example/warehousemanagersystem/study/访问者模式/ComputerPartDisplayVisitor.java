package org.example.warehousemanagersystem.study.访问者模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 重载不同的实现类
 * @Version: 1.0
 */


public class ComputerPartDisplayVisitor implements ComputerPartVisitor{
    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}
